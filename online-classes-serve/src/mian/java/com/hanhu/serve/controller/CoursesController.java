package com.hanhu.serve.controller;


import com.hanhu.serve.entity.Admin;
import com.hanhu.serve.entity.Courses;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.entity.RespPageBean;
import com.hanhu.serve.service.AdminService;
import com.hanhu.serve.service.CoursesService;
import io.swagger.annotations.Api;
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
@RequestMapping("/course/info")
public class CoursesController extends BaseController {


    @Autowired
    private CoursesService coursesService;

    @Autowired
    private AdminService adminService;

    @ApiOperation(value = "获取所有课程")
    @GetMapping("/")
    public List<Courses> getAllCourses(){
        return coursesService.list();
    }


    @ApiOperation(value = "添加课程")
    @PostMapping("/")
    public RespBean addCourse(@RequestBody Courses courses){
        if(coursesService.save(courses)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }


    @ApiOperation(value = "更新课程")
    @PutMapping("/")
    public RespBean updateCourse(@RequestBody Courses courses){
        if(coursesService.updateById(courses)){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }


    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public RespBean deleteCourse(@PathVariable Integer id){
        if(coursesService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }




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


}

