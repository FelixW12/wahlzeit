/*
* Classname: CartesianCoordinate
* Implements: Coordinate
* Version information: 1.0
*
* Date: 21.11.2017
*
* Copyright notice: Ask me
*/
package org.wahlzeit.model.Coordinate.Imp;

import org.wahlzeit.model.Coordinate.AbstractCoordinate;
import org.wahlzeit.model.Coordinate.Coordinate;
import org.wahlzeit.model.DesignPattern;
import org.wahlzeit.model.coordinateNullException;
import org.wahlzeit.model.negativeValueException;

@DesignPattern(
	    patternName = "Multition",
		participants = {"instances"}
	)
public final class CartesianCoordinate extends AbstractCoordinate {

	private final double x;
	private final double y;
	private final double z;	
	private final double latitude;
	private final double longitude;
	private final double radius;

	
	public CartesianCoordinate(double x, double y, double z) {		
		
		this.x = x;
		this.y = y;
		this.z = z;
		
		this.longitude =  Math.atan2(y,x);
		this.radius = Math.sqrt(Math.pow(x , 2) + Math.pow(y, 2) + Math.pow(z, 2));	
		this.latitude = Math.atan(Math.sqrt(	Math.pow(x , 2) + Math.pow(y, 2)) / z);
	}


	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public double getLongitude() {			
		try {
			testPostCondition(longitude);
		}catch(negativeValueException e){
			  System.err.println(e.getMessage());
		}
		return longitude;
	}

	public double getRadius() { 			
		try {
			testPostCondition(radius);
		}catch(negativeValueException e){
			  System.err.println(e.getMessage());
		}
		return radius;	
	}

	public double getLatitude() {
		try {
			testPostCondition(latitude);
		}catch(negativeValueException e){
			  System.err.println(e.getMessage());
		}
		return latitude;	 
	}
	
	public static CartesianCoordinate getCartesianInstance(CartesianCoordinate coord) {
		CartesianCoordinate myCoor = (CartesianCoordinate) sharedInstances.get(coord.hashCode());
		if(myCoor == null) {
			sharedInstances.put(coord.hashCode(), coord);
			return coord;
		}
		return myCoor;
 	}

	@Override
	public Coordinate asCartesianCoordinate() {
		try {
			return (CartesianCoordinate)this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Coordinate asSphericCoordinate() {
		return new SpehricCoordinate(getLatitude(),getLongitude(),getRadius());
	}


	

}
