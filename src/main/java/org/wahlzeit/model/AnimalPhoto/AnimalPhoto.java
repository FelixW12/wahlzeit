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

	
	
	
	/**
	 *
	 */
	public AnimalPhoto() {
		id = PhotoId.getNextId();
		incWriteCount();
	}

	/**
	 * @methodtype constructor
	 */
	public AnimalPhoto(PhotoId myId) {
		id = myId;

		incWriteCount();
	}
	
	//override methods described in Angaben
}
