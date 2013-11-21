package com.botreeconsulting.ioc.service.impl;

import com.botreeconsulting.ioc.service.Document;

public class DocumentViewer {
	
	private Document document;
	
	public DocumentViewer() {
		System.out.println("Instantiating DocumentViewer...");
	}
	
	public DocumentViewer(Document document) {
		System.out.println("Constructor injection");
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

	public void setDocument(Document document) {
		System.out.println("setting the document property");
		this.document = document;
	}
	
	
}
