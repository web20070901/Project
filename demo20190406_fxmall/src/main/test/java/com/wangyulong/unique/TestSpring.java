package com.wangyulong.unique;

import com.wangyulong.fxmall.goods.bean.WxbGood;
import com.wangyulong.fxmall.goods.service.ISpringGoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestSpring {

    @Autowired
    private ISpringGoodsService goodsService;

    @Test
    public void testCase(){
        System.out.println("》》》》》》》testCase测试《《《《《《《");

      if (goodsService!=null){
          System.out.println("查询到goodsService结果");
          WxbGood wxbGood = goodsService.queryGoodsById("73515420");
          if (wxbGood!=null){
              System.out.println("》》》》》》查到结果《《《《《《");
              System.out.println(wxbGood);
          }else {
              System.out.println("没有结果");
          }
      }else {
          System.out.println("goodsService没有查询到结果");
      }
    }
}
