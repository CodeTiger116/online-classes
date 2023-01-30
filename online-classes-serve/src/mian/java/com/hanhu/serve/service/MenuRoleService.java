package com.hanhu.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanhu.serve.entity.MenuRole;
import com.hanhu.serve.entity.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanhu
 * @since 2022-01-29
 */
public interface MenuRoleService extends IService<MenuRole> {

    /**
     * 更新菜单角色
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
