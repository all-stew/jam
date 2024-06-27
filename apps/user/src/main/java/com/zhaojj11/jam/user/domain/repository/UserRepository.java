package com.zhaojj11.jam.user.domain.repository;


import com.zhaojj11.jam.libs.jpa.repository.BaseRepository;
import com.zhaojj11.jam.user.domain.model.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
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

    /**
     * 用于后台分页查询.
     *
     * @param username 模糊  username 查询
     * @param pageable 分页查询参数
     * @return 分页 user
     */
    @Query("SELECT u FROM User u WHERE u.username LIKE %:username%")
    Page<User> page(String username, Pageable pageable);
}
