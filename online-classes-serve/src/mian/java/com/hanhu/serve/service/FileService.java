package com.hanhu.serve.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hanhu.serve.entity.File;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hanhu
 * @since 2022-02-14
 */
public interface FileService extends IService<File> {

    /**
     * 关键词搜索文件
     * @param keywords
     * @return
     */
    List<File> getFileByKeyWords(String keywords);
}
