package com.botreeconsulting.appcontext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class TaskTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BeanFactory factory = new ClassPathXmlApplicationContext("com/botreeconsulting/appcontext/applicationContext.xml");
		//BeanFactory factory = new FileSystemXmlApplicationContext("E:/projects/Eyepegasus/workspace/application-context-example/src/com/botreeconsulting/appcontext/applicationContext.xml");
//		System.out.println("Factory ==> " + factory);
		
		//ConfigurableListableBeanFactory factory = new XmlBeanFactory(new ClassPathResource("com/botreeconsulting/appcontext/applicationContext.xml"));

		
		Task task  = (Task) factory.getBean("taskBean");
		System.out.println(task.getTaskName());
		
		
		ListBean listBean = (ListBean) factory.getBean("listBean");
		System.out.println(listBean.getList());
		
		Book book = (Book) factory.getBean("book");
		System.out.println(book.getAuthors());
		//((ClassPathXmlApplicationContext) factory).close();
		//factory.destroySingletons();
		/*Bean bean1 = (Bean) factory.getBean("myBean");
		System.out.println(bean1);
		Bean bean2 = (Bean) factory.getBean("myBean");
		System.out.println(bean2);
		
		Bean bean3 = (Bean) factory.getBean("myBean2");
		System.out.println(bean3);
		Bean bean4 = (Bean) factory.getBean("myBean2");
		System.out.println(bean4);*/
	}

}
