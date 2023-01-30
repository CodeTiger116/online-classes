package com.hanhu.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.entity.Todo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanhu
 * @since 2022-02-02
 */
public interface TodoService extends IService<Todo> {

    /**
     * 查询我的所有待办
     * @return
     */
    List<Todo> getMyAllToDo(Integer adminId);

    /**
     * 改变待办状态
     * @return
     */
    RespBean changeToDoStatus(Integer id);

    /**
     * 删除所有已完成待办
     */
    void removeWhenIsFinished(Integer adminId);


}
