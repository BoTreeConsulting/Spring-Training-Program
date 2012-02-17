package com.botreeconsulting.lms.hibernate.xml.model.util;

public class StringUtil {
	/**
	 * 
	 * @param src the source string
	 * 
	 * @return boolean <code>true</code> if the specified <code>src</code> is not null and not empty,
	 * <code>false</code> otherwise
	 */
	public static final boolean isNotEmpty(String src) {
		if (src != null && !src.trim().isEmpty()) {
			return true;
		}
		return false;
	}
	
}
