package com.zhaojj11.jam.libs.springjpacore.service.impl;

import com.zhaojj11.jam.libs.springjpacore.dao.BaseRepository;
import com.zhaojj11.jam.libs.springjpacore.entity.BaseEntity;
import com.zhaojj11.jam.libs.springjpacore.service.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
