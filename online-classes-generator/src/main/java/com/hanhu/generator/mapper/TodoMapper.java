package com.hanhu.generator.mapper;

import com.hanhu.generator.entity.Todo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hanhu
 * @since 2022-02-02
 */
@Mapper
public interface TodoMapper extends BaseMapper<Todo> {

}
