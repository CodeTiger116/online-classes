package com.hanhu.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hanhu.serve.entity.Admin;
import com.hanhu.serve.entity.Menu;
import com.hanhu.serve.entity.Students;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 管理员 Mapper 接口
 * </p>
 *
 * @author hanhu
 * @since 2022-01-25
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 通过用户id查询菜单列表
     * @param id
     * @return
     */
    List<Menu> getMenusByAdminId(Integer id);


    /**
     * 获取所有成员（分页）
     * @param page
     * @param admin  学生（admin）对象
     * @param beginDateScope   入学日期范围
     * @return
     */
    IPage<Admin> getAllStudentsByPage(Integer id, Page<Admin> page,@Param("students") Students students,@Param("beginDateScope") LocalDate[] beginDateScope);

    /**
     * 查询学生
     * @param id
     * @return
     */
    List<Admin> getStudent(Integer id);

    /**
     *
     * @param cid
     * @return
     */
    List<Admin> getAdminByCourseId(Integer cid,Integer n);

    /**
     * 在线聊天
     * 根据关键词获取所有成员
     * @param keywords
     * @return
     */
    List<Admin> getChatUser(String keywords);
}
