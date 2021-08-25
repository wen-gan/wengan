package com.food.controller;

import com.food.domain.Menu;
import com.food.domain.Order;
import com.food.domain.OrderMenu;
import com.food.domain.User;
import com.food.service.IMenuService;
import com.food.service.IOrderMenuService;
import com.food.service.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 */
@SuppressWarnings({"all"})
@Controller
public class OrderController {
    //@Resource是用来实现依赖注入的，@Resource是默认按照byName自动注入
    @Resource
    private IOrderService orderService;
    //@Resource是用来实现依赖注入的，@Resource是默认按照byName自动注入
    @Resource
    private IOrderMenuService orderMenuService;
    //@Resource是用来实现依赖注入的，@Resource是默认按照byName自动注入
    @Resource
    private IMenuService menuService;

    /**
     * 付款下单
     * @param modelAndView
     * @param httpSession
     * @return
     */
    @GetMapping("/pay")
    public ModelAndView insertOrder(ModelAndView modelAndView, HttpSession httpSession){
        User user = (User) httpSession.getAttribute("user");//获取request对象的user属性的属性值
        Order order = new Order();
        order.setQueue(orderService.findAll().get(0).getQueue() + 1);
        order.setCreateTime(new Date());
        order.setStatue("未完成");
        order.setCompletionTime(null);
        order.setTotalMoney((Double) httpSession.getAttribute("totalMoney"));//获取request对象的totalMoney的属性值
        order.setTrueMoney((Double) httpSession.getAttribute("trueMoney"));//获取request对象的trueMoney的属性值
        if (user == null){
            order.setDiscount("无折扣");
            order.setUserId(0);
        }else {
            order.setDiscount(user.getLevel());
            order.setUserId(user.getId());
        }
        orderService.insertOrder(order);
        //获取request对象的orderFoods属性的属性值
        List<Menu> menuList = (List<Menu>) httpSession.getAttribute("orderFoods");//获取request对象的orderFoods的属性值
        List<OrderMenu> orderMenuList = new ArrayList<>();
        for (Menu menu : menuList) {
            OrderMenu orderMenu = new OrderMenu(order.getId(), menu.getId(), menu.getAmount());
            orderMenuList.add(orderMenu);
            menuService.updateSupply(menu.getId(), menu.getSupply()-menu.getAmount());
        }
        orderMenuService.insertOrderMenu(orderMenuList);
        //ModelAndView函数中的RedirectView函数实现使用重新导向将请求重导到指定的位置
        modelAndView.setView(new RedirectView("menu"));
        return modelAndView;
    }

    /**
     * 查看订单
     * @param modelAndView
     * @return
     */
    @GetMapping("/order")
    public ModelAndView getOrder(ModelAndView modelAndView){
        modelAndView.setViewName("order");//进行网页跳转
        List<Order> orderList = orderService.findAllToQueue();
        modelAndView.addObject("orderList",orderList);//返回orderList
        return modelAndView;
    }

    /**
     * 查看订单详情
     * @param sign
     * @param id
     * @param modelAndView
     * @return
     */
    @GetMapping("/orderDetails/{id}/{sign}")
    // @RequestParam 和 @PathVariable 注解是用于从request中接收请求的，
    // 两个都可以接收参数，关键点不同的是@RequestParam 是从request里面拿取值，
    // 而 @PathVariable 是从一个URI模板里面来填充
    public ModelAndView orderDetails(@PathVariable int id, @PathVariable String sign, ModelAndView modelAndView){
        modelAndView.setViewName("orderDetails");//进行网页跳转
        Order order = orderService.findById(id);
        modelAndView.addObject("order",order);//返回order
        modelAndView.addObject("sign",sign);//返回sign
        return modelAndView;
    }

    /**
     * 修改订单状态
     * @param status
     * @param id
     * @param sign
     * @param modelAndView
     * @return
     */
    @GetMapping("/statue/{id}/{sign}")
    // @RequestParam 和 @PathVariable 注解是用于从request中接收请求的，
    // 两个都可以接收参数，关键点不同的是@RequestParam 是从request里面拿取值，
    // 而 @PathVariable 是从一个URI模板里面来填充
    public ModelAndView updateOrderStatus(@RequestParam String statue, @PathVariable int id, @PathVariable String sign,
                                          ModelAndView modelAndView){
        Order order = orderService.findById(id);
        order.setStatue(statue);
        if (statue.equals("未完成")){
            order.setCompletionTime(null);
        }else {
            order.setCompletionTime(new Date());
        }
        orderService.updateOrder(order);
        modelAndView.addObject("order",order);//返回order
        modelAndView.addObject("sign",sign);//返回sign
        //ModelAndView函数中的RedirectView函数实现使用重新导向将请求重导到指定的位置
        modelAndView.setView(new RedirectView("/orderDetails/"+ id +"/sign"));
        return modelAndView;
    }

