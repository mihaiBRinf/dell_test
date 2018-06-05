package com.rinf.dell.test;

import com.rinf.dell.test.model.Customer;
import com.rinf.dell.test.model.CustomerDto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerUtilsTest {

	@Test
	public void shouldValidateMail(){
		//when
		boolean response = CustomerUtils.isMailValid(TestUtils.TEST_GOOD_MAIL);

		//then
		assertEquals(response,true);
	}

	@Test
	public void shouldFailValidateMail(){
		//when
		boolean response = CustomerUtils.isMailValid(TestUtils.TEST_BAD_MAIL);

		//then
		assertEquals(response,false);
	}

	@Test
	public void shouldConvertDtoToCustomer(){
		//given
		CustomerDto customerDto = new CustomerDto(TestUtils.TEST_NAME,TestUtils.TEST_GOOD_MAIL,TestUtils.TEST_COMMENT);

		//when
		Customer response = CustomerUtils.convertDtoToCustomer(customerDto);

		//then
		assertEquals(response.getName(),TestUtils.TEST_NAME);
		assertEquals(response.getMail(),TestUtils.TEST_GOOD_MAIL);
		assertEquals(response.getComment(),TestUtils.TEST_COMMENT);
	}

	@Test
	public void shouldConvertCustomerToDto(){
		//given
		Customer customer = new Customer(TestUtils.TEST_NAME,TestUtils.TEST_GOOD_MAIL,TestUtils.TEST_COMMENT);

		//when
		CustomerDto response = CustomerUtils.convertCustomerToDto(customer);

		//then
		assertEquals(response.getName(),TestUtils.TEST_NAME);
		assertEquals(response.getMail(),TestUtils.TEST_GOOD_MAIL);
		assertEquals(response.getComment(),TestUtils.TEST_COMMENT);
	}
}
