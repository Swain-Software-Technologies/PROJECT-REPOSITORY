/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.users.controller;

import java.util.Map;

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
	
	@Autowired
	private UserMgmtService userMgmtService;
	
	@RequestMapping(value = {"/","/login"})
	public String logInForm() {
		return "loginform";
	}
	@PostMapping(value= {"/loginprocess"})
	public String processLoginForm(Map<String,Object> map, @ModelAttribute("userCommand") UserCommand userCommand ) {
		      String resultMsg=null;
		      UserAccount userAccount=null;
		      //convert Command to DTO
		      userAccount=new UserAccount();
		      BeanUtils.copyProperties(userCommand, userAccount);
				//use service
		      resultMsg=userMgmtService.login(userAccount);
		      map.put("result",resultMsg);
		      return "loginsuccess";
		
	}
	@RequestMapping("/loadform")
	public String loadForm(Model model) {
		
		UserAccount userAccount=new UserAccount();
		model.addAttribute("userAccount",userAccount);
		Map<Integer, String> countryMap=userMgmtService.getAllCountries();
		model.addAttribute("countryMap",countryMap);
		return "registrationForm";
	}
	@ResponseBody
	@RequestMapping("/getstates")
	public Map<Integer, String> getStatesByCountryId(@RequestParam("cntryId") Integer countryId){
		return userMgmtService.getStatesByCountryId(countryId);
		
	}
	@ResponseBody
	@RequestMapping("/getcities")
	public Map<Integer,String> getCitiesByStateId(@RequestParam("statId") Integer stateId){
		return userMgmtService.getCitiesByStateId(stateId);
	}
	@RequestMapping(value = "/userAccReg", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("userAccount") UserAccount userAccount, Model model) {
		userMgmtService.saveUserAcc(userAccount);
		return "redirect:/userregistrationsuccess";
		
	}
	/**
	 *  This method is used to display post registration 
	 * @return
	 */
	@RequestMapping(value="/userregistrationsuccess", method = RequestMethod.GET)
	public String registerUserProcess() {
		return "userAccRegSuccess";
		
	}

}
