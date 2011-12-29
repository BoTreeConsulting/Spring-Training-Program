package com.botreeconsulting.utils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XMLHelper {

	/**
	 * Read application-context file, and return fully qualified class name for given <code>beanName</code>
	 * 
	 * @param beanName
	 * @return
	 * 
	 */
	public static String getFullyQualifiedClass(String beanName) {

		DocumentBuilderFactory docBuilderFactory = 
				DocumentBuilderFactory.newInstance();
		
		docBuilderFactory.setNamespaceAware(true);

		try {
			
			DocumentBuilder builder = docBuilderFactory.newDocumentBuilder();
			Document doc = builder.parse("application-context.xml");

			XPathFactory factory = XPathFactory.newInstance();
			XPath xpath = factory.newXPath();
			XPathExpression expr = xpath
					.compile("//bean[@name='"+ beanName +"']/@class");

			Object result = expr.evaluate(doc, XPathConstants.NODESET);

			NodeList nodes = (NodeList) result;
			if (nodes.getLength() > 0)
				return nodes.item(0).getNodeValue();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
