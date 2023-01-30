package com.hanhu.serve.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hanhu.serve.config.CustomAuthorityDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author hanhu
 * @since 2022-01-25
 */
@Getter
@Setter
@TableName("tb_admin")
@ApiModel(value = "Admin对象", description = "管理员")
public class Admin implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户名/学号")
    @Excel(name = "学号",width = 20)
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("姓名")
    @Excel(name = "姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("性别")
    @Excel(name = "性别")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/shanghai")
    @Excel(name = "出生日期",width = 20,format = "yyyy-MM-dd")
    @TableField("birthday")
    private LocalDate birthday;

    @ApiModelProperty("身份证号")
    @Excel(name = "身份证号",width = 30)
    @TableField("idCard")
    private String idCard;

    @ApiModelProperty("电话号码")
    @Excel(name = "电话号码",width = 20)
    @TableField("phone")
    private String phone;

    @ApiModelProperty("联系地址")
    @Excel(name = "地址",width = 30)
    @TableField("address")
    private String address;

    @ApiModelProperty("邮箱")
    @Excel(name = "邮箱",width = 30)
    @TableField("email")
    private String email;

    @ApiModelProperty("是否在校")
    @Excel(name = "是否在校")
    @TableField("isInSchool")
    private Boolean isInSchool;

    @ApiModelProperty("用户头像")
    @TableField("userFace")
    private String userFace;

    @ApiModelProperty("是否是学生")
    @TableField("isStudent")
    private Boolean IsStudent;

    @ApiModelProperty("是否锁定")
    @Excel(name = "是否锁定")
    @Getter(AccessLevel.NONE)
    @TableField("enabled")
    private Boolean enabled;

    @ApiModelProperty("入学时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/shanghai")
    @Excel(name = "入学时间",width = 20,format = "yyyy-MM-dd")
    @TableField("enrollmentTime")
    private LocalDate enrollmentTime;

    @ApiModelProperty("专业ID")
    @TableField("majorId")
    private Integer majorId;

    @ApiModelProperty("班级ID")
    @TableField("gradeId")
    private Integer gradeId;

    @ApiModelProperty(value = "角色")
    @TableField(exist = false)
    private List<Role> roles;

//    @ApiModelProperty(value = "课程")
//    @TableField(exist = false)
//    private List<Courses> courses;


    //外键
    @ApiModelProperty(value = "专业")
    @ExcelEntity(name = "专业")
    @TableField(exist = false)
    private Major major;

    //外键
    @ApiModelProperty(value = "班级")
    @ExcelEntity(name = "班级")
    @TableField(exist = false)
    private Grades grades;


    /**
     * 继承了UserDetails接口，重写了getAuthorities方法
     * 但是admin实体类并没有对应的一个集合属性  Collection
     * 也没有创建含有这样一个集合属性的构造函数
     * json无法进行反序列化
     * 在更新信息时，导致报错
     * 那么，自定义一个反序列化类
     * @return
     */
    /*角色*/
    @Override
    @JsonDeserialize(using = CustomAuthorityDeserializer.class)
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities = roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        //System.out.println("####################"+authorities);
        return authorities;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        //设置相应字段“是否启用”
        return true;
    }
}
