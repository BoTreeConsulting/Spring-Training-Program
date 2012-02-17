package com.botreeconsulting.ioc.service.impl;

import com.botreeconsulting.ioc.service.Document;

public class DocumentViewer {
	
	private Document document;
	
	public DocumentViewer(Document document) {
		this.document = document;
	}
	
	public void viewDocument() {
		
		document.open();
		
		document.render();
		
		document.close();
	}

	public Document getDocument() {
		return document;
	}
	
}
