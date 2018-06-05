package com.rinf.dell.test;

import com.rinf.dell.test.model.Customer;
import com.rinf.dell.test.model.CustomerDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CustomerUtils {

	private static final String MAIL_REGEX = "^[A-Za-z0-9._%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}$";

	public static Customer convertDtoToCustomer(CustomerDto customerDto) {
		return new Customer(customerDto.getName(),customerDto.getMail(), customerDto.getComment());
	}

	public static CustomerDto convertCustomerToDto(Customer customer) {
		return new CustomerDto(customer.getName(),customer.getMail(), customer.getComment());
	}

	public static boolean isMailValid(String mail) {
		if(mail == null || mail.isEmpty()){
			return false;
		}

		Pattern pattern = Pattern.compile(MAIL_REGEX);
		Matcher matcher = pattern.matcher(mail);

		return matcher.find();
	}

}
