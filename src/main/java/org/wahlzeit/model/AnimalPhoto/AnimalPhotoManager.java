/*
 * Classname: AnimalPhotoManager
 *
 * Version information: 1.0
 *
 * Date: 11.11.2017
 *
 * Copyright notice: Ask me
 */

package org.wahlzeit.model.AnimalPhoto;

import java.util.HashMap;
import java.util.Map;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.PhotoManager;
import org.wahlzeit.model.PhotoUtil;

import com.google.appengine.api.images.Image;

@org.wahlzeit.model.DesignPattern(
	    patternName = "Mediator",
		participants = {"concreteMediator"}
	)
public class AnimalPhotoManager extends PhotoManager {
	
	/**
	 *
	 */
	@Override
	public Photo createPhoto(String filename, Image uploadedImage) throws Exception {
		PhotoId id = PhotoId.getNextId();
		AnimalPhoto result = (AnimalPhoto) PhotoUtil.createPhoto(filename, id, uploadedImage);
		addPhoto(result);
		return result;
	}
}
