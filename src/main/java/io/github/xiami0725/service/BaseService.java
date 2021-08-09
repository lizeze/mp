package io.github.xiami0725.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.xiami0725.request.SearchModel;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author lzz
 * @create 2021-04-22 16:12
 */
public interface BaseService<T> {
    /**
     * 保存对象
     *
     * @param entity
     * @return
     * @throws Exception
     */
    T save(T entity) throws Exception;

    /**
     * 批量保存
     *
     * @param entityList
     * @return
     */
    boolean saveBatch(Collection<T> entityList);


    /**
     * 根据主键判断是更新还是新增
     *
     * @param entity
     * @return
     */
    boolean saveOrUpdate(T entity);

    /**
     * 有条件的修改
     *
     * @param entity
     * @param updateWrapper
     * @return
     */
    boolean saveOrUpdate(T entity, Wrapper<T> updateWrapper);

    /**
     * 根据主键判断是更新还是新增 批量
     *
     * @param entityList
     * @return
     */
    boolean saveOrUpdateBatch(Collection<T> entityList);

    /**
     * 删除
     *
     * @param queryWrapper
     * @return
     */
    boolean remove(Wrapper<T> queryWrapper);

    /**
     * 根据ID删除数据
     *
     * @param id
     * @return
     */
    boolean removeById(Serializable id);

    /**
     * 根据map删除数据
     *
     * @param columnMap
     * @return
     */
    boolean removeByMap(Map<String, Object> columnMap);

    /**
     * 根据id批量删除
     *
     * @param idList
     * @return
     */
    boolean removeByIds(Collection<? extends Serializable> idList);

    /**
     * 查询全部数据
     *
     * @return
     */
    List<T> list();

    /**
     * 使用searchModel查询
     *
     * @param searchModel
     * @return
     */
    List<T> list(SearchModel<T> searchModel);

    /**
     * 使用queryWrapper查询
     *
     * @param queryWrapper
     * @return
     */
    List<T> list(QueryWrapper<T> queryWrapper);

    /**
     * 根据map查询数据
     *
     * @param map
     * @return
     */
    List<T> list(Map<String, Object> map);


    /**
     * 根据ID批量查询
     *
     * @param idList
     * @return
     */
    Collection<T> listByIds(Collection<? extends Serializable> idList);

    /**
     * 使用map批量查询
     *
     * @param columnMap
     * @return
     */
    Collection<T> listByMap(Map<String, Object> columnMap);

    /**
     * 查询分页
     *
     * @param searchModel
     * @return
     */
    IPage<T> page(SearchModel<T> searchModel);


    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    T selectById(Serializable id);

    /**
     * 返回一条数据
     *
     * @param queryWrapper
     * @return
     */
    T selectOne(Wrapper<T> queryWrapper);

    /**
     * 获取getQueryWarpper
     *
     * @return
     */
    QueryWrapper<T> getQueryWrapper();

}
