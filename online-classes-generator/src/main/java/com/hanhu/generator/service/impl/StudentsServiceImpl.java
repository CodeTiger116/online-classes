package com.hanhu.generator.service.impl;

import com.hanhu.generator.entity.Students;
import com.hanhu.generator.mapper.StudentsMapper;
import com.hanhu.generator.service.StudentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanhu
 * @since 2022-02-03
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements StudentsService {

}
