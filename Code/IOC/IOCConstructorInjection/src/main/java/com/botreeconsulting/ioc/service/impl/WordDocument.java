package com.botreeconsulting.ioc.service.impl;

public class WordDocument extends AbstractDocument {

	public WordDocument() {
		System.out.println("Initializing WordDocument");
	}
	
	@Override
	public void render() {
		System.out.println("Rendering WordDocument...");
	}

}
