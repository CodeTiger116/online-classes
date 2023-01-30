package com.hanhu.serve.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanhu.serve.entity.RespPageBean;
import com.hanhu.serve.entity.Students;
import com.hanhu.serve.mapper.StudentsMapper;
import com.hanhu.serve.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanhu
 * @since 2022-02-03
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements StudentsService {


    @Autowired
    StudentsMapper studentsMapper;




    /**
     * 获取所有员工（分页）
     * @param currentPage  当前页面
     * @param size   页面大小 默认10
     * @param students  学生（admin）对象
     * @param beginDateScope   入学日期范围
     * @return
     */
    @Override
    public RespPageBean getAllStudentsByPage(Integer currentPage, Integer size, Students students, LocalDate[] beginDateScope) {
        //开启分页
        Page<Students> page = new Page<>(currentPage,size);
        IPage<Students> allStudentsByPage =  studentsMapper.getAllStudentsByPage(page, students, beginDateScope);
        RespPageBean respPageBean = new RespPageBean(allStudentsByPage.getTotal(),allStudentsByPage.getRecords());
        System.out.println("---------------"+allStudentsByPage.getTotal()+allStudentsByPage.getRecords());

        return respPageBean;
    }


}
