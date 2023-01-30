package com.hanhu.serve.controller;

import com.hanhu.serve.entity.Admin;
import com.hanhu.serve.entity.ChatMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDateTime;

/**
 * Websocket
 *
 *
 */
//用的是@MessageMapping，所以此处用@Controller
@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleMsg(Authentication authentication, ChatMsg chatMsg){
        //根据authentication获取当前用户对象
        Admin admin = (Admin) authentication.getPrincipal();
        //设置chatMsg的setFrom
        chatMsg.setFrom(admin.getUsername());
        chatMsg.setFormNickName(admin.getName());
        chatMsg.setDate(LocalDateTime.now());
        //发送消息
        simpMessagingTemplate.convertAndSendToUser(chatMsg.getTo(),"/queue/chat",chatMsg);

    }
}
