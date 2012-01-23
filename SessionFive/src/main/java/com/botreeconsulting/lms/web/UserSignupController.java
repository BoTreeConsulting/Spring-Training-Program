package com.botreeconsulting.lms.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.botreeconsulting.lms.model.UserLogin;

@Controller
public class UserSignupController {

	@InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new UserLoginValidator());
    }

	@RequestMapping("signup")
	public String showSignupForm(@ModelAttribute UserLogin userLogin) {
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
	@RequestMapping(value="signup", method=RequestMethod.POST)
	public String submitSignupForm(@Valid @ModelAttribute UserLogin userLogin, BindingResult result, Errors errors) {
		

		if(result.hasErrors()) {
			return "login";
		}
		
		return "redirect:/dashboard";
	}
	
}

