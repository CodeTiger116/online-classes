package com.hanhu.generator.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
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
 * @since 2022-02-14
 */
@Getter
@Setter
@TableName("tb_file")
@ApiModel(value = "File对象", description = "")
public class File extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("文件名")
    @TableField("name")
    private String name;

    @ApiModelProperty("服务器中的文件名")
    @TableField("trueName")
    private String trueName;

    @ApiModelProperty("文件大小")
    @TableField("fileSize")
    private Integer fileSize;

    @ApiModelProperty("上传时间")
    @TableField("euploadTime")
    private LocalDate euploadTime;

    @ApiModelProperty("文件类型")
    @TableField("fileType")
    private String fileType;

    @ApiModelProperty("上传文件的用户名")
    @TableField("uploadUser")
    private String uploadUser;

    @ApiModelProperty("是否存在")
    @TableField("isExist")
    private Boolean exist;


}
