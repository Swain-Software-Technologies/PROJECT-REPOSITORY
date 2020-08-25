/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sslab.dto.Contact;
import com.sslab.service.ContactService;


/**
 * @author TRINATH , Jul 7, 2020
 *
 * @Description : This is Controller Class Containing three operation i.e. load form,handlesubmitBtn and handleViewContactList .
 */
@Controller
public class ContactInfoController {
	
	private static final Logger logger=org.slf4j.LoggerFactory.getLogger(ContactInfoController.class);
	
	@Autowired
	private ContactService contactService;
	
	
	
	/**
	 * This method is used to load form to add new contact
	 * @param model
	 * @return contactinfo.jsp
	 */
	
	@GetMapping(value = {"/","/addContacts"})
	public String loadForm(Model model) {
		//We can send data from controller to UI using model object .
		Contact contact=new Contact();
		model.addAttribute("contact", contact);
		return "contactinfo";
	}
	/**
	 * This methd is used to handle the contact save form submission .
	 * @param contact
	 * @param model
	 * @return
	 */
	@PostMapping("/saveContact")
	public String handleSubmitBtn(@ModelAttribute("contact") Contact contact,/*Model model*/RedirectAttributes attributes) {
		
//		logger.info("contact form submitted "+contact);
		boolean isSaved=contactService.saveContact(contact);
		
		/*if(isSaved) {
			model.addAttribute("successMsg", "Contact Saved Successfully");
		}else {
			model.addAttribute("errorMsg", "Failed To Saved Contact");
		}*/
		
		//Another way
		if(isSaved) {
			attributes.addFlashAttribute("successMsg", "Contact Saved Successfully");
		}else {
			attributes.addFlashAttribute("errorMsg", "Failed To Saved Contact");
		}
		return "redirect:/contactSavedSucceess";
	}
	/**
	 * This method is used to display the success message post saving of contact .
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/contactSavedSucceess",method = RequestMethod.GET)
	public String contactSavedSuccessfully(Model model) {
		logger.info("contactSavedSuccessfully method called");
		Contact contact=new Contact();
		model.addAttribute("contact", contact);
		model.addAttribute("successMsg", "Contact Saved Successfully");
		return "contactinfo";
		
	}
	@GetMapping("/viewContacts")
	public String viewContactsList(Model model) {
		List<Contact> contactsList=contactService.getAllContact();
		model.addAttribute("contacts", contactsList);
		return "viewContacts";
		
	}
	
	/**
	 * 
	 * @param contactEmail
	 * @return emailStatus
	 */
	@GetMapping("/validateEmail")
	@ResponseBody
	public String validateEmail(@RequestParam("contactEmail") String contactEmail) {
		String emailStatus=contactService.findByEmail(contactEmail);
		return emailStatus;
	}
//	Or
	/**
	 * 
	 * @param req
	 * @return emailStatus
	 */
	/*	@GetMapping("/validateEmail")
		public @ResponseBody String validateEmail(HttpServletRequest req) {
			String contactEmail=req.getParameter("contactEmail");
			String emailStatus= contactService.findByEmail(contactEmail);
			return emailStatus;
		}*/
	
	
}
