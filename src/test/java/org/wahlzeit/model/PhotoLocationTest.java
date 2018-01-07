
/*
* Classname: PhotoLocationTest
*
* Version information: 1.0
*
* Date: 30.10.2017
*
* Copyright notice: Ask me
*/


package org.wahlzeit.model;

import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.model.Coordinate.Coordinate;
import org.wahlzeit.model.Coordinate.Imp.CartesianCoordinate;
import org.wahlzeit.model.Coordinate.Imp.SpehricCoordinate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class PhotoLocationTest {

	private Location photoLocation;
	private Location photoLocation2;
	@Before
	public void initPhotoLocation() {

		photoLocation = new Location();	
		photoLocation2 = new Location();	
	}
	
	@Test 
	public void photoLocationIsEqual() {
		
		photoLocation.setCoordinate(new CartesianCoordinate(1,1,1));		
		
		photoLocation2.setCoordinate(new CartesianCoordinate(1,1,1));		
		
		assertEquals(photoLocation.getCoordinate().isEqual(photoLocation2.getCoordinate()), true);		
	}
	
	
	@Test 
	public void photoLocationNotEqual() {
		
		photoLocation.setCoordinate(new CartesianCoordinate(2,2,2));		
		
		photoLocation2.setCoordinate(new CartesianCoordinate(1,1,1));		
		
		assertEquals(photoLocation.getCoordinate().isEqual(photoLocation2.getCoordinate()), false);				
	}

	@Test 
	public void photoLocationSameValueDifferentVariable() {
		
		photoLocation.setCoordinate(new CartesianCoordinate(3,10,-6));		
		
		photoLocation2.setCoordinate(new CartesianCoordinate(-6,3,10));		
		
		assertEquals(photoLocation.getCoordinate().isEqual(photoLocation2.getCoordinate()), false);	
	}
	
	@Test 
	public void photoLocationDifferentVariables() {		
		photoLocation.setCoordinate(new CartesianCoordinate(0,0,0));		
		
		photoLocation2.setCoordinate(new CartesianCoordinate(-2342341,1233,31));		
		
		assertEquals(photoLocation.getCoordinate().isEqual(photoLocation2.getCoordinate()), false);		
	}
	

	@Test 
	public void photoLocationDistanceEasyTest() {
		
		photoLocation.setCoordinate(new CartesianCoordinate(0,0,0));		
		
		photoLocation2.setCoordinate(new CartesianCoordinate(2,2,2));
		
		assertEquals(photoLocation.getCoordinate().getDistance(photoLocation2.getCoordinate()), 3.4641,0.1);		
	}

	@Test 
	public void photoLocationDistanceRandomNumberTest() {	
		photoLocation.setCoordinate(new CartesianCoordinate(3,4,7));		
		
		photoLocation2.setCoordinate(new CartesianCoordinate(6,0,12));
		assertEquals(photoLocation.getCoordinate().getDistance(photoLocation2.getCoordinate()), 7.0711,0.1);

	}

	@Test 
	public void photoLocationDistanceExtremNumberTest() {
		photoLocation.setCoordinate(new CartesianCoordinate(-50,40,120));		
		
		photoLocation2.setCoordinate(new CartesianCoordinate(2000,-1000000,500));
		assertEquals(photoLocation.getCoordinate().getDistance(photoLocation2.getCoordinate()), 1000042.1733607,0.1);
	}
	
	@Test 
	public void photoLocationDistanceEasyTestSpherical() {
		
		photoLocation.setCoordinate(new SpehricCoordinate(0,0,0));		
		
		photoLocation2.setCoordinate(new CartesianCoordinate(2,2,2));
		
		assertEquals(photoLocation.getCoordinate().getDistance(photoLocation2.getCoordinate()), 3.4641,0.1);		
	}

	@Test 
	public void photoLocationDistanceRandomNumberTestSpherical() {	
		photoLocation.setCoordinate(new SpehricCoordinate(8.6023252670426,0.92729521800161,0.62024948598282));		
		
		photoLocation2.setCoordinate(new CartesianCoordinate(6,0,12));
		assertEquals(photoLocation.getCoordinate().getDistance(photoLocation2.getCoordinate()), 7.0711,0.1);
	}
	
	@Test 
	public void photoLocationDistanceRandomNumberTestSphericalAsLocation() {	
		photoLocation.setCoordinate(new SpehricCoordinate(8.6023252670426,0.92729521800161,0.62024948598282));		
		
		photoLocation2.setCoordinate(new CartesianCoordinate(6,0,12));
		assertEquals(photoLocation.getCoordinate().getCartesianDistance(photoLocation2.getCoordinate()), 7.0711,0.1);
	}

	@Test 
	public void photoLocationDistanceRandomNumberTestSphericalAsSpheric() {	
		photoLocation.setCoordinate(new SpehricCoordinate(8.6023252670426,0.92729521800161,0.62024948598282));		
		
		photoLocation2.setCoordinate(new CartesianCoordinate(6,0,12));
		assertEquals(photoLocation.getCoordinate().getSphericDistance(photoLocation2.getCoordinate()), 7.0711,0.1);
	}
	@Test 
	public void photoLocationDistanceRandomNumberTestSphericalIsEqual() {	
		Coordinate testCor = SpehricCoordinate.getSpehricInstance(new SpehricCoordinate(8.6023252670426,0.92729521800161,0.62024948598282));		
		
		photoLocation.setCoordinate(testCor);		
		
		photoLocation2.setCoordinate(testCor.asCartesianCoordinate());
		assertTrue(photoLocation.getCoordinate().isEqual(photoLocation2.getCoordinate()));
	}


}
