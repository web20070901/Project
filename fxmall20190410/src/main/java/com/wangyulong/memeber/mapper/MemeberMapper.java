package com.wangyulong.memeber.mapper;

import com.wangyulong.memeber.po.WxbMemeber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface MemeberMapper {

    WxbMemeber checkUsername(@Param("username") String username);
}
