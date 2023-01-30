package com.hanhu.serve.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import onway.org.cn.comm.web.entity.BaseEntity;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 
 * </p>
 *
 * @author hanhu
 * @since 2022-02-03
 */
@Getter
@Setter
@TableName("tb_students")
@ApiModel(value = "Students对象", description = "")
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("学号")
    @TableField("username")
    private Integer username;

    @ApiModelProperty("密码")
    @TableField("password")
    private Integer password;

    @ApiModelProperty("学生姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("性别")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/shanghai")
    @TableField("birthday")
    private LocalDate birthday;

    @ApiModelProperty("身份证号")
    @TableField("idCard")
    private String idCard;

    @ApiModelProperty("电话号码")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("联系地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("是否在校")
    @TableField("isInSchool")
    private Boolean isInSchool;

    @ApiModelProperty("用户头像")
    @TableField("userFace")
    private String userFace;

    @ApiModelProperty("是否是学生")
    @TableField("isStudent")
    private Boolean isStudent;

    @ApiModelProperty("是否锁定")
    @TableField("enabled")
    private Boolean enabled;

    @ApiModelProperty("入学时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/shanghai")
    @TableField("enrollmentTime")
    private LocalDate enrollmentTime;

    @ApiModelProperty("专业ID")
    @TableField("majorId")
    private Integer majorId;

    @ApiModelProperty("班级ID")
    @TableField("gradeId")
    private Integer gradeId;

    //外键
    @ApiModelProperty(value = "专业")
    @TableField(exist = false)
    private Major major;

    //外键
    @ApiModelProperty(value = "班级")
    @TableField(exist = false)
    private Grades grades;


}
