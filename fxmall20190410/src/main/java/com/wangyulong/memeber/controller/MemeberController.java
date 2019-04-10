package com.wangyulong.memeber.controller;

import com.wangyulong.memeber.exception.PasswordErrorException;
import com.wangyulong.memeber.exception.UsernameNotFoundException;
import com.wangyulong.memeber.mapper.MemeberMapper;
import com.wangyulong.memeber.po.WxbMemeber;
import com.wangyulong.memeber.service.MemeberService;
import com.wangyulong.memeber.vo.JsonResultVO;
import com.wangyulong.memeber.vo.LoginInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/memeber")
public class MemeberController {
    @Autowired
    private MemeberService memeberService;

    /***
     * ResponseBody加上此注解，不用管方法return的是什么，将不会做任何的处理和修饰，直接将返回的字符串给用户。
     * @param loginInfoVO
     * @param httpSession
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public JsonResultVO login(LoginInfoVO loginInfoVO, HttpSession httpSession){
        JsonResultVO jsonResultVO = new JsonResultVO();
        System.out.println("---------------进入到方法-----"+jsonResultVO!=null+"---------------------");
        try {
            WxbMemeber wxbMemeber = memeberService.login(loginInfoVO);
            httpSession.setAttribute("wxbMemeber",wxbMemeber);
            jsonResultVO.setCode(1);
        }catch (NullPointerException e){
            e.printStackTrace();
            jsonResultVO.setCode(0);
            jsonResultVO.setMsg("请输入用户名");
        }catch (UsernameNotFoundException | PasswordErrorException e){
            e.printStackTrace();
            jsonResultVO.setCode(0);
            jsonResultVO.setMsg("账号或用户名有误");
        }catch (Exception e) {//预留一个不可预见的异常
            e.printStackTrace();
            jsonResultVO.setCode(0);
            jsonResultVO.setMsg("请联系管理员处理");
        }
        return jsonResultVO;
    }
}
