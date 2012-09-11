package org.tju.ebs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tju.ebs.entity.User;
import org.tju.ebs.entity.UserExample;
import org.tju.ebs.persistence.AbstractMapper;
import org.tju.ebs.persistence.UserMapper;

@Service
public class UserDAO extends AbstractDAO<User, UserExample> {

	@Autowired
	private UserMapper mapper;

	@Override
	protected AbstractMapper<User, UserExample> getMapper() {
		return this.mapper;
	}

}
