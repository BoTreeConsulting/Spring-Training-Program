package com.botreeconsulting.ioc.service;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.botreeconsulting.ioc.service.impl.DocumentViewer;
import com.botreeconsulting.ioc.service.impl.PDFDocument;

public class DocumentViewerTest extends TestCase {

	public void testPDFDocument() {
		
		// Instantiate container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		
		DocumentViewer viewer = (DocumentViewer) ctx.getBean("documentViewer");
		
		assertEquals(true, viewer.getDocument() instanceof PDFDocument);

		viewer.viewDocument();
		
	}
}
