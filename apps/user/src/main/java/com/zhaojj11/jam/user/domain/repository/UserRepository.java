package com.zhaojj11.jam.user.domain.repository;


import com.zhaojj11.jam.libs.jpa.repository.BaseRepository;
import com.zhaojj11.jam.user.domain.model.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * UserRepository.
 *
 * @author zhaojj11
 */
@Repository
public interface UserRepository extends BaseRepository<User> {

    /**
     * 通过用户名称获取用户信息.
     *
     * @param username 用户名称
     * @return user
     */
    Optional<User> findByUsername(String username);
}
