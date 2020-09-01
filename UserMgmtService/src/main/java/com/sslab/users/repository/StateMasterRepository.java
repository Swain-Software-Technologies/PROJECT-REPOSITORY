/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.users.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sslab.users.entity.StateMasterEntity;

/**
 * @author TRINATH , Aug 10, 2020
 *
 * @Description :
 */
public interface StateMasterRepository extends JpaRepository<StateMasterEntity, Serializable>{
	
	List<StateMasterEntity> findByCountryId(Integer countryId);
	

}
