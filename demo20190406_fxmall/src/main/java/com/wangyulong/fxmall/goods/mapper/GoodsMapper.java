package com.wangyulong.fxmall.goods.mapper;

import com.wangyulong.fxmall.goods.bean.WxbGood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface GoodsMapper {
    List<WxbGood> queryGoodsByPage(@Param("index") Integer index, @Param("size") Integer size);
    void inGoods(WxbGood wxbGood);
    WxbGood queryGoodsById(@Param("goodId") String goodId);

}
