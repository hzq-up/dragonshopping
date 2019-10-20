package com.hzq.dragonshopping.controller;

import com.hzq.dragonshopping.entity.CommentEntity;
import com.hzq.dragonshopping.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/comment/")
public class ProduceCommentController {
    @Autowired
    private ICommentService commentService;

    /**
     * 添加评论
     * @param commentEntity
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("addcomment.do")
    public Object addComment(CommentEntity commentEntity, HttpServletRequest request){
        Map<String,Object> res_map=new HashMap<String, Object>();
        System.out.println("comment=========="+commentEntity.toString());
        //获取session中的用户信息
        if(request.getSession(true).getAttribute("user_id")!=null){
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            request = ((ServletRequestAttributes)ra).getRequest();
            int user_id = (Integer) request.getSession(true).getAttribute("user_id");
            //给页面用户名id
            res_map.put("produceId",user_id);
            commentEntity.setComments_user_id(user_id);
            //数据库评论是否成功插入数据
            int count= commentService.addComment(commentEntity);
            if(count>0){
                res_map.put("code", 1);
                res_map.put("msg", "添加评论成功,等待审核!");
                System.out.println("添加评论成功,等待审核!");
            }else{
                res_map.put("code", 0);
                res_map.put("msg", "评论失败！");
                System.out.println("评论失败！");
            }
            return res_map;
        }else {
            res_map.put("code", 2);
            res_map.put("msg","添加评论失败,请登录!");
            return res_map;
        }

    }
}
