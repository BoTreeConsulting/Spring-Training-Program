package com.botreeconsulting.lms.web.binding;

import java.beans.PropertyEditorSupport;

import com.botreeconsulting.lms.model.SSN;

public class SSNEditor extends PropertyEditorSupport{
	
	public void setAsText(String inputText) {
        setValue(new SSN(inputText.toUpperCase()));
    }
}