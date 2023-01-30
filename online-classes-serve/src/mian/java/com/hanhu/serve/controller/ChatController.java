package com.hanhu.serve.controller;

import com.hanhu.serve.entity.Admin;
import com.hanhu.serve.service.AdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friend/chat")
public class ChatController {

    @Autowired
    private AdminService adminService;



    /**
     * 在线聊天
     * @param keywords
     * @return
     */
    @ApiOperation(value = "根据关键词搜索成员")
    @GetMapping("/")
    public List<Admin> getChatUser(String keywords){
        return adminService.getChatUser(keywords);
    }
}
