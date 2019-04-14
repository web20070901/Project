package com.wangyulong.user.service.impl;

import com.wangyulong.commons.exception.PasswordErrorException;
import com.wangyulong.commons.exception.UsernameNotFoundException;
import com.wangyulong.user.mapper.UserMapper;
import com.wangyulong.user.service.IUserInfoService;
import com.wangyulong.user.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public UserInfoVO login(UserInfoVO userInfoVO) throws PasswordErrorException, UsernameNotFoundException {
        String username = userInfoVO.getUsername();
        String password = userInfoVO.getPassword();
        if ("".equals(username)||username.length()<1){
            throw new NullPointerException("用户名不能为空");
        }
        UserInfoVO userInfoVO1 = userMapper.checkUsername(username);
        if (userInfoVO1==null){
            throw new UsernameNotFoundException("账号或密码有误");
        }
        if (!userInfoVO1.getPassword().equals(password)){
            throw new PasswordErrorException("账号或密码有误");
        }
        return userInfoVO1;
    }
}
