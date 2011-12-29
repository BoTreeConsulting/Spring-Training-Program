package com.botreeconsulting.ioc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import com.botreeconsulting.utils.XMLHelper;


public class ReflectionXMLBeanFactory {

	private Map<String, Object> mapOfBeans;
	
	private ReflectionXMLBeanFactory() {
		loadBeanDefinitaions();
	}
	
	/**
	 * Loads bean definitions from application-context.xml
	 */
	private void loadBeanDefinitaions() {
		
		mapOfBeans = new HashMap<String, Object>();
		mapOfBeans.put("car", getInstanceByBeanName("car"));
		mapOfBeans.put("bus", getInstanceByBeanName("bus"));
	}

	/**
	 * Loads class and create instance
	 * 
	 * @param beanName
	 * @return
	 */
	private Object getInstanceByBeanName(String beanName) {
		
		String fullyQualifiedClass = XMLHelper.getFullyQualifiedClass(beanName);
		
		try {
			
			Class<?> class1 = Class.forName(fullyQualifiedClass);
			return class1.newInstance();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
	 * not before.
	 */
	private static class SingletonHolder {
		public static final ReflectionXMLBeanFactory instance = new ReflectionXMLBeanFactory();
	}

	/**
	 * Get the unique instance of this class
	 *     
	 * @return
	 */
	public static ReflectionXMLBeanFactory getInstance() {
		return SingletonHolder.instance;
	}

	/**
	 * Return an instance, which may be shared or independent, of the specified bean with name <code>beanName</code> 
	 * 
	 * @param beanName
	 * @return
	 */
	public Object getBean(String beanName) {
		if(!mapOfBeans.containsKey(beanName))
			throw new NoSuchBeanDefinitionException(beanName);
		return mapOfBeans.get(beanName);
	}
}
