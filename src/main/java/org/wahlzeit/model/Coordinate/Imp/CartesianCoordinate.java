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

public class CartesianCoordinate extends AbstractCoordinate {

	private double x;
	private double y;
	private double z;	
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	/*
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
	} */

	public double getX() {
<<<<<<< HEAD
		assertPostCondition(x);
=======
>>>>>>> 530ddc9857460ac2faeaa04d832f0adf84b3eaac
		return x;
	}

	public double getY() {
<<<<<<< HEAD
		assertPostCondition(y);
=======
>>>>>>> 530ddc9857460ac2faeaa04d832f0adf84b3eaac
		return y;
	}

	public double getZ() {
<<<<<<< HEAD
		assertPostCondition(z);
=======
>>>>>>> 530ddc9857460ac2faeaa04d832f0adf84b3eaac
		return z;
	}

	public double getLongitude() {		
		double longitude = Math.atan(y/x);		
		assertPostCondition(longitude);
		return longitude;
	}

	public double getRadius() { 		
		double radius = Math.sqrt(Math.pow(x , 2) + Math.pow(y, 2) + Math.pow(z, 2));	
		assertPostCondition(radius);
		return radius;	
	}

	public double getLatitude() {
		
		double latitude = Math.atan(Math.sqrt(	Math.pow(x , 2) + Math.pow(y, 2)) / z);
		assertPostCondition(latitude);
		return latitude;	 
	}

	@Override
	public Coordinate asCartesianCoordinate() {
		return this;
	}

	@Override
	public Coordinate asSphericCoordinate() {
		return new SpehricCoordinate(getLongitude(),getLatitude(),getRadius());
	}


	

}
