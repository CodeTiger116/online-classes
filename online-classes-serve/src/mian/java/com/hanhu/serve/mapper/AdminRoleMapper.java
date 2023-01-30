package com.hanhu.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanhu.serve.entity.AdminRole;
import com.hanhu.serve.entity.RespBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hanhu
 * @since 2022-01-29
 */
@Mapper
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    /**
     * 更新用户角色
     * @param adminId
     * @param rids
     * @return
     */
    Integer addAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
