package io.github.xiami0725.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.xiami0725.request.SearchModel;
import io.github.xiami0725.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author lzz
 * @create 2021-04-22 16:23
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T> implements BaseService<T> {
    @Autowired
    protected M baseMapper;


    @Override
    public T save(T entity) throws Exception {


        baseMapper.insert(entity);
        return entity;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean saveBatch(Collection<T> entityList) {
        Integer size = entityList.size();
        for (T entity : entityList) {
            baseMapper.insert(entity);
            size++;
        }
        return size == entityList.size();
    }

    @Override
    public boolean saveOrUpdate(T entity) {
        int rs = baseMapper.updateById(entity);
        if (rs > 0) {
            return true;
        }
        return baseMapper.insert(entity) > 0;
    }

    @Override
    public boolean saveOrUpdate(T entity, Wrapper<T> updateWrapper) {


        return false;
    }

    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public boolean saveOrUpdateBatch(Collection<T> entityList) {

        for (T entity : entityList) {
            saveOrUpdate(entity);
        }
        return true;
    }

    @Override
    public boolean remove(Wrapper<T> queryWrapper) {
        return baseMapper.delete(queryWrapper) > 0;
    }

    @Override
    public boolean removeById(Serializable id) {
        return baseMapper.deleteById(id) > 0;
    }

    @Override
    public boolean removeByMap(Map<String, Object> columnMap) {

        return baseMapper.deleteByMap(columnMap) > 0;
    }

    @Override
    public boolean removeByIds(Collection<? extends Serializable> idList) {
        return baseMapper.deleteBatchIds(idList) > 0;
    }

    @Override
    public List<T> list() {
        return baseMapper.selectList(new QueryWrapper<T>());
    }

    @Override
    public List<T> list(SearchModel<T> searchModel) {
        return baseMapper.selectList(searchModel.getQueryModel());
    }

    @Override
    public List<T> list(QueryWrapper<T> queryWrapper) {
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public List<T> list(Map<String, Object> map) {
        return baseMapper.selectByMap(map);
    }

    @Override
    public Collection<T> listByIds(Collection<? extends Serializable> idList) {
        return baseMapper.selectBatchIds(idList);
    }

    @Override
    public Collection<T> listByMap(Map<String, Object> columnMap) {
        return baseMapper.selectByMap(columnMap);
    }


    @Override
    public IPage<T> page(SearchModel<T> searchModel) {

        return baseMapper.selectPage(searchModel.getPage(), searchModel.getQueryModel());

    }


    @Override
    public T selectById(Serializable id) {
        return baseMapper.selectById(id);
    }

    @Override
    public T selectOne(Wrapper<T> queryWrapper) {
        return baseMapper.selectOne(queryWrapper);
    }


    @Override
    public PageVo page(SearchModel<T> searchModel, Class object) throws InstantiationException, IllegalAccessException {
        IPage<T> page = baseMapper.selectPage(searchModel.getPage(), searchModel.getQueryModel());

        PageVo pageVo = new PageVo();
        pageVo.setRecords(BeanUtil.copyToList(page.getRecords(), object));
        pageVo.setTotal(page.getTotal());

        return pageVo;
    }

}