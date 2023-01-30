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
@TableName("tb_admin_role")
@ApiModel(value = "AdminRole对象", description = "")
public class AdminRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    @TableField("adminId")
    private Integer adminId;

    @ApiModelProperty("权限id")
    @TableField("rid")
    private Integer rid;


}
