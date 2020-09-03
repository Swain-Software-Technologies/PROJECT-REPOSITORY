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
 * @Description : This is Entity Class For CITY_MASER table
 */
@Data
@Entity
@Table(name = "CITIES_MASTER")
public class CityMasterEntity {

	@Id
	@GeneratedValue
	@Column(name = "CITY_ID")
	private Integer cityId;
	@Column(name = "STATE_ID")
	private Integer stateId;
	@Column(name = "CITY_NAME")
	private String cityName;
}
