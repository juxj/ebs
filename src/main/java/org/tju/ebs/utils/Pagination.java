package org.tju.ebs.utils;

import java.util.List;

public class Pagination<T> {

	private int recordCount;
	private List<T> data;
	
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	
	
}
