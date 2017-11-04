package com.hb.dao;

import java.util.List;

import com.hb.entity.Types;

public interface ITypesDAO {

	public abstract void save(Types transientInstance);

	public abstract void delete(Types persistentInstance);

	public abstract Types findById(java.lang.Integer id);

	public abstract List findByExample(Types instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTname(Object tname);

	public abstract List findAll();

	public abstract Types merge(Types detachedInstance);

	public abstract void attachDirty(Types instance);

	public abstract void attachClean(Types instance);

}