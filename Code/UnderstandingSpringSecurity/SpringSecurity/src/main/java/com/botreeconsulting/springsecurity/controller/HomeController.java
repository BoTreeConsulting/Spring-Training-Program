package com.botreeconsulting.springsecurity.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.botreeconsulting.springsecurity.utils.WebUtils.ViewNames;

@Controller
public class HomeController {
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse){
				
		ModelAndView modelAndView = new ModelAndView(ViewNames.HOME);		
		return modelAndView;
	}
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public ModelAndView loadAdmin(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse){				
		ModelAndView modelAndView = new ModelAndView(ViewNames.ADMIN);		
		return modelAndView;
	}
	
	@RequestMapping(value="/agent", method = RequestMethod.GET)
	public ModelAndView loadAgent(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse){
		
		ModelAndView modelAndView = new ModelAndView(ViewNames.AGENT);		
		return modelAndView;
	}
}
