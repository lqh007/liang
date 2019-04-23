package com.seven.mybatis_plus.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author seven
 * @since 2019-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "验证码")
    private String vCode;

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "token生成时间")
    private LocalDateTime tokenCreateTime;

    @ApiModelProperty(value = "验证码创建时间")
    private LocalDateTime vCreateTime;

    @ApiModelProperty(value = "用户创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "用户更新时间")
    private LocalDateTime updateTime;


}
