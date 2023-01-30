package com.hanhu.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.entity.Todo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 获取我的所有待办
     * @param id
     * @return
     */
    List<Todo> getMyAllToDo(Integer id);

    /**
     * 修改待办状态
     * @return
     */
    RespBean changeToDoStatus(Integer id);

    /**
     * 删除全部已完成
     */
    void removeAllDone(Integer adminId);


}
