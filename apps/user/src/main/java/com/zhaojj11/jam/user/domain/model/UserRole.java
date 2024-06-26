package com.zhaojj11.jam.user.domain.model;

import com.zhaojj11.jam.libs.jpa.entity.BaseEntity;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaojj11
 */
@Entity
@Getter
@Setter
@Table(name = "user_roles")
@EqualsAndHashCode(callSuper = true)
public class UserRole extends BaseEntity implements Serializable {

    /**
     * 主键.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * user.
     */
    @ManyToOne
    @JoinColumn(
        name = "user_id",
        foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
    )
    private User user;

    /**
     * user.
     */
    @ManyToOne
    @JoinColumn(
        name = "role_id",
        foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
    )
    private Role role;
}
