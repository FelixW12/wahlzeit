/*
* Classname: SpehricCoordinate
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

import java.util.HashSet;

import org.wahlzeit.model.coordinateNullException;
import org.wahlzeit.model.negativeValueException;


@DesignPattern(
	    patternName = "Compositum",
		participants = {"Component", "Composite", "Leaf"}
	)
public final class SpehricCoordinate extends AbstractCoordinate {

	private final double latitude;
	private final double longitude;
	private final double radius;
	private final Coordinate sharedCartesianCoordinate;
	private final double x;
	private final double y;
	private final double z;	
	
	public SpehricCoordinate( double latitude,double longitude,double radius) throws IllegalArgumentException {
		
		if(latitude < 0) {
			  throw new IllegalArgumentException("latitude is not allowed to be below zero)");
		}
		if(longitude < 0) {
			  throw new IllegalArgumentException("longitude is not allowed to be below zero)");
		}
		if(radius < 0) {
			  throw new IllegalArgumentException("radius is not allowed to be below zero)");
		}		
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		x = getRadius()* Math.sin(getLatitude())*Math.cos(getLongitude());
		y = getRadius()* Math.sin(getLatitude())*Math.sin(getLongitude());
		z = getRadius()* Math.cos(getLatitude());
		
		sharedCartesianCoordinate= new CartesianCoordinate(getX(),getY(),getZ());		
	
	
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
			testPostCondition( longitude);
		}catch(negativeValueException e){
			  System.err.println(e.getMessage());
		};
		return longitude;
	}

	public double getRadius() {
		try {
			testPostCondition( radius);
		}catch(negativeValueException e){
			  System.err.println(e.getMessage());
		};
		return radius;
	}

	public double getLatitude() {
		try {
			testPostCondition( latitude);
		}catch(negativeValueException e){
			  System.err.println(e.getMessage());
		};
		return latitude;
	}

	@Override
	public Coordinate asCartesianCoordinate() {
		return sharedCartesianCoordinate;
	}

	@Override
	public Coordinate asSphericCoordinate() {
		try {
			return (SpehricCoordinate)this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static SpehricCoordinate getSpehricInstance(SpehricCoordinate coord) {
		SpehricCoordinate myCoor = (SpehricCoordinate) sharedInstances.get(coord.hashCode());
		if(myCoor == null) {
			sharedInstances.put(coord.hashCode(), coord);
			return coord;
		}
		return myCoor;
 	}


}
