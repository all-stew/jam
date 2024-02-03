package com.zhaojj11.jam.libs.jpa.service.impl;

import com.zhaojj11.jam.libs.jpa.entity.BaseEntity;
import com.zhaojj11.jam.libs.jpa.repository.BaseRepository;
import com.zhaojj11.jam.libs.jpa.service.BaseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * 基础service实现.
 *
 * @param <D> repository, 需要继承 {@link BaseRepository}
 * @param <T> 实体类，需要继承 {@link BaseEntity}.
 * @author zhaojj11
 */
@Service
public class BaseServiceImpl<D extends BaseRepository<T>, T extends BaseEntity>
    implements BaseService<T> {

    /**
     * {@link D} repository.
     */
    @Resource
    private D repository;

    /**
     * find by id.
     *
     * @param id 实体id
     * @return entity {@link T}
     */
    @Override
    public T findById(final long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * save.
     *
     * @param entity {@link T}
     */
    @Override
    public void save(final T entity) {
        repository.save(entity);
    }

    /**
     * delete by id.
     *
     * @param id id
     */
    @Override
    public void deleteById(final long id) {
        repository.deleteById(id);
    }
}
