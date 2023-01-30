package com.hanhu.serve.controller;


import com.hanhu.serve.entity.Grades;
import com.hanhu.serve.entity.Major;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.service.GradesService;
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
@RequestMapping("/system/grade")
public class GradesController extends BaseController {

    @Autowired
    private GradesService gradesService;


    /**
     * 获取所有班级
     * @return
     */
    @ApiOperation(value = "获取所有班级")
    @GetMapping("/")
    public List<Grades> getAllMajor(){
        return gradesService.list();
    }

    /**
     * 添加专业
     * @param grades
     * @return
     */
    @ApiOperation(value = "添加班级")
    @PostMapping("/")
    public RespBean addMajor(@RequestBody Grades grades){
        if(gradesService.save(grades)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 更新专业信息
     */
    @ApiOperation(value = "更新班级信息")
    @PutMapping("/")
    public RespBean updateMajor(@RequestBody Grades grades){
        if(gradesService.updateById(grades)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public RespBean deleteMajor(@PathVariable Integer id){
        if(gradesService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

}

