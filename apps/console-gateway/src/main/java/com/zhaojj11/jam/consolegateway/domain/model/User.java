package com.zhaojj11.jam.consolegateway.domain.model;

import com.zhaojj11.jam.libs.jpa.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author zhaojj11
 */
@Entity
@Getter
@Setter
@Table(name = "users")
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity implements UserDetails, Serializable {

    /**
     * 主键.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名.
     */
    @Column
    private String username;

    /**
     * 性别 0-男 1-女.
     */
    private Integer gender;
    /**
     * 密码.
     */
    @Column
    private String password;

    /**
     * 用于密码加密的盐值.
     */
    private String salt;

    /**
     * 状态 1-正常 2-禁用.
     */
    @Column
    private Integer status;

    /**
     * to string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "User{"
            + "id=" + id
            + ", username='" + username + '\''
            + ", gender=" + gender
            + ", password='" + password + '\''
            + ", status=" + status
            + "} "
            + super.toString();
    }

    /**
     * getAuthorities.
     * @return list
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    /**
     * isAccountNonExpired.
     * @return isAccountNonExpired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * isAccountNonLocked.
     * @return isAccountNonLocked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * isCredentialsNonExpired.
     * @return isCredentialsNonExpired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * isEnabled.
     * @return isEnabled
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
