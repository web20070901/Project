package com.wangyulong.goods.service;

import com.wangyulong.goods.po.WxbGood;
import com.wangyulong.goodsSku.po.WxbGoodSku;

import java.util.List;

public interface IGoodsService {

    List<WxbGood> queryGoodsByPage(Integer page) throws Exception;
    WxbGood queryGoodsById(String goodId);
    List<WxbGood> queryAllGoods();
    void addGoods(WxbGood wxbGood, WxbGoodSku wxbGoodSku)throws Exception;
    Integer getPageNum();
}
