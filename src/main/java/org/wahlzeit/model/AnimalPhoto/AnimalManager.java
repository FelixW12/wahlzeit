package org.wahlzeit.model.AnimalPhoto;

import java.util.HashMap;
import java.util.Map;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

public class AnimalManager {

	protected static Map<String, Animal> AnimalCache = new HashMap<String, Animal>();
	protected static Map<String, AnimalType> AnimalTypeCache = new HashMap<String, AnimalType>();
	
	protected static Animal doGetAnimalFromId(String id) {
		return AnimalCache.get(id);
	}
	protected static AnimalType doGetAnimalTypeFromId(String id) {
		return AnimalTypeCache.get(id);
	}
	
	public static Animal createAnimal(String animalName, String animalTypeName) {
		
		AnimalType resultingAnimalType = doGetAnimalTypeFromId(animalTypeName);
		Animal resultingAnimal = doGetAnimalFromId(animalName);
		
		if(resultingAnimal == null) {
			if(resultingAnimalType == null) {
				resultingAnimalType = new AnimalType(animalTypeName);
			}
			resultingAnimal = new Animal(animalName, resultingAnimalType);			
			AnimalCache.put(animalName, resultingAnimal);
			AnimalTypeCache.put(animalTypeName, resultingAnimalType);
		}
		
		return resultingAnimal;
	}
	
}
