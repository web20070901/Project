package com.wangyulong.user.service;

import com.wangyulong.commons.exception.PasswordErrorException;
import com.wangyulong.commons.exception.UsernameNotFoundException;
import com.wangyulong.user.vo.UserInfoVO;

public interface IUserInfoService {
    UserInfoVO login(UserInfoVO userInfoVO) throws PasswordErrorException, UsernameNotFoundException;
}
