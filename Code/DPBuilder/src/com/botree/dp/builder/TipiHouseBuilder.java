package com.botree.dp.builder;

public class TipiHouseBuilder implements HouseBuilder {
	private House house;

	public TipiHouseBuilder() {
		this.house = new House();
	}

	public void buildBasement() {
		System.out.println(getClass().getName()
				+ ".buildBasement() method called");
		house.setBasement("Wooden Poles");
	}

	public void buildStructure() {
		System.out.println(getClass().getName()
				+ ".buildStructure() method called");
		house.setStructure("Wood and Ice");
	}

	public void buildInterior() {
		System.out.println(getClass().getName()
				+ ".buildInterior() method called");
		house.setInterior("Fire Wood");
	}

	public void bulidRoof() {
		System.out.println(getClass().getName() + ".bulidRoof() method called");
		house.setRoof("Wood, caribou and seal skins");
	}

	public House getHouse() {
		System.out.println(getClass().getName() + ".getHouse() method called");
		return this.house;
	}

}