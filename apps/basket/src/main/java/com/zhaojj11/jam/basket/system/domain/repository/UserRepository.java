package com.zhaojj11.jam.basket.system.domain.repository;

import com.zhaojj11.jam.basket.system.domain.model.User;
import com.zhaojj11.jam.libs.jpa.dao.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author zhaojj11
 */
@Repository
public interface UserRepository extends BaseRepository<User> {
    /**
     * 根据用户名查询user
     *
     * @param username 用户名
     * @return user
     */
    Optional<User> findByUsername(String username);
}
