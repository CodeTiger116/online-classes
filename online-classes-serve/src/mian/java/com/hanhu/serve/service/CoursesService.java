package com.hanhu.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanhu.serve.entity.Admin;
import com.hanhu.serve.entity.Courses;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanhu
 * @since 2022-02-02
 */
public interface CoursesService extends IService<Courses> {

    /**
     * 根据课程id查询学生
     * @param cid
     * @return
     */
    List<Admin> getAdminByCourseId(Integer cid, Integer n);

    /**
     * 根据用户id查询课程
     * @param id
     * @return
     */
    List<Courses> getCourseByAdminId(Integer id);


}
