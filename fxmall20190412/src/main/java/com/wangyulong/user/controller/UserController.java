package com.wangyulong.user.controller;

import com.wangyulong.commons.exception.PasswordErrorException;
import com.wangyulong.commons.exception.UsernameNotFoundException;
import com.wangyulong.user.service.IUserInfoService;
import com.wangyulong.user.vo.LoginInfoVO;
import com.wangyulong.user.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserInfoService userInfoService;

    @ResponseBody
    @PostMapping("login")
    public LoginInfoVO login(UserInfoVO userInfoVO, HttpSession httpSession){
        String username = userInfoVO.getUsername();
        String password = userInfoVO.getPassword();
        System.out.println(username);
        System.out.println(password);
        LoginInfoVO loginInfoVO = new LoginInfoVO();
        try {
            UserInfoVO user = userInfoService.login(userInfoVO);
            httpSession.setAttribute("user",user);
            loginInfoVO.setCode(1);
            loginInfoVO.setMsg("index.html");
        } catch (PasswordErrorException e) {
            e.printStackTrace();
            loginInfoVO.setCode(0);
            loginInfoVO.setMsg("用户或密码有误");
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            loginInfoVO.setCode(0);
            loginInfoVO.setMsg("用户或密码有误");
        }
        return loginInfoVO;
    }
}
