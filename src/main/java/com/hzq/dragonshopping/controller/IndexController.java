package com.hzq.dragonshopping.controller;

import com.hzq.dragonshopping.service.IProduceCategoryService;
import com.hzq.dragonshopping.service.IProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private IProduceService produceService;
    @Autowired
    private IProduceCategoryService iProduceCategoryService;


    /**
     * 热门商品
     * @param model
     * @return
     */
    @RequestMapping("index.do")
    public String viewHotCommody(Model model){
        //热门商品信息
        Model produce = model.addAttribute("produceList", produceService.showHotCommody());
        //所有商品的分类信息
        model.addAttribute("produceCategory",iProduceCategoryService.selectProduceCategoryExample());
        return "index";
    }

}
