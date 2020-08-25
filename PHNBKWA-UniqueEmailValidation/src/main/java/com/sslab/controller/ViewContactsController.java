/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sslab.dto.Contact;
import com.sslab.service.ContactService;

/**
 * @author TRINATH , Jul 7, 2020
 *
 * @Description :
 */
@Controller
public class ViewContactsController {

	@Autowired
	private ContactService contactService;
	@RequestMapping("/editContact")
	public String  editContact(@RequestParam("contactId") Integer contactId,Model model) {
		Contact contact = contactService.getContactById(contactId);
		model.addAttribute("contact", contact);
		return "contactinfo";
	}
	@RequestMapping("/deleteContact")
	public String deleteContact(@RequestParam("contactId") Integer contactId) {
		
		boolean deleteContactById = contactService.deleteContactById(contactId);
		if(deleteContactById) {
			return "redirect:/viewContacts";
		}else {
			return "Record Can't be deleted";
		}
		
	}
	
}
