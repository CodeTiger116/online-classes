package com.hanhu.generator.service.impl;

import com.hanhu.generator.entity.File;
import com.hanhu.generator.mapper.FileMapper;
import com.hanhu.generator.service.FileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hanhu
 * @since 2022-02-14
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

}
