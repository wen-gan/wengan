package com.food.controller;

import com.food.domain.Menu;
import com.food.domain.User;
import com.food.service.IMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
@Controller
public class MenuController {
    //@Resource是用来实现依赖注入的，@Resource是默认按照byName自动注入
    @Resource
    private IMenuService menuService;

    /**
     * 进入主页
     * @param modelAndView
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(ModelAndView modelAndView){
        modelAndView.setViewName("index");//跳转到index页面
        return modelAndView;
    }

    /**
     * 进入菜单页
     * @param modelAndView
     * @return
     */
    @GetMapping("/menu")
    public ModelAndView getMenu(ModelAndView modelAndView){
        modelAndView.setViewName("menu");//进行网页跳转
        List<Menu> menuList = menuService.findByAll();
        modelAndView.addObject("menuList",menuList);//返回menuList
        return modelAndView;
    }

    /**
     * 进入付款页
     * @param ids
     * @param modelAndView
     * @param request
     * @return
     */
    //@RequestParam是用来传递参数的，用于将请求参数的数据映射到功能处理方法的参数上
    @GetMapping("/order/food")
    public ModelAndView orderFood(@RequestParam(required = false) String[] ids, ModelAndView modelAndView, HttpServletRequest request){
        if (ids == null){
            //ModelAndView函数中的RedirectView函数实现使用重新导向将请求重导到指定的位置
            modelAndView.setView(new RedirectView("/menu"));//进行网页跳转
        }else {
            double totalMoney = 0;
            double trueMoney = 0;
            User user = (User) request.getSession().getAttribute("user");//获取request对象的user属性的属性值
            List<Menu> menuList = menuService.findById(ids);
            for (int i = 0; i < menuList.size(); i++){
                int amount = Integer.parseInt(request.getParameter("name-" + menuList.get(i).getId()));
                if (menuList.get(i).getSupply() >= amount){
                    menuList.get(i).setAmount(amount);
                    totalMoney += menuList.get(i).getPrice() * amount;
                }else {
                    //ModelAndView函数中的RedirectView函数实现使用重新导向将请求重导到指定的位置
                    modelAndView.setView(new RedirectView("/menu"));//进行网页跳转
                    request.getSession().setAttribute("error",true);//error
                    return modelAndView;
                }
            }
            if (user == null){
                trueMoney = totalMoney;
            }else {
                switch (user.getLevel()) {
                    case "普通":
                        trueMoney = totalMoney * 0.9;
                        break;
                    case "银卡":
                        trueMoney = totalMoney * 0.8;
                        break;
                    case "金卡":
                        trueMoney = totalMoney * 0.7;
                        break;
                }
            }
            request.getSession().setAttribute("orderFoods",menuList);//将menuList作为request对象的一个属性存放到orderFoods对象中
            request.getSession().setAttribute("totalMoney",totalMoney);//将totalMoney作为request对象的一个属性存放到totalMoney对象中
            request.getSession().setAttribute("trueMoney",trueMoney);//将trueMoney作为request对象的一个属性存放到trueMoney对象中
            modelAndView.setViewName("pay");//进行网页跳转
        }
        return modelAndView;
    }

    /**
     * 进入后台管理菜单页
     * @param modelAndView
     * @return
     */
    @GetMapping("/menu/admin")
    public ModelAndView getMenuAdmin(ModelAndView modelAndView){
        modelAndView.setViewName("menuAdmin");//进行网页跳转
        List<Menu> menuList = menuService.findByAll();
        modelAndView.addObject("menuList",menuList);//返回menuList
        return modelAndView;
    }

    /**
     * 根据编号查找菜单
     * @param id
     * @param modelAndView
     * @return
     */
    @GetMapping("/find/id")
    //@RequestParam是用来传递参数的，用于将请求参数的数据映射到功能处理方法的参数上
    public ModelAndView findById(@RequestParam(required = false) String id, ModelAndView modelAndView){
        modelAndView.setViewName("menuAdmin");//进行网页跳转
        if (!id.isEmpty()){
            //Pattern() 返回正则表达式的字符串形式，也就是返回Pattern.compile()内的参数0-9
            Pattern pattern = Pattern.compile("[0-9]*");
            //macher类提供了对正则表达式的分组支持，以及对正则表达式的多次匹配支持
            Matcher matcher = pattern.matcher(id);
            if (matcher.matches()){
                Menu menu = menuService.findByIdOne(Integer.parseInt(id));
                List<Menu> menuList = new ArrayList<>();
                menuList.add(menu);
                modelAndView.addObject("menuList",menuList);//返回menuList
            }
        }
        return modelAndView;
    }

    /**
     * 根据菜名查找菜单
     * @param id
     * @param modelAndView
     * @return
     */
    @GetMapping("/find/name")
    //@RequestParam是用来传递参数的，用于将请求参数的数据映射到功能处理方法的参数上
    public ModelAndView findByName(@RequestParam(required = false) String name, ModelAndView modelAndView){
        modelAndView.setViewName("menuAdmin");//进行网页跳转
        if (!name.isEmpty()){
            Menu menu = menuService.findByName(name);
            List<Menu> menuList = new ArrayList<>();
            menuList.add(menu);
            modelAndView.addObject("menuList",menuList);//返回menuList
        }
        return modelAndView;
    }

}
