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
 * @Description : This is Entity Class For STATE_MASTER table
 */
@Entity
@Table(name="STATES_MASTER")
@Data
public class StateMasterEntity {
	@Id
	@GeneratedValue
	@Column(name = "STATE_ID")
	private Integer stateId;
	@Column(name = "COUNTRY_ID")
	private Integer countryId;
	@Column(name = "STATE_NAME")
	private String stateName;

}
