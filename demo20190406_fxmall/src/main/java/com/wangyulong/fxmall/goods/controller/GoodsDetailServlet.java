package com.wangyulong.fxmall.goods.controller;

import com.wangyulong.fxmall.commons.utils.ApplicationContextUtils;
import com.wangyulong.fxmall.goods.bean.WxbGood;
import com.wangyulong.fxmall.goods.service.ISpringGoodsService;
import com.wangyulong.fxmall.goods.service.impl.SpringGoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoodsDetailServlet extends HttpServlet {

    private ISpringGoodsService goodsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        goodsService = ApplicationContextUtils.getClassPathXmlApplicationContext().getBean(SpringGoodsServiceImpl.class);
        WxbGood wxbGood = goodsService.queryGoodsById("73515420");
        //打印输出确认查找结果是否为空
        System.out.println(wxbGood.getGoodName());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
