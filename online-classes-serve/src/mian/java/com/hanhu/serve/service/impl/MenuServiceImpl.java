package com.hanhu.serve.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanhu.serve.entity.Admin;
import com.hanhu.serve.entity.Menu;
import com.hanhu.serve.mapper.MenuMapper;
import com.hanhu.serve.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanhu
 * @since 2022-01-29
 */
@Slf4j
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {


    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate<String ,Object> redisTemplate;


    /**
     * 通过用户id查询菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusByAdminId() {

        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();

//        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
//        //从redis获取菜单数据
//        List<Menu> menus = (List<Menu>) valueOperations.get("menu_" + adminId);
//        //System.out.println("--------Redis中数据为"+menus);
//        //如果为空，去数据库获取
//        if(CollectionUtils.isEmpty(menus)){
//            //log.info("-----从数据库中获取的菜单数据--------");
//            //System.out.println("-----从数据库中获取的菜单数据--------");
//            menus = menuMapper.getMenusByAdminId(adminId);
//            valueOperations.set("menu_"+adminId,menus);
//        }

        return menuMapper.getMenusByAdminId(adminId);
    }

    /**
     * 根据角色获取菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusWithRole() {
        return menuMapper.getMenusWithRole();
    }

    /**
     * 获取所有菜单
     * @return
     */
    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }


}
