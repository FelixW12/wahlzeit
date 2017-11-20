/*
* Classname: SpehricCoordinate
* Implements: Coordinate
* Version information: 1.0
*
* Date: 18.11.2017
*
* Copyright notice: Ask me
*/
package org.wahlzeit.model.Coordinate.Imp;

import org.wahlzeit.model.Coordinate.Coordinate;

public class SpehricCoordinate implements Coordinate {

	//azimuth - Theta kreis mit strich -longitude
	private double latitude;
	private double longitude;
	private double radius;
	
	public SpehricCoordinate( double latitude,double longitude,double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
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
	}

	@Override
	public double getX() {
		return getRadius()* Math.sin(getLatitude())*Math.cos(getLongitude());
	}

	@Override
	public double getY() {
		return getRadius()* Math.sin(getLatitude())*Math.sin(getLongitude());
	}

	@Override
	public double getZ() {
		return getRadius()* Math.cos(getLatitude());
	}

	@Override
	public double getLongitude() {
		return longitude;
	}

	@Override
	public double getRadius() {
		return radius;
	}

	@Override
	public double getLatitude() {
		return latitude;
	}

}
