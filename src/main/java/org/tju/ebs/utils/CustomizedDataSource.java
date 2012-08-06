package org.tju.ebs.utils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class CustomizedDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return DataSourceContextHolder.getCustomerType();
	}
}