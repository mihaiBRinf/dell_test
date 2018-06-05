package com.rinf.dell.test.service;

import com.rinf.dell.test.CustomerUtils;
import com.rinf.dell.test.dao.CustomerRepository;
import com.rinf.dell.test.model.Customer;
import com.rinf.dell.test.model.CustomerDto;
import com.rinf.dell.test.model.CustomerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	private static final String MISSING_CUSTOMER_NAME = "Customer name is a mandatory field";
	private static final String MAIL_NOT_VALID = "Please add a valid mail address";
	private static final String CUSTOMER_ADDED = "Customer was successfully created";
	private static final String CUSTOMER_UPDATED = "Customer was successfully updated";

	public CustomerResponse addOrUpdateCustomer(CustomerDto customerDto){
		if(!CustomerUtils.isMailValid(customerDto.getMail())){
			return new CustomerResponse(MAIL_NOT_VALID);
		}
		if(customerDto.getName() == null || customerDto.getName().isEmpty()){
			return new CustomerResponse(MISSING_CUSTOMER_NAME);
		}

		Customer existingCustomer = customerRepository.findByMail(customerDto.getMail());

		if(existingCustomer != null){
			Customer customer = updateCustomer(customerDto, existingCustomer);
			return new CustomerResponse(customer,CUSTOMER_UPDATED);
		} else {
			Customer customer = customerRepository.save(
					CustomerUtils.convertDtoToCustomer(customerDto));
			return new CustomerResponse(customer,CUSTOMER_ADDED);
		}
	}

	private Customer updateCustomer(CustomerDto customerDto, Customer existingCustomer) {
		existingCustomer.setName(customerDto.getName());
		existingCustomer.setComment(customerDto.getComment());
		return customerRepository.save(existingCustomer);
	}
}
