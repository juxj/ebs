package org.tju.ebs.entity;

import java.io.Serializable;

public class Category implements Serializable{

	
	private static final long serialVersionUID = 1503981943923359515L;
	
	private String id;
	private String shortName;
	private String fullName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	
}