/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.users.controller;

import java.util.Map;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sslab.users.command.UserCommand;
import com.sslab.users.domain.UnlockAccount;
import com.sslab.users.domain.UserAccount;
import com.sslab.users.service.UserMgmtService;

/**
 * @author TRINATH , Aug 10, 2020
 *
 * @Description :
 */
@Controller
public class UserMgmtController {
	
	private static Logger logger=org.slf4j.LoggerFactory.getLogger(UserMgmtController.class);
	@Autowired
	private UserMgmtService userMgmtService;
	
	@RequestMapping(value = {"/","/login"})
	public String logInForm() {
		return "loginform";
	}
	@PostMapping(value= {"/loginprocess"})
	public String processLoginForm(Map<String,Object> map, @ModelAttribute("userCommand") UserCommand userCommand ) {
		
			logger.debug("**********Method Execution Started***********");
			try {
				String resultMsg=null;
			      UserAccount userAccount=null;
			      //convert Command to DTO
			      userAccount=new UserAccount();
			      BeanUtils.copyProperties(userCommand, userAccount);
					//use service
			      resultMsg=userMgmtService.login(userAccount);
			      map.put("result",resultMsg);
			} catch (Exception e) {
				logger.error("Exception Occured :: "+e.getMessage());
			}
		      logger.debug("**********Method Execution Ended *************");
		      logger.info("**********Login Success PAge Loaded************");
		      return "loginsuccess";
		
	}
	@RequestMapping("/loadform")
	public String loadForm(Model model) {
		logger.debug("********Method Execution Started**********************");
		try {
			UserAccount userAccount=new UserAccount();
			model.addAttribute("userAccount",userAccount);
			Map<Integer, String> countryMap=userMgmtService.getAllCountries();
			model.addAttribute("countryMap",countryMap);
		} catch (Exception e) {
			logger.error("Exception Occured :: "+e.getMessage());
		}
		logger.debug("**************Method Execution Ended***************");
		logger.info("Registration Form Loaded Successfully");
		return "registrationForm";
	}
	
	@ResponseBody
	@RequestMapping("/getstates")
	public Map<Integer, String> getStatesByCountryId(@RequestParam("cntryId") Integer countryId){
		logger.debug("**************Method Execution started***************");
		Map<Integer, String> statesMap=null;
		try {
			 statesMap=userMgmtService.getStatesByCountryId(countryId);
		} catch (Exception e) {
			logger.error("Exception Occured ::"+e.getMessage());
		}
		logger.debug("**************Method Execution Ended***************");
		return statesMap;
		
	}
	
	@ResponseBody
	@RequestMapping("/getcities")
	public Map<Integer,String> getCitiesByStateId(@RequestParam("statId") Integer stateId){
		logger.debug("**************Method Execution Started***************");
		Map<Integer, String> citiesMap=null;
		try {
			citiesMap = userMgmtService.getCitiesByStateId(stateId);
		} catch (Exception e) {
			logger.error("Exception Occured :: "+e.getMessage());
		}
		logger.debug("**************Method Execution Ended***************");
		return citiesMap;
	}
	
	@RequestMapping(value = "/userAccReg", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("userAccount") UserAccount userAccount, Model model) {
		logger.debug("**************Method Execution Started***************");
		try {
			userMgmtService.saveUserAcc(userAccount);
			logger.info("**********User Registration Successfully done***************");
		} catch (Exception e) {
			logger.error("Exception Occured :: "+e.getMessage());
		}
		logger.debug("**************Method Execution Ended***************");
		logger.info("**********Registration Success Page Loaded************");
		return "redirect:/userregistrationsuccess";
		
	}
	/**
	 *  This method is used to display post registration 
	 * @return
	 */
	@RequestMapping(value="/userregistrationsuccess", method = RequestMethod.GET)
	public String registerUserProcess() {
		logger.info("**************Method Execution Started***************");
		return "userAccRegSuccess";
		
	}

}
