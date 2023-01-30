package com.hanhu.serve.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import onway.org.cn.comm.web.entity.BaseEntity;

/**
 * <p>
 * 
 * </p>
 *
 * @author hanhu
 * @since 2022-01-29
 */
@Getter
@Setter
@TableName("tb_role")
@ApiModel(value = "Role对象", description = "")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("角色名称")
    @TableField("nameZh")
    private String nameZh;


}
