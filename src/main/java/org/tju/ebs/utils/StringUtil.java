package org.tju.ebs.utils;

import java.util.List;
import java.util.ArrayList;;

public class StringUtil {

	public static List<String> getStringList(String str, String seperator) {
		List<String> list = new ArrayList<String>();
		String[] array = str.split(seperator);
		for (String item : array) {
			list.add(item);
		}
		return list;
	}
	
	public static String getUUID(){
		return java.util.UUID.randomUUID().toString();
	}
}
