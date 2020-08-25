/*
 * @CopyRight to SSLab Pvt. Ltd. 2020. You should not disclose the information outside .
 * Otherwise Terms & Condition will be apply .
 */
package com.sslab.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sslab.dto.Contact;
import com.sslab.entity.ContactEntity;
import com.sslab.repository.ContactDtlsRepository;

/**
 * @author TRINATH , Jul 7, 2020
 *
 * @Description : This is implemented class of ContactService(I) .
 */
@Service
public class ContactServiceImpl implements ContactService {

	/*
	 * To communicate with Repository layer we can inject This Repository It will
	 * provide the method to perform crud operation ...
	 */

	@Autowired
	private ContactDtlsRepository contactRepository;

	/**
	 * This method called the predefined methods of JpaRepository(I) to perform save
	 * operation
	 * 
	 * @param(Contact) This method will return boolean value to controller .
	 */

	@Override
	public boolean saveContact(Contact contact) {

		ContactEntity contactEntity = new ContactEntity();
		BeanUtils.copyProperties(contact, contactEntity); // Convert contact object to entity object .
		ContactEntity savedEntity = contactRepository.save(contactEntity);// It will return Object with Primary Key .
		return savedEntity.getContactId() != null;
	}

	/**
	 * This method is used to fetch all the contact From DB using predefined methods
	 * of JpaRepository(I) to perform Select operation . This method will return
	 * List<Contact> Object to controller
	 */
	@Override
	public List<Contact> getAllContact() {
		List<ContactEntity> contactEntities = contactRepository.findAll();

//		BeanUtils.copyProperties(contactEntities, contacts); // It is not possible we can't copy directly in this case .Her One Object is present that's we go through Loop

//		Java 7 Approach
		
		/*List<Contact> contacts = new ArrayList<Contact>();
		for (ContactEntity contactEntity : contactEntities) {
			Contact contact = new Contact();
			BeanUtils.copyProperties(contactEntity, contact);
			contacts.add(contact);
		}
		
		return contacts;*/
		
//		Java 8 Approach
		
		return contactEntities.stream().map(entity -> {
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());

		
	}

	/**
	 * This method is used to edit the record by using predefined methods of
	 * JpaRepository(I) to perform Edit operation .
	 * 
	 * @param(contactId) This method will return Contact Object to Controller
	 */

	@Override
	public Contact getContactById(Integer contactId) {
		
		Optional<ContactEntity> findById = contactRepository.findById(contactId);
		if(findById.isPresent()) {
			ContactEntity contactEntity=findById.get();
			Contact contact=new Contact();
			BeanUtils.copyProperties(contactEntity, contact);
			return contact;
		}else {
			return null;
		}
	}

	/**
	 * This method is used to update the record by using predefined methods of
	 * JpaRepository(I) to perform update operation .
	 * 
	 * @param(Contact) This method will return boolean value
	 */
	@Override
	public boolean updateContact(Contact contact) {
		
		return false;
	}

	/**
	 * This method is used to delete the record by using predefined methods of
	 * JpaRepository(I) to perform delete operation .
	 * 
	 * @param (contactId)
	 */
	@Override
	public boolean deleteContactById(Integer contactId) {
		contactRepository.deleteById(contactId);
		return true;
	}

}
