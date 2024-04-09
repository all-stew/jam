package com.zhaojj11.jam.consolegateway.domain.model;

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

@Entity
@Getter
@Setter
@Table(name = "menus")
@EqualsAndHashCode(callSuper = true)
public class Menu extends BaseEntity implements Serializable {

    /**
     * 主键id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * 菜单名称.
     */
    @Column
    private String name;
    /**
     * 父菜单id.
     */
    @Column
    private long parentId;
    /**
     * 显示顺序.
     */
    @Column
    private int orderNum;
    /**
     * 路由地址.
     */
    @Column
    private String path;
    /**
     * 组件路径.
     */
    @Column
    private String component;
    /**
     * 路由参数.
     */
    @Column
    private String query;
    /**
     * 是否为外链（0是 1否）.
     */
    @Column
    private boolean isExternalLink;

    /**
     * 菜单类型（0目录 1菜单 2按钮）.
     */
    @Column
    private MenuType menuType;
    /**
     * 菜单状态（0显示 1隐藏）.
     */
    @Column
    private Visible visible;
    /**
     * 菜单状态（0正常 1停用）.
     */
    @Column
    private Status status;
    /**
     * 权限标识.
     */
    @Column
    private String perms;
    /**
     * 菜单图标.
     */
    @Column
    private String icon;

    /**
     * roleMenus.
     */
    @OneToMany(mappedBy = "menu")
    private List<RoleMenu> roleMenus = new ArrayList<>();


    @Getter
    public enum MenuType {
        /**
         * CATEGORY.
         */
        CATEGORY((byte) 0),
        /**
         * MENU.
         */
        MENU((byte) 1),
        /**
         * BUTTON.
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
        MenuType(final byte v) {
            this.value = v;
        }
    }

    @Getter
    public enum Visible {
        /**
         * 正常.
         */
        VISIBLE((byte) 0),
        /**
         * 禁用.
         */
        HIDDEN((byte) 1);
        /**
         * value.
         */
        private final byte value;

        /**
         * constructor.
         *
         * @param v value
         */
        Visible(final byte v) {
            this.value = v;
        }
    }

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
