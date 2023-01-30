package com.hanhu.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanhu.serve.entity.PostComment;
import com.hanhu.serve.entity.PostCommentListItem;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanhu
 * @since 2022-03-19
 */
public interface PostCommentService extends IService<PostComment> {

    List<PostCommentListItem> getCommentByPostId(Integer id);
}
