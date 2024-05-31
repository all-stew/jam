package com.zhaojj11.jam.libs.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * @author zhaojj11
 */
@Setter
@Getter
@MappedSuperclass
public class BaseEntity {

    /**
     * 创建人.
     */
    @Column
    @CreatedBy
    private Long createdBy;

    /**
     * 创建时间.
     */
    @Column
    @CreatedDate
    private LocalDateTime createdTime;

    /**
     * 修改人.
     */
    @Column
    @LastModifiedBy
    private Long updatedBy;

    /**
     * 修改时间.
     */
    @Column
    @LastModifiedDate
    private LocalDateTime updatedTime;

    /**
     * 逻辑删除字段 可空. 被删除后需要修改为删除时间
     */
    @Column
    private LocalDateTime deletedTime;
}
