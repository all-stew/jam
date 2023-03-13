package com.zhaojj11.jam.springjpacore.dao;


import com.zhaojj11.jam.springjpacore.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Optional;

/**
 * 基础dao层
 *
 * @author zhaojj11
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
    /**
     * 根据id逻辑删除
     *
     * @param id
     */
    @Query("update #{#entityName} t set t.isDeleted = 1 where t.id = ?1")
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    void logicDeleteById(Long id);

    /**
     * 查询所有数据
     *
     * @return
     */
    @Query("select t from #{#entityName} t where t.isDeleted = 0")
    @Transactional(readOnly = true)
    @Nonnull
    List<T> findAll();

    /**
     * 根据id查询实体
     *
     * @param id must not be {@literal null}.
     * @return
     */
    @Query("select t from #{#entityName} t where t.id = ?1 and t.isDeleted = 0")
    @Transactional(readOnly = true)
    @Nonnull
    Optional<T> findById(Long id);
}
