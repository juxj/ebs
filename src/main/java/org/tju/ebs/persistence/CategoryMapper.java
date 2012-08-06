package org.tju.ebs.persistence;

import java.util.List;

import org.tju.ebs.entity.Category;

public interface CategoryMapper {

	public List<Category> getCategoryList();
	public Category getCategoryById(String id);
}
