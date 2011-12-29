package com.botreeconsulting.ioc.service.impl;

import com.botreeconsulting.ioc.service.Document;

public abstract class AbstractDocument implements Document {
	
	@Override
	public void open() {
		System.out.println("Opening document....");
	}

	@Override
	public void close() {
		System.out.println("Closing document....");
	}

	@Override
	public abstract void render();

}
