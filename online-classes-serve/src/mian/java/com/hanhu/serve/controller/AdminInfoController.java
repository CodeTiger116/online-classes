package com.hanhu.serve.controller;

import com.hanhu.serve.entity.Admin;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.service.AdminService;
import com.hanhu.serve.utils.OssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * 个人中心
 */
@RestController
public class AdminInfoController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private OssUtil ossUtil;


    @ApiOperation(value = "更新当前用户信息")
    @PutMapping("/admin/updateInfo")
    public RespBean updateUser(@RequestBody Admin admin, Authentication authentication){
        if(adminService.updateById(admin)){
            //在数据库中更新之后还要重新构建authentication对象
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(
                    admin,null, authentication.getAuthorities()));

            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    /**
     * 更新密码方法不放在更新用户信息中
     * 因为更新密码后，会要求二次确定，更新成功后会强制退出登录，然后重新登陆
     */
    @ApiOperation(value = "更新用户密码")
    @PutMapping("/admin/password")
    public RespBean updatePassword(@RequestBody Map<String,Object> info){
        String oldPass = (String) info.get("oldPass");
        String pass = (String) info.get("pass");
        Integer adminId = (Integer) info.get("adminId");
        return adminService.updateAdminPassword(oldPass,pass,adminId);
    }

    @ApiOperation(value = "更新用户头像")
    @PostMapping("/admin/userface")
    public RespBean updateAdminUserFace(MultipartFile file, Integer id,Authentication authentication){
        //上传图片方法返回的是图片url
        String url = ossUtil.uploadPic(file);

        return adminService.updateAdminUserFace(url,id,authentication);
    }

}
