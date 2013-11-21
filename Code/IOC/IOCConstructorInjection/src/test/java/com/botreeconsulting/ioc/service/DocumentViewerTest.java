package com.botreeconsulting.ioc.service;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.botreeconsulting.ioc.service.impl.DocumentViewer;
import com.botreeconsulting.ioc.service.impl.PDFDocument;
import com.botreeconsulting.ioc.service.impl.WordDocument;

public class DocumentViewerTest extends TestCase {

	public void testWordDocument() {
		
		// Instantiate container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		
		DocumentViewer viewer = (DocumentViewer) ctx.getBean("documentViewer");
		
		assertEquals(PDFDocument.class, viewer.getDocument().getClass());

		viewer.viewDocument();
		
	}
}
