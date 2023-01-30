package com.hanhu.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.entity.UserCourses;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanhu
 * @since 2022-02-02
 */
public interface UserCoursesService extends IService<UserCourses> {

    /**
     * 删除学生的选课
     * @param adminId
     * @param courseId
     * @return
     */
    RespBean deleteUserCourseByStudentId(Integer adminId, Integer courseId);

    /**
     * 增加学生选课
     * @param adminId
     * @param courseId
     * @return
     */
    RespBean addCourseByStudentId(Integer adminId, Integer courseId);
}
