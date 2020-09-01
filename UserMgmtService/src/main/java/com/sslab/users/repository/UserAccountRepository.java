/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.users.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sslab.users.entity.UserAccountEntity;

/**
 * @author TRINATH , Aug 10, 2020
 *
 * @Description :
 */
public interface UserAccountRepository extends JpaRepository<UserAccountEntity, Serializable> {

	UserAccountEntity findByUserPasswordAndUserEmail(String userPassword, String userEmail);

//	@Query(value = "SELECT COUNT(*) FROM UserAccountEntity WHERE userEmail=:uname and userPassword=:userPassword and accStatus=:accStatus")
	/*public int validateLogin(@Param("uname") String uname, @Param("userPassword") String userPassword,
			@Param("accStatus") String accStatus);*/
	@Query(value = "SELECT COUNT(*) FROM UserAccountEntity WHERE userEmail=:uname and userPassword=:userPassword")
	 public int validateLogin(@Param("uname") String uname, @Param("userPassword") String userPassword);
}
