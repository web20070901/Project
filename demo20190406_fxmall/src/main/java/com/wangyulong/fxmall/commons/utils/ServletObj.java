package com.wangyulong.fxmall.commons.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServletObj {

    public static <T> T  getService(Class<T> clazz){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        T bean = classPathXmlApplicationContext.getBean(clazz);
        return bean;
    }
}
