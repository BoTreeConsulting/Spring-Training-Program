import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;

public class Main {

	public static void main(String[] args) throws Exception {
		DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
		BeanDefinitionReader reader = new PropertiesBeanDefinitionReader(bf);
		reader.loadBeanDefinitions(new ClassPathResource("context.properties"));

		MessageService service = (MessageService) bf.getBean("service");
//		service.execute();
		
		DependantComponent dc = new DependantComponent(service);
		dc.run();
		
	}
}

class DependantComponent {
	private MessageService service;

	public DependantComponent(MessageService service) {
		Assert.notNull(service, "The 'service' argument must not be null.");
		this.service = service;
	}

	public void run() {
		this.service.execute();
	}
}

interface MessageService {

	void execute();

}

class DefaultMessageService implements MessageService {
	private MessageData source;

	private MessageReporter destination;

	public void execute() {
		this.destination.write(this.source.getMessage());
	}

	public void setSource(MessageData source) {
		this.source = source;
	}

	public void setDestination(MessageReporter destination) {
		this.destination = destination;
	}
}

interface MessageReporter {

	void write(String message);

}

interface MessageData {

	String getMessage();

}

class StdoutMessageReporter implements MessageReporter {

	public void write(String message) {
		System.out.println(message);
	}
}

class SimpleMessageData implements MessageData {
	private final String message;

	public SimpleMessageData() {
		this("Hello, world");
	}

	public SimpleMessageData(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}