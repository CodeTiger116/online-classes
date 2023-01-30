package com.hanhu.serve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanhu.serve.entity.MenuRole;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.mapper.MenuRoleMapper;
import com.hanhu.serve.service.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanhu
 * @since 2022-01-29
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements MenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    @Override
    @Transactional
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {

        //System.out.println("---------------"+rid+mids);
        //先删除
        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid",rid));
        //如果传入的mids为空
        if(null == mids || 0 == mids.length){
            return RespBean.success("更新成功！");
        }
        //再添加
        Integer result = menuRoleMapper.insertRecord(rid,mids);
        //System.out.println("----------"+result);
        //System.out.println("----------"+mids.length);
        if(result == mids.length){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败?");
    }
}
