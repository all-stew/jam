package com.zhaojj11.jam.libs.jpa.service.impl;

import com.zhaojj11.jam.libs.jpa.dao.BaseRepository;
import com.zhaojj11.jam.libs.jpa.entity.BaseEntity;
import com.zhaojj11.jam.libs.jpa.service.BaseService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * 基础service实现
 *
 * @param <D> dao
 * @param <T> 实体
 * @author zhaojj11
 */
@Service
public class BaseServiceImpl<D extends BaseRepository<T>, T extends BaseEntity> implements BaseService<T> {
    @Resource
    protected D repository;

    @Override
    public T findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(T entity) {
        repository.save(entity);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
