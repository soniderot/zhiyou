package com.zy.common.db;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface BaseDao<T extends Serializable, PK extends Serializable> {
    public T get(PK id);
    
    public T load(PK id);
   
    public List<T> loadAll();

    public void update(T entity);
    public T merge(T entity);

    public Serializable saveback(T entity);
    
    public void save(T entity);

    public void saveOrUpdate(T entity);

    public void saveOrUpdateAll(Collection<T> entities);

    public void delete(T entity);
    public void deleteByKey(PK id);

    public void deleteAll(Collection<T> entities);
    public List loadByPagenationf(String hql, int pageNo, int pageSize, Object... paras);

}