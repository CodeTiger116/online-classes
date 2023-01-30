package com.hanhu.serve.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hanhu.serve.entity.Menu;
import com.hanhu.serve.entity.MenuRole;
import com.hanhu.serve.entity.RespBean;
import com.hanhu.serve.entity.Role;
import com.hanhu.serve.service.MenuRoleService;
import com.hanhu.serve.service.MenuService;
import com.hanhu.serve.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 权限组管理
 */
@RestController
@RequestMapping("/system/basic")
public class PermissionController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuRoleService menuRoleService;

    /**
     * 获取所有角色
     */
    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    /**
     * 添加角色
     */

    @ApiOperation(value = "添加角色")
    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if(!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        if(roleService.save(role)){
            return RespBean.success("添加成功!");
        }
        return RespBean.error("添加失败！");
    }

    /**
     * 删除角色
     */
    @ApiOperation(value = "删除角色")
    @DeleteMapping("/role/{rid}")
    public RespBean deleteRole(@PathVariable Integer rid){
        if(roleService.removeById(rid)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败！");
    }
    /**
     * 查询所有菜单
     */
    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return menuService.getAllMenus();
    }

    /**
     * 根据角色id查询菜单id
     */
    @ApiOperation(value = "根据角色id查询菜单id")
    @GetMapping("/mid/{rid}")
    public List<Integer> getMidByRid(@PathVariable Integer rid){
        // .list()返回的是对象，需要返回Integer，用stream流转换
        return menuRoleService.list(new QueryWrapper<MenuRole>()
                .eq("rid",rid))
                .stream()
                .map(MenuRole::getMid)
                .collect(Collectors.toList());
    }

    /**
     * 更新角色菜单
     */
    @ApiOperation(value = "更新角色菜单")
    @GetMapping("/update")
    public RespBean updateMenuRole( Integer rid, Integer[] mids){
        return menuRoleService.updateMenuRole(rid,mids);

    }
}
