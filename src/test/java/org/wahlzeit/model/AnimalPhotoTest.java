package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.AnimalPhoto.Animal;
import org.wahlzeit.model.AnimalPhoto.AnimalManager;
import org.wahlzeit.model.AnimalPhoto.AnimalPhoto;
import org.wahlzeit.model.AnimalPhoto.AnimalPhotoFactory;
import org.wahlzeit.model.AnimalPhoto.AnimalPhotoManager;
import org.wahlzeit.model.AnimalPhoto.AnimalType;

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
	
	@Test
	public void AnimalManagerTest() {	
				
		AnimalManager testManger = new AnimalManager();		
		PhotoId testId = PhotoId.getIdFromInt(10);		
		
		Animal testAnimal = new Animal("Tiger", new AnimalType("Saeugetier"));
				
		assertEquals(testManger.createAnimal("Tiger", "Saeugetier").name,testAnimal.name);			
		assertEquals(testManger.createAnimal("Tiger", "Saeugetier").type.typeName,testAnimal.type.typeName);	
	}
	
}
