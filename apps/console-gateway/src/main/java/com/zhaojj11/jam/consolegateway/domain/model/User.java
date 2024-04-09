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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
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
    private long id;

    /**
     * 用户名.
     */
    @Column
    private String username;

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
    private Status status;

    /**
     * roles.
     */
    @OneToMany(mappedBy = "user")
    private List<UserRole> userRoles = new ArrayList<>();

    /**
     * getAuthorities.
     *
     * @return list
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

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
            + ", password='" + password + '\''
            + ", status=" + status
            + "} "
            + super.toString();
    }

    /**
     * isAccountNonExpired.
     *
     * @return isAccountNonExpired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * isAccountNonLocked.
     *
     * @return isAccountNonLocked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * isCredentialsNonExpired.
     *
     * @return isCredentialsNonExpired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * isEnabled.
     *
     * @return isEnabled
     */
    @Override
    public boolean isEnabled() {
        return true;
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
