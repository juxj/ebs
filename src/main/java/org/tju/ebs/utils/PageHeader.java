package org.tju.ebs.utils;

import java.io.Serializable;

public class PageHeader implements Serializable{

	private static final long serialVersionUID = 2523219021754156449L;
	
	private String title;
	
	private String keywords;
	
	private String description;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getKeywords() {
		return keywords;
	}
	
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
