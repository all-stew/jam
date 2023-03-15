package com.zhaojj11.jam.libs.springjpacore.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author zhaojj11
 */
@Getter
@MappedSuperclass
public class BaseEntity {

    /**
     * 创建人
     */
    @Column
    private Long createdBy;

    /**
     * 创建时间
     */
    @Column
    private LocalDateTime createdTime;

    /**
     * 修改人
     */
    @Column
    private Long updatedBy;

    /**
     * 修改时间
     */
    @Column
    private LocalDateTime updatedTime;

    /**
     * 逻辑删除字段 0-未删除 1-已删除
     */
    @Column
    private Integer isDeleted;

    /**
     * 备注
     */
    @Column
    private String remark;
}