package org.tju.ebs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.entity.CompanyProduct;
import org.tju.ebs.entity.CompanyProductExample;
import org.tju.ebs.persistence.AbstractMapper;
import org.tju.ebs.persistence.CompanyProductMapper;

@Service
public class CompanyProductDAO extends AbstractDAO<CompanyProduct, CompanyProductExample> {

	@Autowired
	private CompanyProductMapper mapper;

	@Override
	protected AbstractMapper<CompanyProduct, CompanyProductExample> getMapper() {
		return this.mapper;
	}

}
