package com.hzq.dragonshopping.controller;

import com.hzq.dragonshopping.service.IProduceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor;

@Controller
@RequestMapping("/producecategory/")
public class ProduceCategoryController {
    @Autowired
    private IProduceCategoryService produceCategoryService;

    /**
     * 显示分类商品信息
     * @return
     */
//    @RequestMapping("produce.do")
//    public Object showProduceCategory(Model model){
//        model.addAttribute("produceCategory",produceCategoryService.selectProduceCategoryExample());
//        return "index";
//    }

    /**
     * 根据商品类别id查询所有商品详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("selectCategoryAll/{id}")
    public Object showAllProduceCategoryAll(@PathVariable("id") int id,Model model){
        /*AbstractMessageConverterMethodProcessor*/
         System.out.println("id================"+id);
         model.addAttribute("produce",produceCategoryService.selectProduceCategoryExampleByCategoryId(id));
         return "product_category";
    }

}
