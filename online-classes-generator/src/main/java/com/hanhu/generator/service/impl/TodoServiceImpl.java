package com.hanhu.generator.service.impl;

import com.hanhu.generator.entity.Todo;
import com.hanhu.generator.mapper.TodoMapper;
import com.hanhu.generator.service.TodoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanhu
 * @since 2022-02-02
 */
@Service
public class TodoServiceImpl extends ServiceImpl<TodoMapper, Todo> implements TodoService {

}
