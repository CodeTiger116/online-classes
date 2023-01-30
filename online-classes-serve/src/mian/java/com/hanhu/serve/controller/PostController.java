package com.hanhu.serve.controller;


import com.hanhu.serve.entity.Courses;
import com.hanhu.serve.entity.Post;
import com.hanhu.serve.entity.PostListItem;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.service.PostService;
import io.swagger.annotations.ApiOperation;
import onway.org.cn.comm.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hanhu
 * @since 2022-03-16
 */
@RestController
@RequestMapping("/post/info")
public class PostController extends BaseController {
    @Autowired
    private PostService postService;

    @ApiOperation(value = "创建帖子")
    @PostMapping("/")
    public RespBean addCourse(@RequestBody Post post){
        post.setCreateTime(LocalDateTime.now());
        post.setUpdateTime(LocalDateTime.now());
        if(postService.save(post)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @ApiOperation(value = "获取帖子")
    @GetMapping("/list/{column}")
    public List<PostListItem> list(@PathVariable String column){
        if("首页".equals(column)){
            return postService.getPost(null);
        }
        return postService.getPost(column);
    }

    @ApiOperation(value = "根据用户id查询该用户选修的课程")
    @GetMapping("/{id}")
    public PostListItem getCourseByAdminId(@PathVariable Integer id){
        return postService.getPostById(id);
    }

}

