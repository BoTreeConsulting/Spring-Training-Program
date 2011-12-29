package com.botreeconsulting.dp.factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PizzaFactoryTest {

	private SimplePizzaFactory factory;
	private PizzaStore store;

	@Before
	public void setUp() {

		factory = new SimplePizzaFactory();

		store = new PizzaStore(factory);
	}

	@Test
	public void testOrderTwoCheesePizza() {

		Pizza cheesePizza1 = store.orderPizza("cheese");
		System.out.println("We ordered a " + cheesePizza1.getName() + "\n");

		Pizza cheesePizza2 = store.orderPizza("veggie");
		System.out.println("We ordered another " + cheesePizza2.getName()
				+ "\n");

		assertEquals(true, cheesePizza1 instanceof CheesePizza);

		assertEquals(true, cheesePizza1 instanceof CheesePizza);

		assertNotSame(cheesePizza1, cheesePizza2);

	}

	@Test
	public void testOrderVeggiePizza() {
		Pizza veggiePizza = store.orderPizza("veggie");
		System.out.println("We ordered a " + veggiePizza.getName() + "\n");

		assertEquals(true, veggiePizza instanceof VeggiePizza);
	}
}
