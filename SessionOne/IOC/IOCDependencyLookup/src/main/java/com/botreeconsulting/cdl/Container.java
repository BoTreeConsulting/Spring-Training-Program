package com.botreeconsulting.cdl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Container {

	private static final String BEAN_NAME = "broadcaster";
	private static ApplicationContext applicationContext;
	private static Map<String, ContainerManagedBroadcaster> components = new HashMap<String, ContainerManagedBroadcaster>();
	
	public static void initializeBeanFactory(String fileInClassPath) {
		applicationContext = new ClassPathXmlApplicationContext(
				"/applicationContext.xml");
		ContainerManagedBroadcaster broadcaster = (ContainerManagedBroadcaster) applicationContext
				.getBean("broadcaster");
		registerComponent(BEAN_NAME, broadcaster);		
	}

	private static void registerComponent(String beanname,
			ContainerManagedBroadcaster managedComponent) {
		components.put(BEAN_NAME, managedComponent);
	}
	
	public static Object lookUpComponent(String beanName) {
		return components.get(beanName);
	}	
}