CREATE TABLE IF NOT EXISTS `jam`.`users`
(
    `id`           BIGINT UNSIGNED AUTO_INCREMENT COMMENT '主键',
    `username`     VARCHAR(30)                        NOT NULL,
    `password`     VARCHAR(100)                       NOT NULL COMMENT '密码',
    `salt`         VARCHAR(50)                        NOT NULL COMMENT '盐值，用于加密',
    `status`       TINYINT  DEFAULT 1                 NOT NULL COMMENT '角色状态(0-正常 1-禁用)',
    `created_by`   BIGINT   DEFAULT 0                 NOT NULL COMMENT '创建人的ID',
    `created_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    `updated_by`   BIGINT   DEFAULT 0                 NOT NULL COMMENT '修改人ID',
    `updated_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '修改时间',
    `deleted_time` DATETIME DEFAULT NULL COMMENT '删除时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_username` (`username`)
) ENGINE = innodb COMMENT '用户表'
  CHARSET = utf8mb4;

DROP TABLE IF EXISTS `jam`.`roles`;
CREATE TABLE `roles`
(
    `id`           BIGINT UNSIGNED AUTO_INCREMENT     NOT NULL,
    `name`         VARCHAR(30)                        NOT NULL COMMENT '角色名称',
    `status`       TINYINT  DEFAULT 0                 NOT NULL COMMENT '角色状态(0-正常,1-禁用)',
    `description`  VARCHAR(100)                       NOT NULL COMMENT '角色名称',
    `created_by`   BIGINT   DEFAULT 0                 NOT NULL COMMENT '创建人的ID',
    `created_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    `updated_by`   BIGINT   DEFAULT 0                 NOT NULL COMMENT '修改人ID',
    `updated_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '修改时间',
    `deleted_time` DATETIME DEFAULT NULL COMMENT '删除时间',
    primary key (`id`)
) ENGINE = innodb COMMENT '角色表'
  CHARSET = utf8mb4;

DROP TABLE IF EXISTS `jam`.`user_roles`;
CREATE TABLE `user_roles`
(
    `id`           BIGINT UNSIGNED AUTO_INCREMENT     NOT NULL,
    `user_id`      BIGINT UNSIGNED                    NOT NULL,
    `role_id`      BIGINT UNSIGNED                    NOT NULL,
    `created_by`   BIGINT   DEFAULT 0                 NOT NULL COMMENT '创建人的ID',
    `created_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    `updated_by`   BIGINT   DEFAULT 0                 NOT NULL COMMENT '修改人ID',
    `updated_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '修改时间',
    `deleted_time` DATETIME DEFAULT NULL COMMENT '删除时间',
    primary key (`id`)
) ENGINE = innodb COMMENT '用户角色表'
  CHARSET = utf8mb4;

DROP TABLE IF EXISTS `jam`.`menus`;
CREATE TABLE `menus`
(
    `id`               BIGINT UNSIGNED AUTO_INCREMENT         NOT NULL,
    `name`             VARCHAR(30)                            NOT NULL COMMENT '角色名称',
    `parent_id`        BIGINT       default 0                 NOT NULL comment '父菜单ID',
    `order_num`        tinyint      default 0                 NOT NULL comment '显示顺序',
    `path`             varchar(200) default ''                NOT NULL comment '路由地址',
    `component`        varchar(255) default ''                NOT NULL comment '组件路径',
    `query`            varchar(255) default ''                NOT NULL comment '路由参数',
    `is_external_link` bit default b'1' NOT NULL comment '是否为外链（0是 1否）',
    `menu_type`        tinyint      default 0                 NOT NULL comment '菜单类型（0目录 1菜单 2按钮）',
    `visible`          tinyint      default 0                 NOT NULL comment '菜单状态（0显示 1隐藏）',
    `status`           tinyint      default 0                 NOT NULL comment '菜单状态（0正常 1停用）',
    `perms`            varchar(100) default ''                NOT NULL comment '权限标识',
    `icon`             varchar(100) default '#'               NOT NULL comment '菜单图标',
    `created_by`       BIGINT       DEFAULT 0                 NOT NULL COMMENT '创建人的ID',
    `created_time`     DATETIME     DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    `updated_by`       BIGINT       DEFAULT 0                 NOT NULL COMMENT '修改人ID',
    `updated_time`     DATETIME     DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '修改时间',
    `deleted_time`     DATETIME     DEFAULT NULL COMMENT '删除时间',
    primary key (`id`)
) ENGINE = innodb COMMENT = '菜单表'
  CHARSET = utf8mb4;


DROP TABLE IF EXISTS `jam`.`role_menus`;
CREATE TABLE `role_menus`
(
    `id`           BIGINT UNSIGNED AUTO_INCREMENT     NOT NULL,
    `role_id`      BIGINT UNSIGNED                    NOT NULL,
    `menu_id`      BIGINT UNSIGNED                    NOT NULL,
    `created_by`   BIGINT   DEFAULT 0                 NOT NULL COMMENT '创建人的ID',
    `created_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
    `updated_by`   BIGINT   DEFAULT 0                 NOT NULL COMMENT '修改人ID',
    `updated_time` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '修改时间',
    `deleted_time` DATETIME DEFAULT NULL COMMENT '删除时间',
    primary key (`id`)
) ENGINE = innodb COMMENT '角色菜单表'
  CHARSET = utf8mb4;
