package com.botreeconsulting.ioc.service.impl;

public class PDFDocument extends AbstractDocument {

	public PDFDocument() {
		System.out.println("Initializing PDFDocument");
	}
	
	@Override
	public void render() {
		System.out.println("Rendering PDF document...");
	}

}
