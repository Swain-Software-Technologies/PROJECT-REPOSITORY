/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.users.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

/**
 * @author TRINATH , Aug 2, 2020
 *
 * @Description :
 */
@Data
@Entity
@Table(name = "USER_ACCOUNTS")
public class UserAccountEntity {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "FIRST_NAME")
	private String usrfirstName;
	@Column(name = "LAST_NAME")
	private String usrLastName;
	@Column(name = "USER_EMAIL")
	private String userEmail;
	@Column(name = "USER_PWD")
	private String  userPassword;
	@Column(name = "USER_MOBILE")
	private String userPhoneNumber;
	@Column(name = "DOB")
	private Date dateOfBirth;
	@Column(name = "GENDER")
	private Character userGender;
	@Column(name = "CITY_ID")
	private Integer cityId;
	@Column(name = "STATE_ID")
	private Integer stateId;
	@Column(name = "COUNTRY_ID")
	private Integer countryId;
	@Column(name = "ACC_STATUS")
	private String accStatus;
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE",insertable = false)
	private Date updatedDate;
}
