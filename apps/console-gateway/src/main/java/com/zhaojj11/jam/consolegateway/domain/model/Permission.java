package com.zhaojj11.jam.consolegateway.domain.model;

import com.zhaojj11.jam.libs.jpa.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "permissions")
@EqualsAndHashCode(callSuper = true)
public class Permission extends BaseEntity implements Serializable {

    /**
     * 主键.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * 资源类型.
     */
    private ResourceType type;
    /**
     * 权限名称.
     */
    private String permission;
    /**
     * 权限描述.
     */
    private String description;
    /**
     * 父id. 0 为根目录
     */
    private long parentId;
    /**
     * 状态.
     */
    private Status status;
    /**
     * 权限列表.
     */
    @Transient
    private List<?> permissions;
    /**
     * roles.
     */
    @ManyToMany
    @JoinTable(
        name = "RolePermissions",
        joinColumns = {@JoinColumn(name = "permissionId")},
        inverseJoinColumns = {@JoinColumn(name = "roleId")}
    )
    private List<Role> roles;

    @Getter
    public enum ResourceType {
        /**
         * 菜单.
         */
        MENU((byte) 1),
        /**
         * 按钮.
         */
        BUTTON((byte) 2);
        /**
         * value.
         */
        private final byte value;

        /**
         * constructor.
         *
         * @param v value
         */
        ResourceType(final byte v) {
            this.value = v;
        }
    }


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
