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

public class SpehricCoordinate extends AbstractCoordinate {

	private double latitude;
	private double longitude;
	private double radius;
	
	public SpehricCoordinate( double latitude,double longitude,double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
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
			
		double x = getRadius()* Math.sin(getLatitude())*Math.cos(getLongitude());
		assertPostCondition(x);
		return x;	
		
	}

	public double getY() {
		double y = getRadius()* Math.sin(getLatitude())*Math.sin(getLongitude());
		assertPostCondition(y);
		return y;	
	}

	public double getZ() {
		double z = getRadius()* Math.cos(getLatitude());
		assertPostCondition(z);
		return z;	
	}

	public double getLongitude() {
		assertPostCondition(longitude);
		return longitude;
	}

	public double getRadius() {
		assertPostCondition(radius);
		return radius;
	}

	public double getLatitude() {
		assertPostCondition(latitude);
		return latitude;
	}

	@Override
	public Coordinate asCartesianCoordinate() {
		return new CartesianCoordinate(getX(),getY(),getZ());
	}

	@Override
	public Coordinate asSphericCoordinate() {
		return this;
	}

}
