package com.botreeconsulting.springmvc.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.botreeconsulting.springmvc.model.UserLogin;

@Controller
public class UserLoginController {

	@Autowired
	private UserLoginValidator userLoginValidator;
	
	@RequestMapping("login")
	public String showLoginForm(@ModelAttribute UserLogin userLogin) {
		return "login";
	}
	
	/**
	 * The BindingResult parameter must be positioned directly after the corresponding model argument that is being validated.
	 * 
	 * @param userLogin
	 * @param result
	 * @param errors
	 * @return
	 */
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String submitLoginForm(@ModelAttribute UserLogin userLogin, BindingResult result, Errors errors) {
		
		userLoginValidator.validate(userLogin, errors);
		
		if(result.hasErrors()) {
			return "login";
		}
		
		return "redirect:/dashboard";
	}
	
	@RequestMapping("dashboard")
	public String showDashboard() {
		return "loginSuccess";
	}
}
