/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sslab.users.constants.AppConstants;
import com.sslab.users.domain.UnlockAccount;
import com.sslab.users.domain.UserAccount;
import com.sslab.users.service.UserMgmtService;

/**
 * @author TRINATH , Aug 23, 2020
 *
 * @Description :
 */
@Controller
public class UnlockAccountController {
	
	@Autowired
	private UserMgmtService userMgmtService;

	@GetMapping(value = "/unlockAcc")
	public String displayUnlockAccForm(@RequestParam("userEmail") String userEmail,Model model) {
//		model.addAttribute("userEmail", userEmail);
		UnlockAccount unlockAccount = new UnlockAccount();
		unlockAccount.setUserEmail(userEmail);
		model.addAttribute("unlockAccount", unlockAccount);
		return "unlockAccForm";	
		
	}
	@PostMapping("/unlockUserAcc")
	public String unlockUserAcc(@ModelAttribute("unlockAccount") UnlockAccount unlockAccount,Model model) {

		System.out.println(unlockAccount);
		UserAccount userByTempPassword = userMgmtService.getUserByTempPassword(unlockAccount.getTempPassword(), unlockAccount.getUserEmail());
		if(userByTempPassword!=null) {
//			Update the Password and account status
			userByTempPassword.setAccStatus(AppConstants.UNLOCKED_STR);
			userByTempPassword.setUserPassword(unlockAccount.getNewPassword());
			boolean isUpdated = userMgmtService.updateUserAcc(userByTempPassword);
			if(isUpdated) {
				return "unlockAccSuccess";
			}
		}
//			Display Error msg on Same Form
			model.addAttribute("errMsg","Please Enter Correct Temp Password");
			return "unlockAccForm";
	}
	
}
