package com.zhaojj11.jam.user.domain.model;

import com.zhaojj11.jam.libs.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaojj11
 */
@Entity
@Getter
@Setter
@Table(name = "roles")
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity implements Serializable {

    /**
     * 主键id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * 角色名称.
     */
    @Column
    private String name;
    /**
     * 状态.
     */
    @Column
    private Status status;
    /**
     * 角色描述.
     */
    @Column
    private String description;

    /**
     * userRoles.
     */
    @OneToMany(mappedBy = "role")
    private List<UserRole> userRoles = new ArrayList<>();

    @Getter
    public enum Status {
        /**
         * 正常.
         */
        ENABLED((byte) 0),
        /**
         * 禁用.
         */
        DISABLED((byte) 1);
        /**
         * value.
         */
        private final byte value;

        /**
         * constructor.
         *
         * @param v value
         */
        Status(final byte v) {
            this.value = v;
        }
    }
}
