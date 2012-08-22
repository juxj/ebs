package org.tju.ebs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.entity.Registration;
import org.tju.ebs.entity.RegistrationExample;
import org.tju.ebs.persistence.AbstractMapper;
import org.tju.ebs.persistence.RegistrationMapper;

@Service
public class RegistrationDAO extends
		AbstractDAO<Registration, RegistrationExample> {

	@Autowired
	private RegistrationMapper mapper;
	
	@Override
	protected AbstractMapper<Registration, RegistrationExample> getMapper() {
		return this.mapper;
	}

}
