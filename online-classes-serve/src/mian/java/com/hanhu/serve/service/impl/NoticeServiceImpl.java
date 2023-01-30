package com.hanhu.serve.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanhu.serve.entity.Notice;
import com.hanhu.serve.mapper.NoticeMapper;
import com.hanhu.serve.service.NoticeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanhu
 * @since 2022-02-02
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

}
