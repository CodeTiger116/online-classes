package com.hanhu.serve.controller;

import com.hanhu.serve.config.AliYunLiveConfig;
import com.hanhu.serve.entity.Courses;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.service.CoursesService;
import com.hanhu.serve.utils.AliYunLiveUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/live/course")
@Slf4j
public class AliyunLiveController {

    @Autowired
    private AliYunLiveConfig aliyunConfig;

    @Autowired
    private CoursesService coursesService;

    @ApiOperation("地址生成测试")
    @GetMapping("/save_Live")
    public String save_Live(@RequestParam("sourceId") String sourceId){
        //生成推流地址
        String pushUrl = AliYunLiveUtil.createPushUrl(sourceId, aliyunConfig);
        //生成播流地址
        String pullUrl = AliYunLiveUtil.createPullUrl(sourceId, aliyunConfig);
        return pushUrl+"\n"+pullUrl;

    }


    /**
     * 开始上课
     * 教师浏览自己的课程列表，选择其中一个课程，点击“开始上课”
     * 然后后台执行“生成推流播流地址”方法
     * 之后将对应课程的课程状态改为“正在上课”，将播流地址存入对应课程的”课程直播链接“
     * 将”推流地址“返回给教师，让教师手动将推流地址放入OBS
     *
     * 注意，数据库课程id是Int字段，而推流需要的课程号是String字段，需要进行转换
     *
     * @param courseId 课程id，同时充当开启直播时的课程号,即推流地址的StreamName字段
     * @return
     */
    @ApiOperation("开始上课")
    @GetMapping("/startClass/{courseId}")
    public String startClass(@PathVariable Integer courseId){

        //生成推流地址
        String pushUrl = AliYunLiveUtil.createPushUrl(courseId.toString(), aliyunConfig);
        //生成播流地址
        String pullUrl = AliYunLiveUtil.createPullUrl(courseId.toString(), aliyunConfig);
        //根据课程id查找到课程
        Courses courses = coursesService.getById(courseId);
        //更新课程内容，将拉流地址更新，同时将直播状态改为1
        courses.setIsOpen(1);
        courses.setCourseUrl(pullUrl);
        coursesService.updateById(courses);

        //同时返回教师推流地址
        return pushUrl;

    }

    @ApiOperation("下课")
    @GetMapping("/closeClass/{courseId}")
    public RespBean closeClass(@PathVariable Integer courseId){

        //根据课程id查找到课程
        Courses courses = coursesService.getById(courseId);
        //更新课程内容，将拉流地址更新，同时将直播状态改为1
        courses.setIsOpen(0);
        courses.setCourseUrl("");
        if(coursesService.updateById(courses)){
            return RespBean.success("操作成功");
        }else{
            return RespBean.error("操作失败");
        }



    }



}
