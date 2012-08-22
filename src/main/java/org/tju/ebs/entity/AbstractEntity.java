package org.tju.ebs.entity;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = 3466956842010833893L;
	
	public abstract String getId() ;
	
	public abstract void setId(String id);

}
