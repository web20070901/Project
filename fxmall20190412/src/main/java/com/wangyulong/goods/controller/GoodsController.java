package com.wangyulong.goods.controller;

import com.wangyulong.goods.po.WxbGood;
import com.wangyulong.goods.service.IGoodsService;
import com.wangyulong.goods.vo.ImageInfoVO;
import com.wangyulong.goodsSku.po.WxbGoodSku;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class GoodsController {

    @Autowired
    private IGoodsService goodService;
    private Logger logger = Logger.getLogger(GoodsController.class);

    @RequestMapping("/queryGoodsByPage")
    public String queryGoodsByPage(int page, HttpSession httpSession ,Model model){
        page = page == 0 ? 1 : page;
        List<WxbGood> wxbGoods = null;
        try {
            wxbGoods = goodService.queryGoodsByPage(page);
        } catch (Exception e) {
            e.printStackTrace();
            //跳转错误页面
            logger.error(e.getMessage());
        }
        Integer pageNum = goodService.getPageNum();
        model.addAttribute("goodsList",wxbGoods);
        model.addAttribute("pageNum",pageNum);
        return "goodsList.jsp";
    }

    @PostMapping("/addGoods")
    public String addGoods(WxbGood wxbGood, WxbGoodSku wxbGoodSku){
        //通过UUID来获得商品的id
        String goodId = UUID.randomUUID().toString().substring(0, 8);
        //wxbGoodSku
        wxbGoodSku.setGoodId(goodId);
        wxbGoodSku.setSkuId(UUID.randomUUID().toString().substring(0,8));
        wxbGoodSku.setSkuName(wxbGood.getSkuTitle());
        System.out.println(wxbGoodSku);
        //wxbGood
        wxbGood.setGoodId(goodId);
        wxbGood.setCreateTime(new Timestamp(new Date().getTime()));
        wxbGood.setCustomerId("69609206");
        wxbGood.setState(0);
        wxbGood.setCreateTime(new Timestamp(new Date().getTime()));
        wxbGood.setToped(0);
        wxbGood.setRecomed(0);
        wxbGood.setRecomedTime(new Timestamp(new Date().getTime()));
        wxbGood.setTopedTime(new Timestamp(new Date().getTime()));
        wxbGood.setIswxpay(1);
        wxbGood.setIsfdfk(1);
        wxbGood.setLeixingId(7);
        wxbGood.setKfqq("321123");
        System.out.println(wxbGood);
        try {
            goodService.addGoods(wxbGood,wxbGoodSku);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/queryGoodsByPage?page=1";
    }
    @GetMapping("queryGoodsById")
    public String queryGoodsById(String goodId, HttpSession httpSession)throws Exception{
        WxbGood wxbGood = goodService.queryGoodsById(goodId);
        httpSession.setAttribute("goods",wxbGood);
        return "goodsInfo.jsp";
    }

    @ResponseBody
    @PostMapping("upload")
    public ImageInfoVO upload(MultipartFile[] uploadFile){
        ImageInfoVO imageInfoVO = new ImageInfoVO();
        String filename = "";
        InputStream inputStream = null;
        for (MultipartFile file:uploadFile){
            try {
                if (!file.isEmpty()){
                    filename = file.getOriginalFilename();
                    inputStream = file.getInputStream();
                }
                String substring = filename.substring(filename.lastIndexOf("."));
                String storeName = UUID.randomUUID().toString()+substring;
                FTPClient client = new FTPClient();
                client.connect("192.168.53.254",21);
                boolean login = client.login("anonymous", "786025135@qq.com");
                System.out.println(login);
                if (!client.isRemoteVerificationEnabled()){
                    System.out.println("connect is failure");
                }
                client.setFileType(FTPClient.BINARY_FILE_TYPE);
                client.makeDirectory("images");
                client.changeWorkingDirectory("images");
                client.storeFile(storeName,inputStream);
                client.logout();
                imageInfoVO.setCode(1);
                imageInfoVO.setData("http://localhost:80/images/"+storeName);
            } catch (IOException e) {
                e.printStackTrace();
                imageInfoVO.setCode(0);
                imageInfoVO.setData("添加失败");
            }
        }
        return imageInfoVO;
    }
}
