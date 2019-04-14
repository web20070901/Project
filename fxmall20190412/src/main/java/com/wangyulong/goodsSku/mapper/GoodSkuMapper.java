package com.wangyulong.goodsSku.mapper;

import com.wangyulong.goodsSku.po.WxbGoodSku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodSkuMapper {

    List<WxbGoodSku> queryAllSku();
    //通过返回值来确认插入是否成功
    int addSku(WxbGoodSku wxbGoodSku);
}
