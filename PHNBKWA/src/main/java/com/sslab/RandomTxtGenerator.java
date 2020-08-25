/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab;

/**
 * @author TRINATH , Aug 1, 2020
 *
 * @Description :This is random Password Generator Class used in 2nd mini Projects .....
 */
public class RandomTxtGenerator {
	
	private static final String ALPHA_NUMERIC_STRING="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
	
	public static void main(String[] args) {
		String tempPassword=randomAlphanumericGenerator(10);
		System.out.println(tempPassword);
	}
	
	public static String randomAlphanumericGenerator(int count) {
		
		StringBuilder builder=new StringBuilder();
		while(count-- !=0) {
			int character=(int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		return builder.toString();
		
	}

}
