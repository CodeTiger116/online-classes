package com.hanhu.serve.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanhu.serve.entity.Post;
import com.hanhu.serve.entity.PostListItem;
import com.hanhu.serve.mapper.PostMapper;
import com.hanhu.serve.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanhu
 * @since 2022-03-16
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Override
    public List<PostListItem> getPost(String column) {
        return postMapper.getPost(column);
    }

    @Override
    public PostListItem getPostById(Integer id) {
        return postMapper.getPostById(id);
    }
}
