/*
* Classname: CartesianCoordinate
* Implements: Coordinate
* Version information: 1.0
*
* Date: 18.11.2017
*
* Copyright notice: Ask me
*/
package org.wahlzeit.model.Coordinate.Imp;

import org.wahlzeit.model.Coordinate.Coordinate;

public class CartesianCoordinate implements Coordinate {

	private double x;
	private double y;
	private double z;	
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public double getCartesianDistance(Coordinate c) {
		return Math.sqrt(Math.pow(x - c.getX(), 2) + Math.pow(y - c.getY(), 2) + Math.pow(z - c.getZ(), 2));
	}

	@Override
	public double getSphericDistance(Coordinate c) {		
		//Erdradius 6371km wie im Fsi-Informatikforum empfohlen	
		return 6371 *Math.acos(Math.cos(getLongitude())*Math.cos(c.getLongitude()) + Math.sin(getLongitude())*Math.sin(c.getLongitude())*Math.cos(getLatitude()-c.getLatitude()));	
	}

	@Override
	public double getDistance(Coordinate c) {
		return getCartesianDistance(c);
	}

	@Override
	public boolean isEqual(Coordinate c) {
		if(x == c.getX()) {
			if(y == c.getY()) {
				if(z == c.getZ()) {
					return true;
				}
			}					
		}
		return false;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public double getZ() {
		return z;
	}

	@Override
	public double getLongitude() {
		return Math.atan(y/x);		
	}

	@Override
	public double getRadius() {
		return Math.sqrt(Math.pow(x , 2) + Math.pow(y, 2) + Math.pow(z, 2));
	}

	@Override
	public double getLatitude() {
		return Math.atan(Math.sqrt(	Math.pow(x , 2) + Math.pow(y, 2)) / z);
	}
	

}
