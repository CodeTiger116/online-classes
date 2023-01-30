package com.hanhu.serve.controller;


import com.hanhu.serve.entity.*;
import com.hanhu.serve.service.*;
import io.swagger.annotations.ApiOperation;
import onway.org.cn.comm.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hanhu
 * @since 2022-02-03
 */
@RestController
@RequestMapping("/student")
public class StudentsController extends BaseController {


    @Autowired
    private CoursesService coursesService;

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "根据课程id查询选修该课程的学生")
    @GetMapping("/student/{cid}")
    public List<Admin> getStudentByCourseId(@PathVariable Integer cid){
        return coursesService.getAdminByCourseId(cid,1);
    }

    @ApiOperation(value = "根据课程id查询教学该课程的老师")
    @GetMapping("/teacher/{cid}")
    public List<Admin> getTeacherByCourseId(@PathVariable Integer cid){
        return coursesService.getAdminByCourseId(cid,0);
    }

    /**
     * 查询某学生选修的课程 / 查询某教师教的课程
     * @param id
     * @return
     */
    @ApiOperation(value = "根据用户id查询该用户选修的课程")
    @GetMapping("/course/{id}")
    public List<Courses> getCourseByAdminId(@PathVariable Integer id){
        return coursesService.getCourseByAdminId(id);
    }

    @ApiOperation(value = "获取所有学生(分页) ")
    @GetMapping("/")
    public RespPageBean getAllStudentsByPage2(@RequestParam(defaultValue = "1") Integer currentPage,
                                             @RequestParam(defaultValue = "10") Integer size,
                                             Students students,
                                             LocalDate[] beginDateScope){
        return adminService.getAllStudentsByPage(currentPage,size,students,beginDateScope);

    }

    /**
     * 获取全部课程
     * @return
     */
    @GetMapping("/getAllCou")
    public List<Courses> getAllCourses(){
        return coursesService.list();
    }


}

