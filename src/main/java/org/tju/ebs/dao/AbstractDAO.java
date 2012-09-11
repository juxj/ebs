package org.tju.ebs.dao;

import java.util.List;

import org.tju.ebs.entity.AbstractEntity;
import org.tju.ebs.persistence.AbstractMapper;
import org.tju.ebs.utils.Pagination;

import com.mysql.jdbc.StringUtils;

public abstract  class AbstractDAO <T extends AbstractEntity, E>{
	
	protected abstract AbstractMapper<T, E> getMapper();
	
	public T get(String id) {
		return (T) this.getMapper() .selectByPrimaryKey(id);
	}
	
	public List<T> getAll() {
		return this.getMapper().selectByExample(null);
	}
	
	public Pagination<T> getByExample(E e, int pageNo, int pageSize) {
		int recordCount = this.getMapper().countByExample(e);
		List<T> data = this.getMapper().selectByExample(e).subList(pageNo*pageSize, pageSize);
		Pagination<T> p = new Pagination<T>();
		p.setRecordCount(recordCount);
		p.setData(data);
		return p;
	}
	
	public List<T> getByExample(E e) {
		return this.getMapper().selectByExample(e);
	}
	
	public T insert(T t) {
		this.getMapper().insert(t);
		return t;
	}
	
	public T update(T t) {
		this.getMapper().updateByPrimaryKey(t);
		return t;
	}
	
	public T save(T t) {
		if (StringUtils.isNullOrEmpty(t.getId())){
			t.setId(java.util.UUID.randomUUID().toString());
		} else {
			this.getMapper().updateByPrimaryKey(t);
		}
		return t;
	}
	
	public void delete(T t) {
		if (StringUtils.isNullOrEmpty(t.getId())) {
			// do nothing here.
		} else {
			this.getMapper().deleteByPrimaryKey(t.getId());
		}
	}
	
	
	
	public void delete(String id) {
		if (!StringUtils.isNullOrEmpty(id)) {
			this.getMapper().deleteByPrimaryKey(id);
		}
	}

}
