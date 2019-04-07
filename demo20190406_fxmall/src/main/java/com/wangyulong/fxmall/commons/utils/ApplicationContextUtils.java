package com.wangyulong.fxmall.commons.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationContextUtils {
    private static ClassPathXmlApplicationContext classPathXmlApplicationContext;

   public static void init(){
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }

    public static ClassPathXmlApplicationContext getClassPathXmlApplicationContext() {
        return classPathXmlApplicationContext;
    }

}
