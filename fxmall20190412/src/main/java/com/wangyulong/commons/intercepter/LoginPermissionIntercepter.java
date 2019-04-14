package com.wangyulong.commons.intercepter;

import com.wangyulong.user.vo.UserInfoVO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPermissionIntercepter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURL());
        UserInfoVO user = (UserInfoVO) request.getSession().getAttribute("user");
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        if (user == null){
            response.sendRedirect("/login.html");
            return false;
        }
        return true;
    }
}
