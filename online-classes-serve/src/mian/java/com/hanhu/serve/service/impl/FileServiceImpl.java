package com.hanhu.serve.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hanhu.serve.entity.File;
import com.hanhu.serve.mapper.FileMapper;
import com.hanhu.serve.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Autowired
    private FileMapper fileMapper;


    /**
     * 关键词搜索文件
     * @param keywords
     * @return
     */
    @Override
    public List<File> getFileByKeyWords(String keywords) {
        return fileMapper.getFileByKeyWords(keywords);
    }
}
