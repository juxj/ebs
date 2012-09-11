package org.tju.ebs.service;

import static org.tju.ebs.utils.ErrorMessageBundle.getString;

public class BaseService {

	protected String getMessage(String key, String...values){
		return getString(key, values);
	}
	
}
