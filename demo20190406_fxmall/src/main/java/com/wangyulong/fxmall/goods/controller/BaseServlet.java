package com.wangyulong.fxmall.goods.controller;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServlet;

public class BaseServlet extends HttpServlet {

    protected static ClassPathXmlApplicationContext classPathXmlApplicationContext;

    static {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }
}