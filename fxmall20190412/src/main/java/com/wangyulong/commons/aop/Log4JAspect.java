package com.wangyulong.commons.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Log4JAspect {

   private Logger logger = Logger.getLogger(Log4JAspect.class);

   @Around("execution(public * com.wangyulong.*.sersvice.*.*(..))")
   public Object logging(ProceedingJoinPoint proceedingJoinPoint){
       String name = proceedingJoinPoint.getSignature().getName();
       logger.debug("进入方法"+name);
       for (Object obj : proceedingJoinPoint.getArgs()){
           logger.debug(name+"方法中的参数---------->"+obj);
       }
       try {
           Object proceed = proceedingJoinPoint.proceed();
           if (proceed!=null){
               logger.debug(name+"方法的返回值："+proceed);
               return proceed;
           }else {
               logger.debug(null);
           }
       } catch (Throwable throwable) {
           throwable.printStackTrace();
       }

       return null;
   }
}
