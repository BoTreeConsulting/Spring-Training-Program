package com.botreeconsulting.dp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanFactoryProvider {
	public static ApplicationContext 
					getBeanFactory(String fileInClassPath){
		
		return new ClassPathXmlApplicationContext(fileInClassPath);
		
	}
}
