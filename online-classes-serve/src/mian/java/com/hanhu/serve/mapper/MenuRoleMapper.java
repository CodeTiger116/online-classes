package com.hanhu.serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hanhu.serve.entity.MenuRole;
import org.apache.ibatis.annotations.Mapper;
//import org.springframework.data.repository.query.Param;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hanhu
 * @since 2022-01-29
 */
@Mapper
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 批量更新
     * @param rid
     * @param mids
     */
    Integer insertRecord(@Param("rid")Integer rid,@Param("mids")Integer[] mids);
}
