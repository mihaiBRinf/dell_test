package com.rinf.dell.test.service;

import com.rinf.dell.test.TestUtils;
import com.rinf.dell.test.dao.CustomerRepository;
import com.rinf.dell.test.model.Customer;
import com.rinf.dell.test.model.CustomerDto;
import com.rinf.dell.test.model.CustomerResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	CustomerService customerService;

	@MockBean
	CustomerRepository customerRepository;

	@Before
	public void setUp() {


	}

	@Test
	public void shouldHaveInvalidMail(){
		//given
		CustomerDto customerDto = new CustomerDto(TestUtils.TEST_NAME,TestUtils.TEST_BAD_MAIL,TestUtils.TEST_COMMENT);

		//when
		CustomerResponse response = customerService.addOrUpdateCustomer(customerDto);

		//then
		assertEquals(response.getResponseMessage(),"Please add a valid mail address");
	}

	@Test
	public void shouldHaveMissingCustomerName(){
		//given
		CustomerDto customerDto = new CustomerDto("",TestUtils.TEST_GOOD_MAIL,TestUtils.TEST_COMMENT);

		//when
		CustomerResponse response = customerService.addOrUpdateCustomer(customerDto);

		//then
		assertEquals(response.getResponseMessage(),"Customer name is a mandatory field");
	}

	@Test
	public void shouldUpdateCustomer(){
		//given
		CustomerDto customerDto = new CustomerDto(TestUtils.TEST_NAME,TestUtils.TEST_GOOD_MAIL,TestUtils.TEST_COMMENT);
		Customer customer = new Customer(1l, TestUtils.TEST_NAME,TestUtils.TEST_GOOD_MAIL,TestUtils.TEST_COMMENT);

		Mockito.when(customerRepository.findByMail(customer.getMail()))
				.thenReturn(customer);
		Mockito.when(customerRepository.save(customer))
				.thenReturn(customer);

		//when
		CustomerResponse response = customerService.addOrUpdateCustomer(customerDto);

		//then
		assertEquals(response.getResponseMessage(),"Customer was successfully updated");
	}

	@Test
	public void shouldCreateCustomer(){
		//given
		CustomerDto customerDto = new CustomerDto(TestUtils.TEST_NAME,TestUtils.TEST_GOOD_MAIL,TestUtils.TEST_COMMENT);
		Customer customer = new Customer(null,TestUtils.TEST_NAME,TestUtils.TEST_GOOD_MAIL,TestUtils.TEST_COMMENT);

		Mockito.when(customerRepository.findByMail(customer.getMail()))
				.thenReturn(null);
		Mockito.when(customerRepository.save((Customer) anyObject()))
				.thenReturn(customer);

		//when
		CustomerResponse response = customerService.addOrUpdateCustomer(customerDto);

		//then
		assertEquals(response.getResponseMessage(),"Customer was successfully created");
	}
}
