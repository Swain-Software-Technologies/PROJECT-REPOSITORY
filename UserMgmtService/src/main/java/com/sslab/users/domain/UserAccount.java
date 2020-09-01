/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.users.domain;

import java.util.Date;

import lombok.Data;

/**
 * @author TRINATH , Aug 10, 2020
 *
 * @Description :
 */
@Data
public class UserAccount {

	private Integer userId;
	private String usrfirstName;
	private String usrLastName;
	private String userEmail;
	private String  userPassword;
	private String userPhoneNumber;
	private Date dateOfBirth;
	private Character userGender;
	private Integer cityId;
	private Integer stateId;
	private Integer countryId;
	private String accStatus;
	private Date createdDate;
	private Date updatedDate;
	private String createdBy;
	private String updatedBy;
}
