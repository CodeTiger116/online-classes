package com.hanhu.serve.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanhu.serve.entity.PostComment;
import com.hanhu.serve.entity.PostCommentListItem;
import com.hanhu.serve.mapper.PostCommentMapper;
import com.hanhu.serve.service.PostCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanhu
 * @since 2022-03-19
 */
@Service
public class PostCommentServiceImpl extends ServiceImpl<PostCommentMapper, PostComment> implements PostCommentService {
    @Autowired
    private PostCommentMapper postCommentMapper;
    @Override
    public List<PostCommentListItem> getCommentByPostId(Integer id) {

        return postCommentMapper.getCommentByPostId(id);
    }
}
