package com.hanhu.serve.controller;


import com.hanhu.serve.entity.Menu;
import com.hanhu.serve.service.AdminService;
import com.hanhu.serve.service.MenuService;
import io.swagger.annotations.ApiOperation;
import onway.org.cn.comm.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hanhu
 * @since 2022-01-29
 */

@RestController

//路径为“系统管理”的路径
@RequestMapping("/system/cfg")
public class MenuController{

    @Autowired
    private MenuService menuService;


    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/menu")
    public List<Menu> getMenusByAdminId(){
        //方法参数从后端获取，security全局对象，只要登陆，一直存在
        return menuService.getMenusByAdminId();
    }

}

