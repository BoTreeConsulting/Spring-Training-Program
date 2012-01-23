package com.botreeconsulting.lms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.botreeconsulting.lms.model.SSN;
import com.botreeconsulting.lms.model.User;
import com.botreeconsulting.lms.service.UserService;
import com.botreeconsulting.lms.web.binding.SSNEditor;

@Controller
@RequestMapping(value="user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(SSN.class, new SSNEditor());
	}

	
	@RequestMapping(method=RequestMethod.GET)
	public String showAllUsers(Model model) {
		
		model.addAttribute("users", userService.getAllUsers());
		
		return "userList";
	}
	
	/**
	 * Uses "URI Template Patterns" to parse <code>userId</code> from the URI pattern.
	 * 
	 * String between {} in RequestMapping is called URI template variable. e.g, {userId} is URI template variable 
	 * 
	 * @PathVariable is used to bind the method parameter to the value of a URI template variable. 
	 * This argument can be of any simple type such as int, long, Date, etc. Spring automatically converts to the appropriate type.
	 * 
	 * A method can have any number of @PathVariable annotations
	 * 
	 * @param userId
	 * @param model
	 * @return
	 * 
	 * @TypeMismatchException if spring fails to convert the value of URI template variable into the mapped method parameter type 
	 * 
	 */
	@RequestMapping(value="view/{userId}", method=RequestMethod.GET)
	public String displayUser(
			@PathVariable("userId") Long userId, Model model) {
		
		User user = userService.getUser(userId);
		model.addAttribute("user", user);
		
		return "viewUserDetails";
	}
	
	//TODO: Show alternative way to add "user" as request attribute
	@RequestMapping(method=RequestMethod.GET, value="add")
	public String showAddUserForm(
			@ModelAttribute User user) {
		return "addUserDetails";
	}

	@RequestMapping(method=RequestMethod.POST, value="add")
	public String submitAddUserForm(
			@ModelAttribute User user, 
			Model model) {
		
		userService.addUser(user);
		
		return "redirect:/user";	//Redirect to avoid duplicate form submission problem (post/redirect/get design pattern)
	}
	
	@RequestMapping(method=RequestMethod.GET, value="update/{userId}")
	public String showUpdateUserForm(
			@PathVariable("userId") Long userId, 
			Model model) {
		
		User user = userService.getUser(userId);
		model.addAttribute("user", user);
		
		return "updateUserDetails";
	}

	@RequestMapping(method=RequestMethod.POST, value="update")
	public String submitUpdateUserForm(@ModelAttribute User user, Model model) {
		
		userService.updateUser(user);
		
		return "redirect:/user";	//Redirect to avoid duplicate form submission problem (post/redirect/get design pattern)

	}
	
	@ModelAttribute("emptyUser")
	public User populateEmptyUser() {
		System.out.println("Calling populateEmptyUser()...");
		return new User();
	}
}
