package org.wahlzeit.model.AnimalPhoto;

public class Animal {

	final protected String name;
	final protected AnimalType type;
	
	public Animal(String name,AnimalType type) {
		this.name = name;
		this.type = type;
	}
	
	public AnimalType getType() {
		return type;
	}
}
