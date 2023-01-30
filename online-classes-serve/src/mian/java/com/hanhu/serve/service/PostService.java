package com.hanhu.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanhu.serve.entity.Post;
import com.hanhu.serve.entity.PostListItem;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanhu
 * @since 2022-03-16
 */
public interface PostService extends IService<Post> {

    List<PostListItem> getPost(String column);

    PostListItem getPostById(Integer id);
}
