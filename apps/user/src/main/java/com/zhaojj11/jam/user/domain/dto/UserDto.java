package com.zhaojj11.jam.user.domain.dto;

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
public class UserDto {

    /**
     * id.
     */
    private long userId;
    /**
     * username.
     */
    private String username;
}
