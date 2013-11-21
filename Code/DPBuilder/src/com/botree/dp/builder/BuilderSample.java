package com.botree.dp.builder;

public class BuilderSample {
	public static void main(String[] args) {
		//HouseBuilder tipiHouseBuilder = new TipiHouseBuilder();
		IglooHouseBuilder hb = new IglooHouseBuilder();
		CivilEngineer engineer = new CivilEngineer(hb);

		engineer.constructHouse();

		House house = engineer.getHouse();

		System.out.println("Builder constructed: " + house);
	}
}