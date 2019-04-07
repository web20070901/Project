package com.wangyulong.fxmall.commons.listener;


import com.wangyulong.fxmall.commons.utils.ApplicationContextUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//定义监听器类用来监听服务器的启动
public class TomcatInitListener implements ServletContextListener {

    /**
     * 监听器初始化的方法
     * 容器初始化的方法
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("》》》》》》》》Spring初始化《《《《《《《");
        //调用ApplicationContextUtils定义的静态方法，和项目启动一起完成初始化
        ApplicationContextUtils.init();
    }

    /**
     * 监听器关闭的方法
     * 容器关闭的方法
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
