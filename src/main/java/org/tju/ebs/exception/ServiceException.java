package org.tju.ebs.exception;

import java.util.ArrayList;
import java.util.List;

public class ServiceException extends Exception{

	private static final long serialVersionUID = -8963252086915912155L;
	
	private List<String> errors;
	
	public ServiceException(List<String> errors) {
        super();
        this.errors = errors;
    }

	public ServiceException(String error) {
		super(error);
        this.errors = new ArrayList<String>();
        errors.add(error);
	}
	
	public List<String> getErrors(){
		return errors;
	}
	
	
}
