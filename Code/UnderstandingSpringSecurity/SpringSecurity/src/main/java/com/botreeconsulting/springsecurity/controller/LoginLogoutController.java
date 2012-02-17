package com.botreeconsulting.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.botreeconsulting.springsecurity.utils.WebUtils.ViewNames;

@Controller
public class LoginLogoutController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView(ViewNames.LOGIN);
		return modelAndView;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView(ViewNames.LOGOUT);
		return modelAndView;
	}
}
