package com.zhaojj11.jam.libs.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;

/**
 * @author zhaojj11
 */
@Getter
@MappedSuperclass
public class BaseEntity {

    /**
     * 创建人.
     */
    @Column
    private Long createdBy;

    /**
     * 创建时间.
     */
    @Column
    private LocalDateTime createdTime;

    /**
     * 修改人.
     */
    @Column
    private Long updatedBy;

    /**
     * 修改时间.
     */
    @Column
    private LocalDateTime updatedTime;

    /**
     * 逻辑删除字段 可空. 被删除后需要修改为删除时间
     */
    @Column
    private LocalDateTime deletedTime;

    /**
     * 备注.
     */
    @Column
    private String remark;
}
