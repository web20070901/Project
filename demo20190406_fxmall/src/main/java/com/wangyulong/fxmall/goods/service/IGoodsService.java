package com.wangyulong.fxmall.goods.service;

import com.wangyulong.fxmall.goods.bean.WxbGood;

import java.util.List;

public interface IGoodsService {
    List<WxbGood> queryGoodsByPage(Integer page);
    void inGoods(WxbGood wxbGood);
}
