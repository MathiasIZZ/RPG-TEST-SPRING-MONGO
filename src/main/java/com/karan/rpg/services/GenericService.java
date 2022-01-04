package com.karan.rpg.services;

import java.util.List;

public interface GenericService<T> {

    public List<T> findAll();
    public T findById(String id);
    public T create(T entity);
    public T update(T entity);
    public void delete(String id);

}
