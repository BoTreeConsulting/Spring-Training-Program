package com.botree.dp.builder;

public class CivilEngineer {

	private HouseBuilder houseBuilder;

	public CivilEngineer(HouseBuilder houseBuilder) {
		System.out.println(getClass().getName() + " Constructor called");
		this.houseBuilder = houseBuilder;
	}

	public House getHouse() {
		System.out.println(getClass().getName() + ".getHouse() method called");
		return this.houseBuilder.getHouse();
	}

	public void constructHouse() {
		System.out.println(getClass().getName()
				+ ".constructHouse() method called");
		this.houseBuilder.buildBasement();
		this.houseBuilder.buildStructure();
		this.houseBuilder.bulidRoof();
		this.houseBuilder.buildInterior();
	}
}