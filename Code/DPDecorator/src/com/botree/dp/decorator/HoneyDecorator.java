package com.botree.dp.decorator;

public class HoneyDecorator extends IcecreamDecorator {

	public HoneyDecorator(Icecream specialIcecream) {
		super(specialIcecream);
	}

	public String makeIcecream() {
		return specialIcecream.makeIcecream() + addHoney();
	}

	private String addHoney() {
		return " + sweet honey";
	}
}