/*
* Classname: AnimalPhoto
* Extends: Photo
*
* Version information: 1.0
*
* Date: 11.11.2017
*
* Copyright notice: Ask me
*/

package org.wahlzeit.model.AnimalPhoto;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoId;

public class AnimalPhoto extends Photo {
	
	final Animal animal;
	
	public AnimalPhoto(String animalName, String animalTypeName) {
		id = PhotoId.getNextId();
		animal = AnimalManager.createAnimal(animalName, animalTypeName);
		incWriteCount();
	}

	public AnimalPhoto(PhotoId myId, String animalName, String animalTypeName) {
		id = myId;
		this.animal = AnimalManager.createAnimal(animalName, animalTypeName);
		incWriteCount();
	}
}
