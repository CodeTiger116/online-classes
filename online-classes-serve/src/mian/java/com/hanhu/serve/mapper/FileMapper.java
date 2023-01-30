package com.hanhu.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanhu.serve.entity.File;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hanhu
 * @since 2022-02-14
 */
@Mapper
public interface FileMapper extends BaseMapper<File> {

    /**
     * 关键词搜索文件
     * @param keywords
     * @return
     */
    List<File> getFileByKeyWords(String keywords);
}
