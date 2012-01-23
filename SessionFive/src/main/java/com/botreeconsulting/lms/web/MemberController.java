package com.botreeconsulting.lms.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.botreeconsulting.lms.model.Member;

@Controller
@RequestMapping(value="member")
public class MemberController {

	@RequestMapping("add")
	public String showAddMemberForm(@ModelAttribute Member member) {
		return "addMember";
	}
	
	/**
	 * The BindingResult parameter must be positioned directly after the corresponding model argument that is being validated.
	 * 
	 * @param member
	 * @param result
	 * @param errors
	 * @return
	 */
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String submitLoginForm(@Valid @ModelAttribute Member member, BindingResult result, Errors errors) {
		
		if(result.hasErrors()) {
			return "addMember";
		}
		
		return "redirect:/dashboard";
	}
}
