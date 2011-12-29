package com.botreeconsulting.dp.factory;

/**
 * Factory class to create different types of {@link Pizza}
 * 
 */
public class SimplePizzaFactory {

	/**
	 * Defines an interface for creating objects
	 * 
	 * @param type name of {@link Pizza}
	 * @return
	 */
	public Pizza createPizza(String type) {
		
		Pizza pizza = null;

		if (type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		} else if (type.equals("veggie")) {
			pizza = new VeggiePizza();
		}
		
		return pizza;
	}
}
