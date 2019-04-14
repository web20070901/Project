package com.wangyulong.goods.service.impl;

import com.wangyulong.commons.info.Constants;
import com.wangyulong.goods.mapper.GoodsMapper;
import com.wangyulong.goods.po.WxbGood;
import com.wangyulong.goods.service.IGoodsService;
import com.wangyulong.goodsSku.mapper.GoodSkuMapper;
import com.wangyulong.goodsSku.po.WxbGoodSku;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodSkuMapper goodSkuMapper;

    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) throws Exception {
        Logger.getLogger(GoodsServiceImpl.class).info("进入分页查询");
        if (page<1){
            throw new IndexOutOfBoundsException("页面数不能小于1");
        }
        Integer i = (page - 1) * Constants.Page.PAGE_SIZE;
        List<WxbGood> wxbGoods = goodsMapper.queryGoodsByPage(i, Constants.Page.PAGE_SIZE);
        return wxbGoods;
    }

    @Override
    public WxbGood queryGoodsById(String goodId) {
        return goodsMapper.queryGoodsById(goodId);
    }

    @Override
    public List<WxbGood> queryAllGoods() {
        return goodsMapper.queryAllGoods();
    }

    @Override
    public void addGoods(WxbGood wxbGood, WxbGoodSku wxbGoodSku) throws Exception {
        int i = goodsMapper.addGoods(wxbGood);
        goodSkuMapper.addSku(wxbGoodSku);
        if (i<1){
            throw new Exception("数据走丢了");
        }
    }

    @Override
    public Integer getPageNum() {
        return goodsMapper.queryAllGoods().size()%Constants.Page.PAGE_SIZE==0
                ?queryAllGoods().size()/Constants.Page.PAGE_SIZE
                :queryAllGoods().size()/Constants.Page.PAGE_SIZE+1;
    }
}
