package com.hzq.dragonshopping.controller;

import com.hzq.dragonshopping.entity.ProduceEntity;
import com.hzq.dragonshopping.entity.ShoppingCartEntity;
import com.hzq.dragonshopping.service.IProduceCategoryService;
import com.hzq.dragonshopping.service.IProduceService;
import com.hzq.dragonshopping.service.IShoppingCartService;
import com.sun.corba.se.spi.presentation.rmi.StubAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/produce/",method = {RequestMethod.POST,RequestMethod.GET})
public class ProduceController {

    @Autowired
    private IProduceService produceService;
    @Autowired
    private IProduceCategoryService produceCategoryService;
    @Autowired
    private IShoppingCartService shoppingCartService;


    /**
     * 商品详情和相关评论
     * @return
     */
    @RequestMapping(value = "producdetailsandcomments/{produce_id}")
    public Object showProducDetailsAndComments(@PathVariable("produce_id") int productId, Model model,HttpServletRequest request){
        System.out.println("produceId============="+productId);
        //商品详细信息
//        request.setAttribute("produceDetails",produceCategoryService.selectProduceCategoryExampleByProduceId(productId));
        Model produceDetails= model.addAttribute("produceDetails",produceCategoryService.selectProduceCategoryExampleByProduceId(productId));
        //商品相关评论
        model.addAttribute("comments",produceService.selectProducDetailsAndComments(productId));
        //取出session给前端页面
        if(request.getSession(true).getAttribute("user_id")!=null){

            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            request = ((ServletRequestAttributes)ra).getRequest();
            int session_user_id = (Integer) request.getSession(true).getAttribute("user_id");
            model.addAttribute("session_user_id",session_user_id);
        }
        return "product";
    }

    @ResponseBody
    @RequestMapping("search")
    public Object showSearchProduce(ProduceEntity produceEntity){
        produceEntity.setProduce_name("文学的");
        return produceService.searchProduce(produceEntity);
    }

}
