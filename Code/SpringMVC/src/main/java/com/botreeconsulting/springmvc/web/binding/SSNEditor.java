package com.botreeconsulting.springmvc.web.binding;

import java.beans.PropertyEditorSupport;

import com.botreeconsulting.springmvc.model.SSN;

public class SSNEditor extends PropertyEditorSupport{
	
	public void setAsText(String inputText) {
        setValue(new SSN(inputText.toUpperCase()));
    }
}