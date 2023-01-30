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
 * @since 2022-02-02
 */
@Getter
@Setter
@TableName("tb_courses")
@ApiModel(value = "Courses对象", description = "")
public class Courses extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("课程名称")
    @TableField("courseName")
    private String courseName;

    @ApiModelProperty("学分")
    @TableField("credit")
    private Integer credit;

    @ApiModelProperty("课程类型")
    @TableField("type")
    private String type;


}
