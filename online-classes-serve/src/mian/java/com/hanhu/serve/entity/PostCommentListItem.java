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

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author hanhu
 * @since 2022-03-16
 */
@Getter
@Setter
public class PostCommentListItem extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String content;

    private LocalDateTime createTime;

    private Long creator;

    private String creatorName;

    private Integer likeCount;

    private Long postId;

    private Long pCommentId;
}
