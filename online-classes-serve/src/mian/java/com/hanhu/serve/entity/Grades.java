package com.hanhu.serve.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
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
@NoArgsConstructor     //写有参构造时，最好也把无参构造写上
@RequiredArgsConstructor  //有参构造
@EqualsAndHashCode(callSuper = false,of = "gradeName")  //以gradeName重写Equals和HashCode
@TableName("tb_grades")
@ApiModel(value = "Grades对象", description = "")
public class Grades extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("班级名称")
    @Excel(name = "班级")
    @TableField("gradeName")
    @NonNull          //写新的有参构造时，name非空
    private String gradeName;


}
