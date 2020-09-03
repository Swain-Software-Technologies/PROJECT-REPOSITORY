/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.users.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sslab.users.constants.AppConstants;
import com.sslab.users.domain.UserAccount;
import com.sslab.users.entity.CityMasterEntity;
import com.sslab.users.entity.CountryMasterEntity;
import com.sslab.users.entity.StateMasterEntity;
import com.sslab.users.entity.UserAccountEntity;
import com.sslab.users.repository.CityMasterRepository;
import com.sslab.users.repository.CountryMasterRepository;
import com.sslab.users.repository.StateMasterRepository;
import com.sslab.users.repository.UserAccountRepository;
import com.sslab.users.util.EmailUtils;
import com.sslab.users.util.PwdUtils;

/**
 * @author TRINATH , Aug 10, 2020
 *
 * @Description :
 */
@Service("userService")
public class UserMgmtServiceImpl implements UserMgmtService {
	
	private static Logger logger= LoggerFactory.getLogger(UserMgmtServiceImpl.class);
	
	@Autowired
	private CountryMasterRepository countryMasterRepository;
	
	@Autowired
	private StateMasterRepository stateMasterRepository;
	
	@Autowired
	private CityMasterRepository cityMasterRepository;
	
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Autowired
	private EmailUtils emitUtils;

	@Override
	public Map<Integer, String> getAllCountries() {
		logger.debug("****getAllCountries() Method Executtion Started****");
		Map<Integer,String> countryMap=new LinkedHashMap<Integer, String>();
		try {
			List<CountryMasterEntity> countriesList=countryMasterRepository.findAll();
			countriesList.forEach(countryEntity->{
				countryMap.put(countryEntity.getCountryId(), countryEntity.getCountryName());
			});
		} catch (Exception e) {
			logger.error("Exception Occured :: "+e.getMessage());
		}
		
		logger.debug("****getAllCountries() Method Executtion Ended****");
		return countryMap;
	}

	@Override
	public Map<Integer, String> getStatesByCountryId(Integer countryId) {
		logger.debug("****getStatesByCountryId() method Execution Started****");
		Map<Integer,String> stateMap=new LinkedHashMap<Integer, String>();
		try {
			List<StateMasterEntity> states=stateMasterRepository.findByCountryId(countryId);
			states.forEach(stateEntity->{
				stateMap.put(stateEntity.getStateId(), stateEntity.getStateName());
			});
		} catch (Exception e) {
			logger.error("Exception Occured "+e.getMessage());
		}
		
		logger.debug("****getStatesByCountryId() method Execution Ended****");
		return stateMap;
	}

	@Override
	public Map<Integer, String> getCitiesByStateId(Integer stateId) {
		logger.debug("****getCitiesByStateId() method Execution Started***");
		Map<Integer, String> cityMap=new LinkedHashMap<Integer, String>();
		try {
			
			List<CityMasterEntity> cities=cityMasterRepository.findByStateId(stateId);
			cities.forEach(cityEntity->{
				cityMap.put(cityEntity.getCityId(), cityEntity.getCityName());
			});
		} catch (Exception e) {
			logger.error("Exception Occured "+e.getMessage());
		}
		
		logger.debug("****getCitiesByStateId() method Execution Ended***");
		return cityMap;
	}

	@Override
	public boolean saveUserAcc(UserAccount userAcc) {
		logger.debug("****saveUser() method Execution started***");
		userAcc.setUserPassword(PwdUtils.generateTempPwd(AppConstants.TEMP_PWD_LENGTH));
		userAcc.setAccStatus(AppConstants.LOCKED_STR);
		
		UserAccountEntity userAccountEntity = new UserAccountEntity();
		BeanUtils.copyProperties(userAcc, userAccountEntity);
		
		UserAccountEntity savedEntity = userAccountRepository.save(userAccountEntity);
		
		if(savedEntity.getUserId() != null) {
			logger.info("***Email is sent to User Emsil For Unlocking the Account***");
			return emitUtils.sendUserAccUnlockEmail(userAcc);
		}
		logger.debug("****saveUser() method Execution Ended***");
		return false;
	}

	@Override
	public UserAccount getUserByTempPassword(String tempPwd,String userEmail) {
		UserAccountEntity userAccountEntity=userAccountRepository.findByUserPasswordAndUserEmail(tempPwd,userEmail);
		UserAccount userAccount=null;
		if(userAccountEntity!=null) {
		    userAccount=new UserAccount();
			BeanUtils.copyProperties(userAccountEntity, userAccount);
		}
		return userAccount;
	}
	
	@Override
	public boolean updateUserAcc(UserAccount userAcc) {
		UserAccountEntity userAccountEntity=new UserAccountEntity();
		BeanUtils.copyProperties(userAcc,userAccountEntity);
		UserAccountEntity savedEntity = userAccountRepository.save(userAccountEntity);
		return savedEntity!=null;
	}
	 @Override
	public String login(UserAccount userAccount) {
		 long count=0;
		 count=userAccountRepository.validateLogin(userAccount.getUserEmail(), userAccount.getUserPassword());
		 if(count==0 && userAccount.getAccStatus()=="LOCKED" ) {
			 return "Invalid Credentials May be your Account Should be Locked";
		 }else {
			 return "WelCome To User Management System";
		 }
	}
}
