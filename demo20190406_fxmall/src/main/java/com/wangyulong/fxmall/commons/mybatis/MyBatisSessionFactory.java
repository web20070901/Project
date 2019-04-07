package com.wangyulong.fxmall.commons.mybatis;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 全局的SessionFactory必须是唯一的
 * 使用单例模式
 */
public class MyBatisSessionFactory {


    /**
     * 一开始就创建唯一对象（饿汉单例）
     */
    public static SqlSessionFactory sqlSessionFactory;

    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    static {
        //通过静态代码块在加载的时候就执行初始化方法
        initSessionFactory();
    }

    /**
     * 创建SessionFactory的静态初始方法
     */
    public static void initSessionFactory(){
        try {
            //加载配置文件
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.cfg.xml");
            //给创建的工厂对象赋值（初始化工厂）
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建SessionFactory的get方法，供外界调用
     * 判断SessionFactory是否为空，不为空直接获取内容，为空则调用初始化方法重新创建
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory == null){
            initSessionFactory();
        }
        return  sqlSessionFactory;
    }

    /**
     * 创建Session的get方法，供外界调用获得Session对象实例
     * @return
     */
    public static SqlSession getSession(){
        //通过threadlocal来获得sqssion对象
        SqlSession sqlSession = threadLocal.get();
        //判断获得session对象是否为空
        if(sqlSession==null){
            //如果为空就通过SessionFactory来获得session实例
            sqlSession = sqlSessionFactory.openSession();
            //并将获得的session实例存入threadLocal中，供下次使用
            threadLocal.set(sqlSession);
        }
        //如果不为空则将获取的实例对象直接返回
        return sqlSession;
    }
}
