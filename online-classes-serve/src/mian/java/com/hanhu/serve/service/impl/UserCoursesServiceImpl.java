package com.hanhu.serve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.entity.UserCourses;
import com.hanhu.serve.mapper.UserCoursesMapper;
import com.hanhu.serve.service.UserCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanhu
 * @since 2022-02-02
 */
@Service
public class UserCoursesServiceImpl extends ServiceImpl<UserCoursesMapper, UserCourses> implements UserCoursesService {

    @Autowired
    private UserCoursesMapper userCoursesMapper;

    /**
     * 删除学生的单个选课
     * @param adminId
     * @param courseId
     * @return
     */
    @Override
    public RespBean deleteUserCourseByStudentId(Integer adminId, Integer courseId) {

        int result = userCoursesMapper.delete(new QueryWrapper<UserCourses>().eq("adminId",adminId).eq("courseId",courseId));
        if(result == 1){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    /**
     * 增加学生选课
     * @param adminId
     * @param courseId
     * @return
     */
    @Override
    public RespBean addCourseByStudentId(Integer adminId, Integer courseId) {
        Integer result = userCoursesMapper.insertRecord(adminId,courseId);
        if(result == 1){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }
}
