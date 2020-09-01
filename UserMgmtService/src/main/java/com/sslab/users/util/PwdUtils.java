/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.users.util;

/**
 * @author TRINATH , Aug 10, 2020
 *
 * @Description :
 */
public class PwdUtils {
	
	public static final String ALPHA_NUMERIC_STRING="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
	
	public static String generateTempPwd(int count) {
		StringBuilder builder = new StringBuilder();
		while(count-- != 0) {
			int character =(int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
	}

}
