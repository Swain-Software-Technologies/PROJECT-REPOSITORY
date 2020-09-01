/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.users.domain;

import lombok.Data;

/**
 * @author TRINATH , Aug 23, 2020
 *
 * @Description :
 */
@Data
public class UnlockAccount {

	private String userEmail;
	private String tempPassword;
	private String newPassword;
	private String confirmPassword;
	
	
}
