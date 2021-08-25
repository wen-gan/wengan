package com.food.controller;

import com.food.domain.User;
import com.food.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
@Controller
public class UserController {
    //@Resource是用来实现依赖注入的，@Resource是默认按照byName自动注入
    @Resource
    private IUserService userService;

    /**
     * 进入登录页面
     * @param modelAndView
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");//进行网页跳转
        modelAndView.addObject("error",false);
        return modelAndView;
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param modelAndView
     * @return
     */
    // @RequestParam 和 @PathVariable 注解是用于从request中接收请求的，
    // 两个都可以接收参数，关键点不同的是@RequestParam 是从request里面拿取值，
    // 而 @PathVariable 是从一个URI模板里面来填充
    @PostMapping("/login")
    public ModelAndView login(@RequestParam(required = false) String username, @RequestParam(required = false) String password,
                              ModelAndView modelAndView, HttpSession httpSession){
        if (username == null || password == null){
            modelAndView.setViewName("login");//进行网页跳转
        }else {
            User user = userService.findByUsernameAndPassword(username, password);
            if (user == null){
                modelAndView.addObject("error",true);
                modelAndView.setViewName("login");//进行网页跳转
            }else {
                httpSession.setAttribute("user",user);//获取request对象的user的属性值
                //url统一资源定位符号
                //ModelAndView函数中的RedirectView函数实现使用重新导向将请求重导到指定的位置
                modelAndView.setView(new RedirectView("/menu"));
            }
        }
        return modelAndView;
    }

    /**
     * 进入注册页面
     * @param modelAndView
     * @return
     */
    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView){
        modelAndView.setViewName("register");//进行网页跳转
        modelAndView.addObject("error",false);//返回error
        return modelAndView;
    }

    /**
     * 注册
     * @param username
     * @param firstPassword
     * @param secondPassword
     * @param recharge
     * @param modelAndView
     * @return
     */
    // @RequestParam 和 @PathVariable 注解是用于从request中接收请求的，
    // 两个都可以接收参数，关键点不同的是@RequestParam 是从request里面拿取值，
    // 而 @PathVariable 是从一个URI模板里面来填充
    // @PostMapping用于将HTTP post请求映射到特定处理程序的方法注解
    @PostMapping("/register")
    public ModelAndView register(@RequestParam(required = false) String username, @RequestParam(required = false) String firstPassword,
                                 @RequestParam(required = false) String secondPassword, @RequestParam(required = false) String recharge,
                                 ModelAndView modelAndView){
        if (username.isEmpty() || firstPassword.isEmpty() || secondPassword.isEmpty() || !firstPassword.equals(secondPassword)){
            modelAndView.setViewName("register");//进行网页跳转
            modelAndView.addObject("error",true);//返回error
        }else {
            User user = userService.findByUsername(username);
            if (user == null){
                User user1 = new User();
                user1.setUsername(username);
                user1.setPassword(firstPassword);
                if (recharge.isEmpty()){
                    user1.setLevel("普通");
                }else if (Integer.parseInt(recharge) < 200){
                    user1.setLevel("普通");
                }else if (Integer.parseInt(recharge) >= 200 && Integer.parseInt(recharge) < 400){
                    user1.setLevel("银卡");
                }else if (Integer.parseInt(recharge) >= 400){
                    user1.setLevel("金卡");
                }
                userService.insertUser(user1);
                //url统一资源定位符号
                //ModelAndView函数中的RedirectView函数实现使用重新导向将请求重导到指定的位置
                modelAndView.setView(new RedirectView("/login"));
            }else {
                modelAndView.setViewName("register");//进行网页跳转
                modelAndView.addObject("error",true);//返回error
            }
        }
        return modelAndView;
    }

    /**
     * 进入后台管理系统
     * @param modelAndView
     * @return
     */
    @GetMapping("/admin")
    public ModelAndView admin(ModelAndView modelAndView){
        modelAndView.setViewName("admin");//进行网页跳转
        return modelAndView;
    }

}
