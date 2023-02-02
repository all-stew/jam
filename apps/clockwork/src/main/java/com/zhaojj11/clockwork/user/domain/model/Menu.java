package com.zhaojj11.clockwork.user.domain.model;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.annotation.JsonValue;
import com.zhaojj11.clockwork.common.repository.DateTypeHandler;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * menu 实体
 *
 * @author zhaojj11
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName(value = "menus", autoResultMap = true)
public class Menu implements Serializable {
    @TableId
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private long parentId;
    @NonNull
    private int orderNum;
    @NonNull
    private String url;
    @NonNull
    private Target target;
    @NonNull
    private Type type;
    @NonNull
    private Status status;
    @NonNull
    private String permission;
    @NonNull
    private String icon;
    @NonNull
    private String remark;
    @TableLogic
    @NonNull
    private boolean deleted;
    @TableField(typeHandler = DateTypeHandler.class, fill = FieldFill.INSERT)
    @NonNull
    private LocalDateTime createdTime;
    @TableField(typeHandler = DateTypeHandler.class, fill = FieldFill.INSERT_UPDATE)
    @NonNull
    private LocalDateTime updatedTime;

    @NonNull
    public static Menu build(
            @NonNull String name
    ) {
        Menu menu = new Menu();
        menu.setId(null);
        menu.setName(name);
        menu.setParentId(0L);
        menu.setOrderNum(1);
        menu.setUrl("");
        menu.setTarget(Target.MENU_ITEM);
        menu.setType(Type.MENU);
        menu.setStatus(Status.ENABLE);
        menu.setPermission("");
        menu.setIcon("");
        menu.setRemark("");
        menu.setDeleted(false);
        menu.setCreatedTime(LocalDateTime.now());
        menu.setUpdatedTime(LocalDateTime.now());
        return menu;
    }

    @Getter
    public enum Target {
        /**
         * 页签
         */
        MENU_ITEM(0),
        /**
         * 新窗口
         */
        MENU_BLANK(1);

        @EnumValue
        @JsonValue
        private final int value;

        Target(int value) {
            this.value = value;
        }
    }

    @Getter
    public enum Type {
        /**
         * 目录
         */
        CATALOG(0),
        /**
         * 菜单
         */
        MENU(1),
        /**
         * 按钮
         */
        BUTTON(2);

        @EnumValue
        @JsonValue
        private final int value;

        Type(int value) {
            this.value = value;
        }
    }

    @Getter
    public enum Status {
        /**
         * 启用状态
         */
        ENABLE(0),
        /**
         * 停用
         */
        DISABLE(1);

        @EnumValue
        @JsonValue
        private final int value;

        Status(int value) {
            this.value = value;
        }
    }

    @Mapper
    public interface MenuMapper extends BaseMapper<Menu> {
        @Select("""
                SELECT DISTINCT m.*
                FROM user_roles ur
                         LEFT JOIN roles r on ur.role_id = r.id
                         LEFT JOIN role_menus on r.id = role_menus.role_id
                         LEFT JOIN menus m on role_menus.menu_id = m.id
                WHERE user_id = #{userId}
                  AND r.status = 0
                  AND r.deleted = 0
                  AND m.status = 0
                  AND m.status = 0;
                """)
        List<Menu> listByUserId(long userId);
    }
}
