package com.hanhu.serve.controller;


import com.hanhu.serve.entity.Major;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.service.MajorService;
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
@RequestMapping("/system/major")
public class MajorController extends BaseController {

    @Autowired
    private MajorService majorService;

    /**
     * 单表查询，不需要service，impl
     * @return
     */
    @ApiOperation(value = "获取所有专业")
    @GetMapping("/")
    public List<Major> getAllMajor(){
        return majorService.list();
    }

    /**
     * 添加专业
     * @param major
     * @return
     */
    @ApiOperation(value = "添加专业")
    @PostMapping("/")
    public RespBean addMajor(@RequestBody Major major){
        if(majorService.save(major)){
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 更新专业信息
     */
    @ApiOperation(value = "更新专业信息")
    @PutMapping("/")
    public RespBean updateMajor(@RequestBody Major major){
        if(majorService.updateById(major)){
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
        if(majorService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}

