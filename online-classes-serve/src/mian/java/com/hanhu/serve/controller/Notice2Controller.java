package com.hanhu.serve.controller;


import com.hanhu.serve.entity.Grades;
import com.hanhu.serve.entity.Notice;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.service.NoticeService;
import io.swagger.annotations.ApiOperation;
import onway.org.cn.comm.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
@RequestMapping("/notice/info")
public class Notice2Controller extends BaseController {

    @Autowired
    private NoticeService noticeService;

    @ApiOperation(value = "查询所有")
    @GetMapping("/")
    public List<Notice> getAllNotice(){
        return noticeService.list();
    }



    @ApiOperation(value = "新增通知")
    @PostMapping("/")
    public RespBean addNotice(@RequestBody Notice notice){

        notice.setCreateDate(LocalDateTime.now());
        notice.setUpdateDate(LocalDateTime.now());

        if(noticeService.save(notice)){
            return  RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }


    @ApiOperation(value = "更新通知信息")
    @PutMapping("/")
    public RespBean updateNotice(@RequestBody Notice notice){

        notice.setUpdateDate(LocalDateTime.now());

        if(noticeService.updateById(notice)){
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("/{id}")
    public RespBean deleteNotice(@PathVariable Integer id){
        if(noticeService.removeById(id)){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }
}

