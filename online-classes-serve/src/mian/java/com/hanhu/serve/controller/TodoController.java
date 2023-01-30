package com.hanhu.serve.controller;


import com.hanhu.serve.AdminUtils;
import com.hanhu.serve.entity.Admin;
import com.hanhu.serve.entity.Major;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.entity.Todo;
import com.hanhu.serve.service.TodoService;
import io.swagger.annotations.ApiOperation;
import onway.org.cn.comm.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hanhu
 * @since 2022-02-02
 */
@RestController
@RequestMapping("/serve/todo")
public class TodoController extends BaseController {


    @Autowired
    private TodoService todoService;

    @ApiOperation(value = "添加待办")
    @PostMapping("/")
    public RespBean addToDo(@RequestBody Todo todo){
        Admin admin =  AdminUtils.getCurrentAdmin();
        todo.setAdminId(admin.getId());
        if(todoService.save(todo)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }


    @ApiOperation("查询我的所有待办")
    @GetMapping("/{adminId}")
    public List<Todo> getMyAllToDo(@PathVariable Integer adminId){
        return todoService.getMyAllToDo(adminId);
    }

    @ApiOperation("修改待办状态")
    @GetMapping("/change/{id}")
    public RespBean changeToDoStatus(@PathVariable  Integer id){
        return todoService.changeToDoStatus(id);
    }

    @ApiOperation("删除单个待办")
    @DeleteMapping("/{id}")
    public RespBean deleteById(@PathVariable Integer id){
        if(todoService.removeById(id)){
            return RespBean.success("删除成功");
        }else{
            return  RespBean.error("删除失败");
        }
    }


    @ApiOperation("删除我的全部已完成待办")
    @DeleteMapping("/deleteAll/{adminId}")
    public void deleteAllDone(@PathVariable Integer adminId){
        todoService.removeWhenIsFinished(adminId);
    }




}

