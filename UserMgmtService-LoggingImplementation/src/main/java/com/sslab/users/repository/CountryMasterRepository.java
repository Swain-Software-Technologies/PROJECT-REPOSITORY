/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.users.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sslab.users.entity.CountryMasterEntity;

/**
 * @author TRINATH , Aug 10, 2020
 *
 * @Description :
 */
public interface CountryMasterRepository extends JpaRepository<CountryMasterEntity, Serializable>{

}
