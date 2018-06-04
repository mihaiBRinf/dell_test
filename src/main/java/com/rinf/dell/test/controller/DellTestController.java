package com.rinf.dell.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DellTestController {

	@RequestMapping("/test")
	public Test testMe(){
		return new Test(1L,"Hello There");
}

}
