/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author TRINATH , Jul 7, 2020
 *
 * @Description : This Class is used as model dto class because In Controller we
 *              need not to use ContactEntity Class It is not recommended .
 */
@Data
public class Contact implements Serializable {

	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long contactNumber;
	private Date createdDate;
	private Date updatedDate;

}
