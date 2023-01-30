package com.hanhu.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanhu.serve.entity.Students;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hanhu
 * @since 2022-02-03
 */
@Mapper
public interface StudentsMapper extends BaseMapper<Students> {

    /**
     * 获取所有员工（分页）
     * @param page
     * @param students  学生（admin）对象
     * @param beginDateScope   入学日期范围
     * @return
     */
    IPage<Students> getAllStudentsByPage(Page<Students> page, @Param("students") Students students, @Param("beginDateScope") LocalDate[] beginDateScope);
}
