package com.hanhu.serve.controller;


import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.service.UserCoursesService;
import io.swagger.annotations.ApiOperation;
import onway.org.cn.comm.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hanhu
 * @since 2022-02-02
 */
@RestController
@RequestMapping("/serve/user-courses")
public class UserCoursesController extends BaseController {

    @Autowired
    private UserCoursesService userCoursesService;


    @ApiOperation(value = "删除学生的单个选课")
    @DeleteMapping("/{adminId}&{courseId}")
    public RespBean deleteCourseByStudentId(@PathVariable Integer adminId,@PathVariable Integer courseId){
        return userCoursesService.deleteUserCourseByStudentId(adminId,courseId);
    }

    @ApiOperation(value = "增加学生单个选课")
    @GetMapping ("/add")
    public RespBean addCourseByStudentId(Integer adminId,Integer courseId){
        return userCoursesService.addCourseByStudentId(adminId,courseId);
    }

}

