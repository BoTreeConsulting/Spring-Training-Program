package com.botreeconsulting.lms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.botreeconsulting.lms.model.SSN;

@Controller
@RequestMapping("binding")
public class PostProcessorDataBindingController {

	@RequestMapping("{ssn}")
	public @ResponseBody String getSSN(@PathVariable SSN ssn) {
		return ssn.toString();
	}
}
