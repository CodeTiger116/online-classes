package com.hanhu.serve.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanhu.serve.entity.Admin;
import com.hanhu.serve.entity.Courses;
import com.hanhu.serve.mapper.AdminMapper;
import com.hanhu.serve.mapper.CoursesMapper;
import com.hanhu.serve.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanhu
 * @since 2022-02-02
 */
@Service
public class CoursesServiceImpl extends ServiceImpl<CoursesMapper, Courses> implements CoursesService {


    @Autowired
    private CoursesMapper coursesMapper;

    @Autowired
    private AdminMapper adminMapper;


    /**
     * 根据课程id查询学生
     * @param cid
     * @return
     */
    @Override
    public List<Admin> getAdminByCourseId(Integer cid,Integer n) {
        return adminMapper.getAdminByCourseId(cid,n);
    }

    /**
     * 根据用户id查询课程
     * @param id
     * @return
     */
    @Override
    public List<Courses> getCourseByAdminId(Integer id) {
        return coursesMapper.getCourseByAdminId(id);
    }


}
