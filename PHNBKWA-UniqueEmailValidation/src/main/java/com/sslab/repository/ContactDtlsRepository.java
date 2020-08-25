/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sslab.entity.ContactEntity;

/**
 * @author TRINATH , Jul 6, 2020
 *
 * @Description : This interface is used to access the pre-defined methods
 *              provided by JpaRepository to perform curd operations .
 * 
 */
public interface ContactDtlsRepository extends JpaRepository<ContactEntity, Serializable> {
	
	
	/*
	 * JpaRepository<ContactEntity, Primary Key Datatype i.e Integer> It is
	 * recommended to keep Serilizable because It sometimes Long,Float ,Alphaumeric
	 * etc
	 */
	 public ContactEntity findByContactEmail(String contactEmail);
	 

}
