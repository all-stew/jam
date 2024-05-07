package com.zhaojj11.jam.user.domain.repository;

import com.zhaojj11.jam.libs.jpa.repository.BaseRepository;
import com.zhaojj11.jam.user.domain.model.Role;
import org.springframework.stereotype.Repository;

/**
 * RoleRepository.
 *
 * @author zhaojj11
 */
@Repository
public interface RoleRepository extends BaseRepository<Role> {
}
