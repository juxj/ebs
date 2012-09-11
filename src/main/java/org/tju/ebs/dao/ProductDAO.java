package org.tju.ebs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.entity.Product;
import org.tju.ebs.entity.ProductExample;
import org.tju.ebs.persistence.AbstractMapper;
import org.tju.ebs.persistence.ProductMapper;

@Service
public class ProductDAO extends AbstractDAO<Product, ProductExample> {

	@Autowired
	private ProductMapper mapper;

	@Override
	protected AbstractMapper<Product, ProductExample> getMapper() {
		return this.mapper;
	}

}