    /**
     * 修改订单总金额
     * @param totalMoney
     * @param id
     * @param sign
     * @param modelAndView
     * @return
     */
    // @RequestParam 和 @PathVariable 注解是用于从request中接收请求的，
    // 两个都可以接收参数，关键点不同的是@RequestParam 是从request里面拿取值，
    // 而 @PathVariable 是从一个URI模板里面来填充
    @GetMapping("/totalMoney/{id}/{sign}")
    public ModelAndView updateOrderTotalMoney(@RequestParam String totalMoney, @PathVariable int id, @PathVariable String sign,
                                          ModelAndView modelAndView){
        Order order = orderService.findById(id);
        order.setTotalMoney(Double.parseDouble(totalMoney));
        if (order.getDiscount().equals("无折扣")){
            order.setTrueMoney(Double.parseDouble(totalMoney));
        }else if (order.getDiscount().equals("普通")){
            order.setTrueMoney(Double.parseDouble(totalMoney) * 0.9);
        }else if (order.getDiscount().equals("银卡")){
            order.setTrueMoney(Double.parseDouble(totalMoney) * 0.8);
        }else if (order.getDiscount().equals("金卡")){
            order.setTrueMoney(Double.parseDouble(totalMoney) * 0.7);
        }
        orderService.updateOrder(order);
        modelAndView.addObject("sign",sign);//返回sign
        modelAndView.addObject("order",order);//返回order
        //url统一资源定位符号
        //ModelAndView函数中的RedirectView函数实现使用重新导向将请求重导到指定的位置
        modelAndView.setView(new RedirectView("/orderDetails/"+ id +"/sign"));
        return modelAndView;
    }

    /**
     * 进入修改菜单页面
     * @param id
     * @param modelAndView
     * @param httpSession
     * @return
     */
    @GetMapping("/order/menu/{id}")
    // @RequestParam 和 @PathVariable 注解是用于从request中接收请求的，
    // 两个都可以接收参数，关键点不同的是@RequestParam 是从request里面拿取值，
    // 而 @PathVariable 是从一个URI模板里面来填充
    public ModelAndView updateOrderMenu(@PathVariable int id, ModelAndView modelAndView, HttpSession httpSession){
        modelAndView.setViewName("changeMenu");//进行网页跳转
        List<OrderMenu> orderMenuList = orderMenuService.findByOrderId(id);
        for (OrderMenu orderMenu : orderMenuList){
            menuService.updateSupply(orderMenu.getMenuId(), menuService.findByIdOne(orderMenu.getMenuId()).getSupply() + orderMenu.getAmount());
        }
        List<Menu> menuList = menuService.findByAll();
        modelAndView.addObject("menuList",menuList);//返回menuList
        httpSession.setAttribute("id",id);
        return modelAndView;
    }

    /**
     * 修改菜单
     * @param ids
     * @param modelAndView
     * @param request
     * @return
     */
    @GetMapping("/change/menu")
    //@RequestParam是用来传递参数的，用于将请求参数的数据映射到功能处理方法的参数上
    public ModelAndView changeMenu(@RequestParam(required = false) String[] ids, ModelAndView modelAndView, HttpServletRequest request){
        int id = (int) request.getSession().getAttribute("id");//获取request对象的id的属性值
        if (ids == null){
            //url统一资源定位符号
            //ModelAndView函数中的RedirectView函数实现使用重新导向将请求重导到指定的位置
            modelAndView.setView(new RedirectView("/order/menu/" + id));
        }else {
            orderMenuService.deleteByOrderId(id);
            double totalMoney = 0;
            double trueMoney = 0;
            Order order = orderService.findById(id);
            List<Menu> menuList = menuService.findById(ids);
            for (int i = 0; i < menuList.size(); i++){
                int amount = Integer.parseInt(request.getParameter("name-"+menuList.get(i).getId()));
                if (menuList.get(i).getSupply() >= amount){
                    menuList.get(i).setAmount(amount);
                    totalMoney += menuList.get(i).getPrice() * amount;
                }else {
                    //url统一资源定位符号
                    //ModelAndView函数中的RedirectView函数实现使用重新导向将请求重导到指定的位置
                    modelAndView.setView(new RedirectView("/order/menu/" + id));
                    request.getSession().setAttribute("error",true);//error
                    return modelAndView;
                }
            }
            if (order.getDiscount().equals("无折扣")){
                trueMoney = totalMoney;
            }else {
                switch (order.getDiscount()) {
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
            order.setTotalMoney(totalMoney);
            order.setTrueMoney(trueMoney);
            orderService.updateOrder(order);

            List<OrderMenu> orderMenuList = new ArrayList<>();
            for (Menu menu : menuList) {
                OrderMenu orderMenu = new OrderMenu(id, menu.getId(), menu.getAmount());
                orderMenuList.add(orderMenu);
                menuService.updateSupply(menu.getId(), menu.getSupply()-menu.getAmount());
            }
            orderMenuService.insertOrderMenu(orderMenuList);
            //url统一资源定位符号
            //ModelAndView函数中的RedirectView函数实现使用重新导向将请求重导到指定的位置
            modelAndView.setView(new RedirectView("/orderDetails/"+ id +"/sign"));
        }
        return modelAndView;
    }

}
