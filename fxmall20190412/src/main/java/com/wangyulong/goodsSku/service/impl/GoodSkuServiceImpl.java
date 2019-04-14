package com.wangyulong.goodsSku.service.impl;

import com.wangyulong.goodsSku.mapper.GoodSkuMapper;
import com.wangyulong.goodsSku.po.WxbGoodSku;
import com.wangyulong.goodsSku.service.IGoodSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodSkuServiceImpl implements IGoodSkuService {
    @Autowired
    private GoodSkuMapper goodSkuMapper;
    @Override
    public List<WxbGoodSku> queryAllSku() {
        return goodSkuMapper.queryAllSku();
    }

    //通过返回值确认添加是否成功
    @Override
    public int addSku(WxbGoodSku wxbGoodSku) {
        int i = goodSkuMapper.addSku(wxbGoodSku);
        return 0;
    }
}
