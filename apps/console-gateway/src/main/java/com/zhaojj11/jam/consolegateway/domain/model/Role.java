package com.zhaojj11.jam.consolegateway.domain.model;

import com.zhaojj11.jam.libs.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
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
    private String role;
    /**
     * 角色描述.
     */
    @Column
    private String description;
    /**
     * 状态.
     */
    @Column
    private Status status;

    /**
     * pemissions.
     */
    @ManyToMany
    @JoinTable(
        name = "RolePermissions",
        joinColumns = {@JoinColumn(name = "roleId")},
        inverseJoinColumns = {@JoinColumn(name = "permissionId")}
    )
    private List<Permission> permissions;

    /**
     * users.
     */
    @ManyToMany
    @JoinTable(
        name = "UserRoles",
        joinColumns = {@JoinColumn(name = "roleId")},
        inverseJoinColumns = {@JoinColumn(name = "userId")}
    )
    private List<User> users;

    @Getter
    public enum Status {
        /**
         * 正常.
         */
        ENABLED((byte) 1),
        /**
         * 禁用.
         */
        DISABLED((byte) 2);
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
