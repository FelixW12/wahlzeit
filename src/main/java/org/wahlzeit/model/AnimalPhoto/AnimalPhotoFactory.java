/*
 * Classname: AnimalPhotoFactory
 *
 * Version information: 1.0
 *
 * Date: 11.11.2017
 *
 * Copyright notice: Ask me
 */


package org.wahlzeit.model.AnimalPhoto;

import java.util.logging.Logger;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.LogBuilder;


@org.wahlzeit.model.DesignPattern(
	    patternName = "ConcreteFactory",
		participants = {"Factory"}
	)
public class AnimalPhotoFactory extends PhotoFactory {

	@Override
	public AnimalPhoto createPhoto() {
		return new AnimalPhoto("Tier", "TierType");
	}
	


	@Override
	public AnimalPhoto createPhoto(PhotoId id) {
		return new AnimalPhoto(id,"Tier", "TierType");
	}
	
	 
}
