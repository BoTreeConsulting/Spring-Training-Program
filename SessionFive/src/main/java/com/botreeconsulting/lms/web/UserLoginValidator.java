package com.botreeconsulting.lms.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.botreeconsulting.lms.model.UserLogin;

@Component
public class UserLoginValidator implements Validator {
	 
    private static final int MINIMUM_PASSWORD_LENGTH = 6;
 
    /**
     * Validates {@link UserLogin} instances, and any of its subclasses too
     */
    @SuppressWarnings("rawtypes")
    public boolean supports(Class clazz) {
    	
       return UserLogin.class.isAssignableFrom(clazz);
       
    }
 
    public void validate(Object target, Errors errors) {

       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "field.required","User Name Must not be empty");

       ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required","Password Must not be empty");

       UserLogin login = (UserLogin) target;

       if (login.getPassword() != null
             && login.getPassword().trim().length() < MINIMUM_PASSWORD_LENGTH) {

          errors.rejectValue("password", "field.min.length",
                new Object[]{Integer.valueOf(MINIMUM_PASSWORD_LENGTH)},
                "The password must be at least [" + MINIMUM_PASSWORD_LENGTH + "] characters in length.");
       }
    }
 }
