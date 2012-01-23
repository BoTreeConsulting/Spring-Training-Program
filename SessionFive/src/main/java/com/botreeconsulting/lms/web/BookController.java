package com.botreeconsulting.lms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book/**")
public class BookController {

	@RequestMapping
	public @ResponseBody String greet() {
		return "Hi Book!";
	}
	
	@RequestMapping(value="meet")
	public @ResponseBody String meet() {
		return "Nice to meet you Book!";
	}
}
