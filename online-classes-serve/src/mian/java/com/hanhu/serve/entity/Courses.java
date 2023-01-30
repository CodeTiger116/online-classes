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

    @ApiModelProperty("星期")
    @TableField("week")
    private Integer week;

    @ApiModelProperty("节次")
    @TableField("jieci")
    private Integer jieci;

    @ApiModelProperty("是否正在上课")
    @TableField("isOpen")
    private Integer isOpen;

    @ApiModelProperty("课程直播链接")
    @TableField("courseUrl")
    private String courseUrl;

}
