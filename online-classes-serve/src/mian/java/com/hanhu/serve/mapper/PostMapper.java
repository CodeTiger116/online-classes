package com.hanhu.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanhu.serve.entity.Post;
import com.hanhu.serve.entity.PostListItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hanhu
 * @since 2022-03-16
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {

    List<PostListItem> getPost(String column);

    PostListItem getPostById(Integer id);
}
