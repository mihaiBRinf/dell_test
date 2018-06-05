package com.rinf.dell.test.controller;

import com.rinf.dell.test.model.CustomerDto;
import com.rinf.dell.test.model.CustomerResponse;
import com.rinf.dell.test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class DellTestController {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/")
	public String helloThere(){
		return "Hello There";
	}

	@RequestMapping(method = RequestMethod.POST, value="/addOrUpdateCustomer")
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerResponse addOrUpdateCustomer(@RequestBody CustomerDto customer){
		return customerService.addOrUpdateCustomer(customer);
	}

}
