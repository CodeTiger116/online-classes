package com.hanhu.serve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanhu.serve.AdminUtils;
import com.hanhu.serve.config.security.component.JwtTokenUtil;
import com.hanhu.serve.entity.*;
import com.hanhu.serve.mapper.AdminMapper;
import com.hanhu.serve.mapper.AdminRoleMapper;
import com.hanhu.serve.mapper.RoleMapper;
import com.hanhu.serve.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author hanhu
 * @since 2022-01-25
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    //登录之后返回token
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;


    //根据用户名获取用户
    @Autowired
    private AdminMapper adminMapper;


    /**
     * 登录之后返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {

        //验证码
        String captcha =(String) request.getSession().getAttribute("captcha");
        System.out.println("adminserviceilmpl-------"+captcha);
        //如果验证码是空的并且匹配不上（忽略大小写）
        if( StringUtils.isBlank(code) || !captcha.equalsIgnoreCase(code)){
            System.out.println(captcha);
            return RespBean.error("验证码错误,请重新输入");
        }

        System.out.println("验证码匹配成功");


        //登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(null == userDetails || !passwordEncoder.matches(password,userDetails.getPassword())){
            return RespBean.error("用户名或密码不正确");
        }

        if(!userDetails.isEnabled()){
            return RespBean.error("账号被禁用，请联系管理员");
        }


        //更新security登陆用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);


        //生成token
        String token = jwtTokenUtil.generateToken(userDetails);

        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return RespBean.success("登录成功",tokenMap);
    }

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    @Override
    public Admin getAdminByUserName(String username) {

        //链式向后写  .eq("xxx",xxx);
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username", username));
    }

    /**
     * 根据用户id查询角色列表
     * @param adminId
     * @return
     */
    @Override
    public List<Role> getRoles(Integer adminId) {
        return roleMapper.getRoles(adminId);
    }




    /**
     * 获取所有员工（分页）
     * @param currentPage  当前页面
     * @param size   页面大小 默认10
     * @param students  学生（admin）对象
     * @param beginDateScope   入学日期范围
     * @return
     */
    @Override
    public RespPageBean getAllStudentsByPage(Integer currentPage, Integer size, Students students, LocalDate[] beginDateScope) {
        //开启分页
        Page<Admin> page = new Page<>(currentPage,size);
        IPage<Admin> allStudentsByPage =  adminMapper.getAllStudentsByPage(AdminUtils.getCurrentAdmin().getId(),page, students,beginDateScope);
        RespPageBean respPageBean = new RespPageBean(allStudentsByPage.getTotal(),allStudentsByPage.getRecords());

        return respPageBean;
    }

    /**
     * 更新用户角色
     * @param adminId
     * @param rids
     * @return
     */
    @Override
    @Transactional
    public RespBean updateAdminRole(Integer adminId, Integer[] rids) {


        //先删除
        adminRoleMapper.delete(new QueryWrapper<AdminRole>().eq("adminId",adminId));
        Integer result = adminRoleMapper.addAdminRole(adminId,rids);
        if(rids.length == result) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败");
    }

    /**
     * 查询学生
     * @param id
     * @return
     */
    @Override
    public List<Admin> getStudent(Integer id) {
        return adminMapper.getStudent(id);
    }

    /**
     * 更新用户密码
     * @param oldPass
     * @param pass
     * @param adminId
     * @return
     */
    @Override
    public RespBean updateAdminPassword(String oldPass, String pass, Integer adminId) {

        //拿到admin对象，旧密码要和现有的admin里的密码进行比较，旧密码输入正确才能更新密码
        Admin admin = adminMapper.selectById(adminId);
        //输入的是明文，但spring security会进行加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //判断旧密码是否正确

        /*
        System.out.println("输入的旧密码"+oldPass);
        System.out.println("当前密码"+admin.getPassword());
        System.out.println("新密码"+pass);
        System.out.println("加密后新密码"+encoder.encode(pass));
        System.out.println("数据库中的旧密码"+encoder.encode(admin.getPassword()));
        System.out.println("匹配"+encoder.matches(oldPass,admin.getPassword()));
        */

        if(oldPass.equals(admin.getPassword())){
            //旧密码匹配成功，设置新密码
            //新密码要进行加密
            admin.setPassword(encoder.encode(pass));
            int result = adminMapper.updateById(admin);
            if(1 == result){
                return RespBean.success("更新成功");
            }
        }else if(encoder.matches(oldPass,admin.getPassword())){
            //旧密码匹配成功，设置新密码
            //新密码要进行加密
            admin.setPassword(encoder.encode(pass));
            int result = adminMapper.updateById(admin);
            if(1 == result){
                return RespBean.success("更新成功");
            }
            //更新成功后强制下线跳转到登陆页面
            //由前端处理
        }
        return RespBean.error("更新失败");
    }

    /**
     * 更新用户头像
     * @param url
     * @param id
     * @param authentication
     * @return
     */
    @Override
    public RespBean updateAdminUserFace(String url, Integer id, Authentication authentication) {
        //根据id获取对象
        Admin admin = adminMapper.selectById(id);
        admin.setUserFace(url);
        int result = adminMapper.updateById(admin);
        if(1 == result){
            Admin principal = (Admin) authentication.getPrincipal();
            principal.setUserFace(url);
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(admin,null,authentication.getAuthorities()));

            return RespBean.success("更新成功",url);
        }
        return RespBean.error("更新失败");
    }

    /**
     * 在线聊天
     * 根据关键词获取所有成员
     * @param keywords
     * @return
     */
    @Override
    public List<Admin> getChatUser(String keywords) {
        return adminMapper.getChatUser(keywords);
    }


}
