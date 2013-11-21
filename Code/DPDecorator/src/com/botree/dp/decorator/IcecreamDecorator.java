package com.botree.dp.decorator;

abstract class IcecreamDecorator implements Icecream {

	protected Icecream specialIcecream;

	public IcecreamDecorator(Icecream specialIcecream) {
		this.specialIcecream = specialIcecream;
	}

	public String makeIcecream() {
		return specialIcecream.makeIcecream();
	}
}