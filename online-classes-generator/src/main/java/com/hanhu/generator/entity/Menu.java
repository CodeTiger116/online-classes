package com.hanhu.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import onway.org.cn.comm.web.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

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
@TableName("tb_menu")
@ApiModel(value = "Menu对象", description = "")
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("url")
    @TableField("url")
    private String url;

    @ApiModelProperty("path")
    @TableField("path")
    private String path;

    @ApiModelProperty("组件")
    @TableField("component")
    private String component;

    @ApiModelProperty("菜单名")
    @TableField("name")
    private String name;

    @ApiModelProperty("是否保持激活")
    @TableField("keepAlive")
    private Boolean keepAlive;

    @ApiModelProperty("是否要求权限")
    @TableField("requireAuth")
    private Boolean requireAuth;

    @ApiModelProperty("父id")
    @TableField("parentId")
    private Integer parentId;

    @ApiModelProperty("是否启用")
    @TableField("enabled")
    private Boolean enabled;


}
