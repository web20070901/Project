package com.wangyulong.fxmall.goods.dao;

import com.wangyulong.fxmall.goods.bean.WxbGood;


import java.util.List;

public interface IGoodDAO {
    List<WxbGood> queryGoodsByPage(Integer page);
    void inGoods(WxbGood wxbGood);
}
