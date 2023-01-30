package com.hanhu.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanhu.serve.entity.PostComment;
import com.hanhu.serve.entity.PostCommentListItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hanhu
 * @since 2022-03-19
 */
@Mapper
public interface PostCommentMapper extends BaseMapper<PostComment> {

    List<PostCommentListItem> getCommentByPostId(Integer id);
}
