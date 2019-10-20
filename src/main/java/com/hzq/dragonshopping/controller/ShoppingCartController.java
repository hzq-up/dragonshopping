package com.hzq.dragonshopping.controller;

import com.hzq.dragonshopping.entity.ProduceEntity;
import com.hzq.dragonshopping.entity.ShoppingCartEntity;
import com.hzq.dragonshopping.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/shoppingcart/")
public class ShoppingCartController {

    @Autowired
    private IShoppingCartService shoppingCartService;

    /**
     * 展示用户购物车详情页面
     * @param request
     * @return
     */
    @RequestMapping("mycart.do")
    public Object showMyCart(HttpServletRequest request, Model model){

        Map<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("user_id")!=null){
            Integer uid = (Integer) request.getSession(true).getAttribute("user_id");
            if(shoppingCartService.getAllShopingCart(uid).size()>0){
                map.put("code","1");
                map.put("mycartlist",shoppingCartService.getAllShopingCart(uid));
            }else {
                map.put("code","0");
            }
        }else {
            map.put("code","0");
            map.put("mycartlist","用户未登录！");
        }
        System.out.println("显示购物车code====="+map.get("code"));
        model.addAttribute("cartlist",map);
        return "mycart";
    }

    /**
     * 检查库存是否够用
     * @param produceEntity
     * @return
     */
//    @RequestMapping("producecount.do")
//    @ResponseBody
//    public Object checkProduceCount(ProduceEntity produceEntity,HttpServletRequest request, HttpSession httpSession) {
//        Map<String, Object> map = new HashMap<>();
//        if (request.getSession(true).getAttribute("user_id") != null) {
//            if (shoppingCartService.checkProduceCount(produceEntity).size() > 0) {
//                map.put("code", 1);
//            } else {
//                map.put("code", 0);
//            }
//        }else {
//            //未登录
//            map.put("code",3);
//        }
//        System.out.println("producecount.do======="+map.get("code"));
//        return map;
//    }

    /**
     * 增加商品到购物车
     * @return
     */
    @ResponseBody
    @RequestMapping("addshoppingcart.do")
    public Object addShoppingCart(ShoppingCartEntity shoppingCartEntity,HttpServletRequest request, HttpSession httpSession){
        //获取用户id
        Integer uid = (Integer) request.getSession(true).getAttribute("user_id");
        System.out.println("uid=========="+uid);
        shoppingCartEntity.setUser_id(uid);
        System.out.println(shoppingCartEntity.toString());
//        boolean flag = shoppingCartService.addShoppingCart(shoppingCartEntity);
        Map<String,Object> map = new HashMap<>();
        ProduceEntity produceEntity = new ProduceEntity();
        produceEntity.setProduce_id(shoppingCartEntity.getProduce_id());
        produceEntity.setProduce_count(shoppingCartEntity.getCart_produce_count());
        if (request.getSession(true).getAttribute("user_id") != null) {
            map = shoppingCartService.addShoppingCart(shoppingCartEntity);
        }else {
            //未登录
            map.put("codemsg","3");
            System.out.println("未登录,code"+3);
        }
        return map;
    }

}

