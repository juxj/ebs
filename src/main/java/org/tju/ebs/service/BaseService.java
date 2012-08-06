package org.tju.ebs.service;

import org.tju.ebs.entity.Account;
import org.tju.ebs.utils.DataSourceContextHolder;

public abstract class BaseService {

	private final int SHARDING_COUNT = 2;
	
	protected abstract Account getDataSourceAccount();
	
	
	protected BaseService() {
		
	}
	
}
