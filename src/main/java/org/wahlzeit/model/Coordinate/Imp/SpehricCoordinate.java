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
import org.wahlzeit.model.coordinateNullException;
import org.wahlzeit.model.negativeValueException;

public final class SpehricCoordinate extends AbstractCoordinate {

	private final double latitude;
	private final double longitude;
	private final double radius;
	private final Coordinate sharedCartesianCoordinate;
	private final double x;
	private final double y;
	private final double z;
	
	public SpehricCoordinate( double latitude,double longitude,double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
		x = getRadius()* Math.sin(getLatitude())*Math.cos(getLongitude());
		y = getRadius()* Math.sin(getLatitude())*Math.sin(getLongitude());
		z = getRadius()* Math.cos(getLatitude());
		
		sharedCartesianCoordinate= new CartesianCoordinate(getX(),getY(),getZ());		
	}
	
	
	/*
	@Override
	public double getCartesianDistance(Coordinate c) {
		return Math.sqrt(Math.pow(getX() - c.getX(), 2) + Math.pow(getY() - c.getY(), 2) + Math.pow(getZ() - c.getZ(), 2));
	}

	@Override
	public double getSphericDistance(Coordinate c) {
		return 6371 *Math.acos(Math.cos(getLongitude())*Math.cos(c.getLongitude()) + Math.sin(getLongitude())*Math.sin(c.getLongitude())*Math.cos(getLatitude()-c.getLatitude()));
	}

	@Override
	public double getDistance(Coordinate c) {
		return getCartesianDistance(c);
	}

	@Override
	public boolean isEqual(Coordinate c) {
		if(getLatitude() == c.getLatitude()) {
			if(getLongitude() == c.getLongitude()) {
				if(getRadius() == c.getRadius()) {
					return true;
				}
			}					
		}
		return false;
	} */

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

}
