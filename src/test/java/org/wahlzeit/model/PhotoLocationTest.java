<<<<<<< HEAD
=======
/*
* Classname: PhotoLocationTest
*
* Version information: 1.0
*
* Date: 30.10.2017
*
* Copyright notice: Ask me
*/

>>>>>>> 9391bc36463339473d7faa3870cd00ff1a9aace8
package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class PhotoLocationTest {

	private Location photoLocation;
	private Location photoLocation2;
	@Before
<<<<<<< HEAD
	public void initPhotoFilter() {
=======
	public void initPhotoLocation() {
>>>>>>> 9391bc36463339473d7faa3870cd00ff1a9aace8
		photoLocation = new Location();	
		photoLocation2 = new Location();	
	}
	
	@Test 
	public void photoLocationIsEqual() {
		
		photoLocation.coordinate.x = 1;
		photoLocation.coordinate.y = 1;
		photoLocation.coordinate.z = 1;
		
		photoLocation2.coordinate.x = 1;
		photoLocation2.coordinate.y = 1;
		photoLocation2.coordinate.z = 1;
		
		assertEquals(photoLocation.coordinate.isEqual(photoLocation2.coordinate), true);		
	}
	
	@Test 
	public void photoLocationNotEqual() {
		
		photoLocation.coordinate.x = 2;
		photoLocation.coordinate.y = 2;
		photoLocation.coordinate.z = 2;
		
		photoLocation2.coordinate.x = 1;
		photoLocation2.coordinate.y = 1;
		photoLocation2.coordinate.z = 1;
		
		assertEquals(photoLocation.coordinate.isEqual(photoLocation2.coordinate), false);		
	}
	
	@Test 
	public void photoLocationSameValueDifferentVariable() {
		
		photoLocation.coordinate.x = 3;
		photoLocation.coordinate.y = 10;
		photoLocation.coordinate.z = -6;
		
		photoLocation2.coordinate.x = -6;
		photoLocation2.coordinate.y = 3;
		photoLocation2.coordinate.z = 10;
		
		assertEquals(photoLocation.coordinate.isEqual(photoLocation2.coordinate), false);		
	}
	
	@Test 
	public void photoLocationDifferenRandomVariables() {
		
		photoLocation.coordinate.x = 0;
		photoLocation.coordinate.y = 0;
		photoLocation.coordinate.z = 0;
		
		photoLocation2.coordinate.x = -2342341;
		photoLocation2.coordinate.y = 1233;
		photoLocation2.coordinate.z = 31;
		
		assertEquals(photoLocation.coordinate.isEqual(photoLocation2.coordinate), false);		
	}
	
	
	@Test 
	public void photoLocationDistanceEasyTest() {
		
		photoLocation.coordinate.x = 0;
		photoLocation.coordinate.y = 0;
		photoLocation.coordinate.z = 0;
		
		photoLocation2.coordinate.x = 2;
		photoLocation2.coordinate.y = 2;
		photoLocation2.coordinate.z = 2;
		
		assertEquals(photoLocation.coordinate.getDistance(photoLocation2.coordinate), 3.4641,0.1);		
	}
	
	@Test 
	public void photoLocationDistanceRandomNumberTest() {
		
		photoLocation.coordinate.x = 3;
		photoLocation.coordinate.y = 4;
		photoLocation.coordinate.z = 7;
		
		photoLocation2.coordinate.x = 6;
		photoLocation2.coordinate.y = 0;
		photoLocation2.coordinate.z = 12;
		
		assertEquals(photoLocation.coordinate.getDistance(photoLocation2.coordinate), 7.0711,0.1);	
	}

	@Test 
	public void photoLocationDistanceExtremNumberTest() {
		
		photoLocation.coordinate.x = -50; 
		photoLocation.coordinate.y = 40;
		photoLocation.coordinate.z = 120;

		photoLocation2.coordinate.x = 2000;
		photoLocation2.coordinate.y = -1000000;
		photoLocation2.coordinate.z = 500;
		
		assertEquals(photoLocation.coordinate.getDistance(photoLocation2.coordinate), 1000042.1733607,0.1);	
	}
}
