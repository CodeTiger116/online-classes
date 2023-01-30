package com.hanhu.serve.controller;

import com.hanhu.serve.entity.Admin;
import com.hanhu.serve.entity.AdminLoginParam;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * 登录
 *
 * 前端传用户名和密码，既然只传用户名和密码，单独准备一个实体类来接受而不用admin来传，可以继续拓展。
 * 前端传完用户名和密码，后端先去登录，用springsecurity自带的userdetailservices里面的loaduserbyuesername方法
 *    登陆成功后返回一个token，不成功继续登录
 * 返回token之后，前端把token放在请求头，之后每一次请求都会携带请求头，
 * 准备一个专门的token的拦截器，判断携带的token是否是有效的
 * 如果是有效的才允许访问其他接口
 *
 *
 *
 * 退出
 * 直接判断返回给前端一个200的状态码，前段判断是否收到200的状态码，收到之后把token删除，则后面再访问接口就会被拦截
 */

@Slf4j
@Api(tags = "LoginController")
@RestController
public class LoginController {



    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody  AdminLoginParam adminLoginParam, HttpServletRequest request){
        System.out.println(adminLoginParam.getUsername()+adminLoginParam.getPassword()+adminLoginParam.getCode());
        System.out.println(request);
        return adminService.login(adminLoginParam.getUsername(),adminLoginParam.getPassword(),adminLoginParam.getCode(),request);
    }


    @ApiOperation(value = "获取当前登录用户的信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal){
        if(null == principal){
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
        //角色权限判断
        admin.setRoles(adminService.getRoles(admin.getId()));
        return admin;
    }



    //退出登录在前端处理
    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    public  RespBean logout(){
        return RespBean.success("注销成功");
    }
}
