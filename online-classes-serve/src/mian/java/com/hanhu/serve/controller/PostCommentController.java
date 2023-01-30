package com.hanhu.serve.controller;


import com.hanhu.serve.entity.Post;
import com.hanhu.serve.entity.PostComment;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.service.PostCommentService;
import com.hanhu.serve.service.PostService;
import io.swagger.annotations.ApiOperation;
import onway.org.cn.comm.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hanhu
 * @since 2022-03-19
 */
@RestController
@RequestMapping("/postComment/info")
public class PostCommentController extends BaseController {

    @Autowired
    private PostCommentService  postCommentService;

    @ApiOperation(value = "创建评论")
    @PostMapping("/")
    public RespBean addCourse(@RequestBody PostComment postComment){
        postComment.setCreateTime(LocalDateTime.now());
        if(postCommentService.save(postComment)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "获取评论评论")
    @GetMapping("/{postId}")
    public RespBean getCourse(@PathVariable Integer postId){
        return RespBean.success("获取成功",postCommentService.getCommentByPostId(postId));
    }
}

