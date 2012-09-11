package org.tju.ebs.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Date getNow() {
		return Calendar.getInstance().getTime();
	}
	
	public static Date getDate(int type, int hours) {
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(new Date()); 
	    cal.add(type, hours); 
	    cal.getTime(); 
		return null;
	}
	
	
}
