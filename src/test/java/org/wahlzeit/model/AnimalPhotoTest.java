package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.AnimalPhoto.AnimalPhoto;
import org.wahlzeit.model.AnimalPhoto.AnimalPhotoFactory;
import org.wahlzeit.model.AnimalPhoto.AnimalPhotoManager;

import com.googlecode.objectify.ObjectifyService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AnimalPhotoTest {

	
	
	@Test
	public void instanceTest() {	
				
		AnimalPhotoFactory testFactory = new AnimalPhotoFactory();
		
		assertNotNull(testFactory.createPhoto());		
		assertNotNull(testFactory.createPhoto(PhotoId.getNextId()));			
	}
	
	@Test
	public void specificInstanceTest() {	
				
		AnimalPhotoFactory testFactory = new AnimalPhotoFactory();		
		PhotoId testId = PhotoId.getIdFromInt(10);		
				
		assertEquals(testFactory.createPhoto(testId).getId(),testId);			
	}	
	
	/**
	 * The ObjectifyFilter has to be started before this test
	 * 
	 */
	@Test
	public void saveLoadPhotoTest() {
		
		AnimalPhotoManager testManager = new AnimalPhotoManager();
		
		PhotoId testId = PhotoId.getNextId();			
		AnimalPhoto testPhoto = new AnimalPhoto(testId);	
		
		testManager.savePhoto(testPhoto);
		testManager.loadPhotos();
		
		assertEquals(testPhoto,testManager.doGetPhotoFromId(testId));
	}
	
	
}
