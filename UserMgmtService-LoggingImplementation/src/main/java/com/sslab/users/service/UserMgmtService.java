/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.users.service;

import java.util.Map;

import com.sslab.users.domain.UserAccount;

/**
 * @author TRINATH , Aug 10, 2020
 *
 * @Description :
 */
public interface UserMgmtService {
	
	public Map<Integer, String> getAllCountries();
	public Map<Integer, String> getStatesByCountryId(Integer countryId);
	public Map<Integer, String> getCitiesByStateId(Integer stateId);
	
	public boolean saveUserAcc(UserAccount userAcc);
	public UserAccount getUserByTempPassword(String tempPwd, String userEmail);
	public boolean updateUserAcc(UserAccount userAcc);
	
	public String login(UserAccount userAccount);

}
