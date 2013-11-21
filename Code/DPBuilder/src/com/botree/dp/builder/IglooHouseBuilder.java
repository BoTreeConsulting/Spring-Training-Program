package com.botree.dp.builder;

public class IglooHouseBuilder implements HouseBuilder {

	private House house;

	public IglooHouseBuilder() {
		this.house = new House();
	}

	public void buildBasement() {
		System.out.println(getClass().getName()
				+ ".buildBasement() method called");
		house.setBasement("Ice Bars");
	}

	public void buildStructure() {
		System.out.println(getClass().getName()
				+ ".buildStructure() method called");
		house.setStructure("Ice Blocks");
	}

	public void buildInterior() {
		System.out.println(getClass().getName()
				+ ".buildInterior() method called");
		house.setInterior("Ice Carvings");
	}

	public void bulidRoof() {
		System.out.println(getClass().getName() + ".bulidRoof() method called");
		house.setRoof("Ice Dome");
	}

	public House getHouse() {
		System.out.println(getClass().getName() + ".getHouse() method called");
		return this.house;
	}
}