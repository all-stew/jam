package com.zhaojj11.jam.sample.system.repository;

import com.zhaojj11.jam.sample.system.entity.User;
import com.zhaojj11.jam.springjpacore.dao.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhaojj11
 */
@Repository
public interface UserRepository extends BaseRepository<User> {
}
