package com.hanhu.generator.service.impl;

import com.hanhu.generator.entity.Admin;
import com.hanhu.generator.mapper.AdminMapper;
import com.hanhu.generator.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author hanhu
 * @since 2022-02-02
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

}
