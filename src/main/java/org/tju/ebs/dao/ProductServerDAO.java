package org.tju.ebs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.entity.ProductServer;
import org.tju.ebs.entity.ProductServerExample;
import org.tju.ebs.persistence.AbstractMapper;
import org.tju.ebs.persistence.ProductServerMapper;


@Service
public class ProductServerDAO extends AbstractDAO<ProductServer, ProductServerExample> {

	@Autowired
	private ProductServerMapper mapper;

	@Override
	protected AbstractMapper<ProductServer, ProductServerExample> getMapper() {
		return this.mapper;
	}

}
