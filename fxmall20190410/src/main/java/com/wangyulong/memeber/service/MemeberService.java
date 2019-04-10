package com.wangyulong.memeber.service;

import com.wangyulong.memeber.exception.PasswordErrorException;
import com.wangyulong.memeber.exception.UsernameNotFoundException;
import com.wangyulong.memeber.mapper.MemeberMapper;
import com.wangyulong.memeber.po.WxbMemeber;
import com.wangyulong.memeber.utils.MD5Utils;
import com.wangyulong.memeber.vo.LoginInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemeberService {
    @Autowired
    private MemeberMapper memeberMapper;

    public WxbMemeber login(LoginInfoVO loginInfoVO) throws Exception{
        //判断loginInfoVO是否为空，得到前端传值是否成功
        if(loginInfoVO==null){
            throw new NullPointerException(">>>>>>参数为空<<<<<<");
        }
        //通过loginInfoVO对向获取前端的用户名和密码
        String username = loginInfoVO.getUsername();
        String password = loginInfoVO.getPassword();
        //判断用户名是否为空，为空抛出异常
        if (null==username || "".equals(username)){
            throw new NullPointerException(">>>>>>>>>用户名不能为空<<<<<<<<<");
        }
        //通过用户名查询数据库判断用户是否存在
        WxbMemeber wxbMemeber = memeberMapper.checkUsername(username);
        //判断用户是否存在，不存在排除自定义异常
        if (wxbMemeber==null){
            throw new UsernameNotFoundException(">>>>>>>>>>>>用户走丢了<<<<<<<<<<<<<<<");
        }

        //获取密码加密的盐和密码，并使用MD5进行加密操作
        String passwordSalt = wxbMemeber.getName();
        String md5Password = MD5Utils.md5(password,passwordSalt);
        //将加密后的密文和数据库中的密码进行比对
        if (!md5Password.equals(wxbMemeber.getPassword())){
            throw new PasswordErrorException(">>>>>>>密码输入有误，请确认后再输<<<<<<<<");
        }
        return  wxbMemeber;
    }
}
