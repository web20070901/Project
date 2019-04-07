package com.wangyulong.fxmall.goods.service.impl;

import com.wangyulong.fxmall.commons.info.SystemConstantsUtils;
import com.wangyulong.fxmall.goods.bean.WxbGood;
import com.wangyulong.fxmall.goods.dao.IGoodDAO;
import com.wangyulong.fxmall.goods.dao.impl.GoodsDAOImpl;
import com.wangyulong.fxmall.goods.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service
public class GoodsServiceImpl implements IGoodsService {

//    @Autowired
    private GoodsDAOImpl goodDAO = new GoodsDAOImpl();

    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) {
        if(page < 1){
            throw new IndexOutOfBoundsException("页码不能小于1");
        }
        int index = (page-1)* SystemConstantsUtils.Page.PAGE_SIZE;
        List<WxbGood> wxbGoods = goodDAO.queryGoodsByPage(index);
        return wxbGoods;
    }

    @Override
    public void inGoods(WxbGood wxbGood){

        goodDAO.inGoods(wxbGood);
    }
}
