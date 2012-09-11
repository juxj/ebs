package org.tju.ebs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.entity.Company;
import org.tju.ebs.entity.CompanyExample;
import org.tju.ebs.persistence.AbstractMapper;
import org.tju.ebs.persistence.CompanyMapper;

@Service
public class CompanyDAO extends AbstractDAO<Company, CompanyExample> {

	@Autowired
	private CompanyMapper mapper;
	
	@Override
	protected AbstractMapper<Company, CompanyExample> getMapper() {
		return this.mapper;
	}

}
