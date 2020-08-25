/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.service;

import java.util.List;

import com.sslab.dto.Contact;
import com.sslab.entity.ContactEntity;

/**
 * @author TRINATH , Jul 7, 2020
 *
 * @Description :This interface contains the list of Operation in Application
 */
public interface ContactService {

	public boolean saveContact(Contact contact);

	public List<Contact> getAllContact();

	public Contact getContactById(Integer contactId);

	public boolean updateContact(Contact contact);

	public boolean deleteContactById(Integer contactId);
	
	public String findByEmail(String contactEmail);
}
