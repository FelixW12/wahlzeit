package org.wahlzeit.model.AnimalPhoto;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.services.LogBuilder;

public class AnimalPhotoFactory extends PhotoFactory {

	


	/**
	 * @methodtype factory
	 */
	@Override
	public AnimalPhoto createPhoto() {
		return new AnimalPhoto();
	}
	

	/**
	 * Creates a new animal - photo with the specified id
	 */
	@Override
	public AnimalPhoto createPhoto(PhotoId id) {
		return new AnimalPhoto(id);
	}
	
	
}
