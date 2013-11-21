package com.botree.dp.builder;

public class House implements HousePlan {

	private String basement;
	private String structure;
	private String roof;
	private String interior;

	public void setBasement(String basement) {
		System.out.println(getClass().getName()
				+ ".setBasement() method called");
		this.basement = basement;
	}

	public void setStructure(String structure) {
		System.out.println(getClass().getName()
				+ ".setStructure() method called");
		this.structure = structure;
	}

	public void setRoof(String roof) {
		System.out.println(getClass().getName()
				+ ".setRoof() method called");
		this.roof = roof;
	}

	public void setInterior(String interior) {
		System.out.println(getClass().getName()
				+ ".setInterior() method called");
		this.interior = interior;

	}

}