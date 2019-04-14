package com.wangyulong.user.mapper;

import com.wangyulong.user.vo.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    UserInfoVO checkUsername(@Param("userName") String username);
}
