package com.hanhu.serve.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.entity.Todo;
import com.hanhu.serve.mapper.TodoMapper;
import com.hanhu.serve.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private TodoMapper todoMapper;

    /**
     * 查询我的所有待办
     * @return
     */
    @Override
    public List<Todo> getMyAllToDo(Integer id) {
        return todoMapper.getMyAllToDo(id);
    }


    /**
     * 修改待办状态
     * @param id
     * @return
     */
    @Override
    public RespBean changeToDoStatus(Integer id) {
        return todoMapper.changeToDoStatus(id);
    }

    /**
     * 删除全部已完成
     */
    @Override
    public void removeWhenIsFinished(Integer adminId) {
        todoMapper.removeAllDone(adminId);
    }


}
