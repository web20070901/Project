package com.wangyulong.goodsSku.service;

import com.wangyulong.goodsSku.po.WxbGoodSku;

import java.util.List;

public interface IGoodSkuService {

    List<WxbGoodSku> queryAllSku();
    int addSku(WxbGoodSku wxbGoodSku);
}
