package com.zhaojj11.jam.libs.jpa.repository;


import com.zhaojj11.jam.libs.jpa.entity.BaseEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nonnull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

/**
 * 基础dao层.
 *
 * @param <T> 实体类，需要继承 {@link BaseEntity}.
 * @author zhaojj11
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity>
    extends JpaRepository<T, Long> {

    /**
     * logic delete by id.
     *
     * @param id id
     * @param deletedTime 被删除时间
     */
    @Query("update #{#entityName} t set t.deletedTime = ?2 where t.id = ?1")
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    void logicDeleteById(long id, LocalDateTime deletedTime);

    /**
     * 查询所有数据.
     *
     * @return 实体列表
     */
    @Query("select t from #{#entityName} t where t.isDeleted = 0")
    @Transactional(readOnly = true)
    @Nonnull
    @Override
    List<T> findAll();

    /**
     * find by id.
     *
     * @param id must not be {@literal null}.
     * @return 实体
     */
    @Query(
        "select t from #{#entityName} t where t.id = ?1 and t.isDeleted != null"
    )
    @Transactional(readOnly = true)
    @Nonnull
    @Override
    Optional<T> findById(@Nonnull Long id);
}
