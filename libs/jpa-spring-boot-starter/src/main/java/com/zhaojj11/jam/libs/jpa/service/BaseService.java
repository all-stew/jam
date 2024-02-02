package com.zhaojj11.jam.libs.jpa.service;


import com.zhaojj11.jam.libs.jpa.entity.BaseEntity;

/**
 * 基础service.
 *
 * @param <T> 实体类，需要继承 {@link BaseEntity}.
 * @author zhaojj11
 */
public interface BaseService<T extends BaseEntity> {
    /**
     * 根据id查询实体.
     *
     * @param id 实体id
     * @return 实体
     */
    T findById(long id);

    /**
     * 保存实体.
     *
     * @param entity 对象
     */
    void save(T entity);

    /**
     * 根据id删除实体.
     *
     * @param id 实体id
     */
    void deleteById(long id);
}
