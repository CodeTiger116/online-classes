package com.hanhu.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanhu.serve.entity.*;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 * 管理员 服务类
 * </p>
 *
 * @author hanhu
 * @since 2022-01-25
 */
public interface AdminService extends IService<Admin> {

    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);

    /**
     * 根据用户id查询角色列表
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);


    /**
     * 获取所有成员（分页）
     * @param currentPage  当前页面
     * @param size   页面大小 默认10
     * @param admin  学生（admin）对象
     * @param beginDateScope   入学日期范围
     * @return
     */
    RespPageBean getAllStudentsByPage(Integer currentPage, Integer size,Students students, LocalDate[] beginDateScope);

    /**
     * 更新操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    RespBean updateAdminRole(Integer adminId, Integer[] rids);


    /**
     * 查询学生，传id则查询特定学生，如果不传，则查所有
     * @param id
     * @return
     */
    List<Admin> getStudent(Integer id);

    /**
     * 更新用户密码
     * @param oldPass
     * @param pass
     * @param adminId
     * @return
     */
    RespBean updateAdminPassword(String oldPass, String pass, Integer adminId);

    /**
     * 更新 用户头像
     * @param url
     * @param id
     * @param authentication
     * @return
     */
    RespBean updateAdminUserFace(String url, Integer id, Authentication authentication);

    /**
     * 在线聊天
     * 根据关键词获取所有成员
     * @param keywords
     * @return
     */
    List<Admin> getChatUser(String keywords);
}
