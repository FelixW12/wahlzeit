/*
* Classname: Location
* 
* Version information: 1.0
*
* Date: 18.11.2017
*
* Copyright notice: Ask me
*/
package org.wahlzeit.model.Coordinate;

public interface Coordinate {

	double getCartesianDistance(Coordinate c);
	
	double getSphericDistance(Coordinate c);
	
	double getDistance(Coordinate c);
	
	boolean isEqual(Coordinate c);
	
	double getX();
	
	double getY();
	
	double getZ();
	
	double getLongitude();
	
	double getRadius();
	
	double getLatitude();
	
}
