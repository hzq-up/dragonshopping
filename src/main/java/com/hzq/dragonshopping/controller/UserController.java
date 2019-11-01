package com.hzq.dragonshopping.controller;

import com.hzq.dragonshopping.entity.ProduceEntity;
import com.hzq.dragonshopping.entity.UserEntity;
import com.hzq.dragonshopping.service.IUserService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user/")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Autowired
    private IUserService userService;


    /**
     * 登陆
     * @param userEntity
     * @return
     */
    @ResponseBody
    @RequestMapping("login.do")
    public Object userLogin(UserEntity userEntity, HttpServletRequest request){
        UserEntity t_user=userService.login(userEntity);
        Map<String,Object> res_map=new HashMap<String, Object>();
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        request = ((ServletRequestAttributes)ra).getRequest();
        if(t_user!=null){
            res_map.put("code", 1);
            res_map.put("msg", "登录成功");
            res_map.put("data", t_user);
            System.out.println("登陆成功");
            //session存储用户名、密码、用户id
            if(request.getSession(true).getAttribute("username")==null){
                request.getSession(true).setAttribute("username",t_user.getUser_name());
                request.getSession(true).setAttribute("password",t_user.getUser_password());
                request.getSession(true).setAttribute("user_id",t_user.getUser_id());
                System.out.println(request.getSession(true).getAttribute("username").toString());
            }
        }else{
            res_map.put("code", 0);
            res_map.put("msg", "登录失败");
            System.out.println("登陆失败");
        }
//        System.out.println(request.getSession(true).getAttribute("username").toString());
        return res_map;

    }


    /**
     * 注册
     * @param userEntity
     * @return
     */
    @ResponseBody
    @RequestMapping("regist.do")
    public Object regist(UserEntity userEntity){
        int count=userService.regist(userEntity);
        Map<String,Object> res_map=new HashMap<String, Object>();
        if(count>0){
            res_map.put("code", 1);
            res_map.put("msg", "注册成功！");
            System.out.println("注册成功！");
        }else{
            res_map.put("code", 0);
            res_map.put("msg", "注册失败！");
            System.out.println("注册失败！");
        }
        return res_map;
    }

    /**
     * 个人中心
     * @return
     */
    @RequestMapping("center.do")
    public Object userCenter(HttpServletRequest request, HttpSession httpSession,Model model){
//        //获得session
//        if(request.getSession(true).getAttribute("user_id")!=null){
//            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
//            request = ((ServletRequestAttributes)ra).getRequest();
//            int session_user_id = (Integer) request.getSession(true).getAttribute("user_id");
//            model.addAttribute("session_user_id",session_user_id);
//            //清除session
//            httpSession.invalidate();
//            model.addAttribute("msgcode","1");
//        }else if (request.getSession(true).getAttribute("user_id")==null){
//            model.addAttribute("msgcode","0");
//        }
        return "account/index";
    }


    /**
     * 登出
     * @param request
     * @param httpSession
     * @return
     */
    @ResponseBody
    @RequestMapping("loginout.do")
    public Object loginOut(HttpServletRequest request, HttpSession httpSession){
        //获得session
        Map<String,String> map = new HashMap<>();
        if(request.getSession(true).getAttribute("user_id")!=null){
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            request = ((ServletRequestAttributes)ra).getRequest();
            Integer session_user_id = (Integer) request.getSession(true).getAttribute("user_id");
            map.put("session_user_id",session_user_id.toString());
            //清除session
            httpSession.invalidate();
            map.put("msgcode","1");
        }else if (request.getSession(true).getAttribute("user_id")==null){
            System.out.println("000000000");
            map.put("msgcode","0");
        }
        System.out.println("退出登录！");
        return map;
    }

    /**
     * 购买商品
     * @param request
     * @param userEntity
     * @param produceEntity
     * @return
     */
    @ResponseBody
    @RequestMapping("pay.do")
    public Object buyProduce(HttpServletRequest request, UserEntity userEntity, ProduceEntity produceEntity){

        Map<String,Object> map = new HashMap<>();
        if(request.getSession(true).getAttribute("user_id") != null){
            //获取存在session中的id
            Integer uid = (Integer) request.getSession(true).getAttribute("user_id");
            userEntity.setUser_id(uid);
            logger.info("============================="+userEntity.toString()+"\n"+produceEntity.toString());
            map = userService.payProduce(produceEntity,userEntity);
            if (map.get("msgcode") == "1"){
                logger.info("code+msg"+"1支付成功");
            }else {
                logger.info("code+msg"+"0支付失败");
            }
        }else {
            map.put("msgcode","0000");
            logger.info("code+msg"+"0000未登录！");
        }
        return map;
    }


}
