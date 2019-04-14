package com.wangyulong.goods.mapper;

import com.wangyulong.goods.po.WxbGood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<WxbGood> queryGoodsByPage(@Param("index") Integer index,@Param("size") Integer size);
    WxbGood queryGoodsById(@Param("goosId") String goodId);
    List<WxbGood> queryAllGoods();
    /*插入方法，通过返回值判断插入是否成功*/
    int addGoods(WxbGood wxbGood);

}
