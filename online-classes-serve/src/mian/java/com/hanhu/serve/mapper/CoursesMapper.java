package com.hanhu.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanhu.serve.entity.Courses;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hanhu
 * @since 2022-02-02
 */
@Mapper
public interface CoursesMapper extends BaseMapper<Courses> {

    /**
     * 根据用户id查询课程
     * @param id
     * @return
     */
    List<Courses> getCourseByAdminId(Integer id);
}
