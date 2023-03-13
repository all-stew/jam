package com.zhaojj11.jam.sample.system.entity;

import com.zhaojj11.jam.springjpacore.entity.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author zhaojj11
 */
@Entity
@Getter
@Setter
@Table(name = "system_user")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    @Column
    private String username;

    /**
     * 性别 0-男 1-女
     */
    private Integer gender;
    /**
     * 密码
     */
    @Column
    private String password;

    /**
     * 用于密码加密的盐值
     */
    private String salt;

    /**
     * 身份证号
     */
    @Column
    private String idCard;


    /**
     * 邮箱
     */
    @Column
    private String email;


    /**
     * 电话
     */
    @Column
    private String phone;


    /**
     * 生日
     */
    @Column
    private LocalDateTime birthday;

    /**
     * 年龄
     */
    @Column
    private Integer age;

    /**
     * 状态 1-正常 2-禁用
     */
    @Column
    private Integer status;

    /**
     * 上次登录时间
     */
    @Column
    private LocalDateTime lastLogin;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender=" + gender +
                ", password='" + password + '\'' +
                ", idCard='" + idCard + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                ", status=" + status +
                ", lastLogin=" + lastLogin +
                "} " + super.toString();
    }
}
