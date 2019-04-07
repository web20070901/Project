package com.wangyulong.fxmall.commons.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class SpringBeans {

    private  static  ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

    @Bean
    public SqlSessionFactory provideSessionFactory() throws IOException{
        InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Scope("prototype")
    @Bean
    public SqlSession provideSession(SqlSessionFactory sqlSessionFactory){
        SqlSession session = threadLocal.get();
        if (session==null){
            session = sqlSessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }
}
