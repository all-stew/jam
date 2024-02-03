package com.zhaojj11.jam.consolegateway.domain.model;

import com.zhaojj11.jam.libs.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_groups")
@EqualsAndHashCode(callSuper = true)
public class UserGroup extends BaseEntity implements Serializable {

    /**
     * 主键.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
