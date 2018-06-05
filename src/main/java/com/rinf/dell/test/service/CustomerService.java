package com.rinf.dell.test.service;

import com.rinf.dell.test.dao.CustomerRepository;
import com.rinf.dell.test.model.Customer;
import com.rinf.dell.test.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public CustomerDto addOrUpdateCustomer(CustomerDto customerDto){
		Customer existingCustomer = customerRepository.findByMail(customerDto.getMail());

		if(existingCustomer != null){
			return updateCustomer(customerDto, existingCustomer);
		} else {
			return convertCustomerToDto(customerRepository.save(convertDtoToCustomer(customerDto)));
		}
	}

	private CustomerDto updateCustomer(CustomerDto customerDto, Customer existingCustomer) {
		existingCustomer.setName(customerDto.getName());
		existingCustomer.setComment(customerDto.getComment());
		return convertCustomerToDto(customerRepository.save(existingCustomer));
	}

	private Customer convertDtoToCustomer(CustomerDto customerDto) {
		return new Customer(customerDto.getName(),customerDto.getMail(), customerDto.getComment());
	}

	private CustomerDto convertCustomerToDto(Customer customer) {
		return new CustomerDto(customer.getName(),customer.getMail(), customer.getComment());
	}
}
