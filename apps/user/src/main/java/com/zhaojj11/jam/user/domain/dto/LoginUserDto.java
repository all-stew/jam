package com.zhaojj11.jam.user.domain.dto;

import com.zhaojj11.jam.user.domain.model.User.Status;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * user dto.
 *
 * @author zhaojj11
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDto {

    /**
     * id.
     */
    private long id;
    /**
     * username.
     */
    private String username;
    /**
     * status.
     */
    private Status status;
    /**
     * roles.
     */
    private Set<String> roles;
}
