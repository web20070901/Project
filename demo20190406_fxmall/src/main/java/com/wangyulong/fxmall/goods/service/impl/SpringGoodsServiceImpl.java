package com.wangyulong.fxmall.goods.service.impl;

import com.wangyulong.fxmall.goods.bean.WxbGood;
import com.wangyulong.fxmall.goods.mapper.GoodsMapper;
import com.wangyulong.fxmall.goods.service.ISpringGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//等同于@Component
public class SpringGoodsServiceImpl implements ISpringGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public WxbGood queryGoodsById(String id) {
       if (goodsMapper!=null){
           System.out.println("goodsMapper不为空，继续执行~~~~~~~~~~~······");
            System.out.println("开始调用查询方法~~~~~~~~~~");
            WxbGood wxbGood = goodsMapper.queryGoodsById(id);
            System.out.println("wxbGood结果是："+wxbGood);
           return wxbGood;
        }else{
           System.out.println("goodsMapper为空，不能继续");
        }
        return null;
    }
}
