package org.wahlzeit.model.AnimalPhoto;

import java.util.HashMap;
import java.util.Map;

import org.wahlzeit.model.Photo;
import org.wahlzeit.model.PhotoFactory;
import org.wahlzeit.model.PhotoId;
import org.wahlzeit.model.PhotoManager;

public class AnimalPhotoManager extends PhotoManager {

	protected static final AnimalPhotoManager instance = new AnimalPhotoManager();
	
	public AnimalPhotoManager() {
		photoTagCollector = AnimalPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	@Override
	public Photo getPhotoFromId(PhotoId id) {
		if (id == null) {
			return null;
		}

		Photo result = doGetPhotoFromId(id);

		if (result == null) {
			result = AnimalPhotoFactory.getInstance().loadPhoto(id);
			if (result != null) {
				doAddPhoto(result);
			}
		}

		return result;
	}
	
}
