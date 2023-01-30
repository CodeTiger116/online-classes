package com.hanhu.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanhu.serve.entity.UserCourses;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hanhu
 * @since 2022-02-02
 */
@Mapper
public interface UserCoursesMapper extends BaseMapper<UserCourses> {

    /**
     * 添加课程
     * @param adminId
     * @param courseId
     * @return
     */
    Integer insertRecord(Integer adminId, Integer courseId);
}
