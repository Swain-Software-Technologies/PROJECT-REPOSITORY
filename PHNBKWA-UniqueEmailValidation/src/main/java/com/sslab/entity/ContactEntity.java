/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Term & condition will be apply .
 */
package com.sslab.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

/**
 * @author TRINATH , Jul 6, 2020
 *
 * @Description : This class is Mapped with Database .
 */
@Data
@Entity
@Table(name = "CONTACT_DTLS")
public class ContactEntity {

	@Id
	@Column(name = "CONTACT_ID")
	@SequenceGenerator(name = "cid_seq_gen", sequenceName = "CONTACT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(generator = "cid_seq_gen", strategy = GenerationType.SEQUENCE)
	private Integer contactId;
	@Column(name = "CONTACT_NAME")
	private String contactName;
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	@Column(name = "CONTACT_NUMBER")
	private Long contactNumber;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE",updatable = false)
	private Date createdDate;

	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE",insertable = false)
	private Date updatedDate;

}
