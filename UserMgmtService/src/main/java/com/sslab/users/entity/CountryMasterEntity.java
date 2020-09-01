/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author TRINATH , Aug 2, 2020
 *
 * @Description : This is entity class of COUNTRY_MASTER table .
 */
@Entity
@Table(name="COUNTRY_MASTER")
@Data
public class CountryMasterEntity {
	
	@Id
	@GeneratedValue
	@Column(name="COUNTRY_ID")
	private Integer countryId;
	@Column(name = "COUNTRY_CODE")
	private String countryCode;
	@Column(name = "COUNTRY_NAME")
	private String countryName;

}
