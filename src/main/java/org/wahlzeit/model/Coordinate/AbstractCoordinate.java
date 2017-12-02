package org.wahlzeit.model.Coordinate;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public abstract class AbstractCoordinate implements Coordinate {

	@Override
	public double getCartesianDistance(Coordinate c) {
		assertClassInvariantObjectIsNull(c);
		
		double distance = Math.sqrt(Math.pow(getX() - c.getX(), 2) + Math.pow(getY() - c.getY(), 2) + Math.pow(getZ() - c.getZ(), 2));
		assertClassInvariantDoubleIsNotNegative(distance);
		return distance;
		 
	}

	@Override
	public double getSphericDistance(Coordinate c) {
		assertClassInvariantObjectIsNull(c);
		
		double distance =6371 *Math.acos(Math.cos(getLongitude())*Math.cos(c.getLongitude()) + Math.sin(getLongitude())*Math.sin(c.getLongitude())*Math.cos(getLatitude()-c.getLatitude()));
		assertClassInvariantDoubleIsNotNegative(distance);
		return distance;
	
	}

	@Override
	public double getDistance(Coordinate c) {
		
		assertClassInvariantObjectIsNull(c);
		double distance =  getSphericDistance(c);	
		assertClassInvariantDoubleIsNotNegative(distance);
		return distance;
	}

	@Override
	public boolean isEqual(Coordinate c) {
		assertClassInvariantObjectIsNull(c);
		
		if(getLatitude() == c.getLatitude()) {
			if(getLongitude() == c.getLongitude()) {
				if(getRadius() == c.getRadius()) {
					return true;
				}
			}					
		}
		return false;
	}
	
	public void assertClassInvariantObjectIsNull(Object ob ) {
		assertNotNull(ob);
	}
	
	public void assertClassInvariantDoubleIsNotNegative(double ob ) {
		assertTrue(ob > 0);
	}
	
	@Override
	public abstract Coordinate asCartesianCoordinate();
	
	@Override
	public abstract Coordinate asSphericCoordinate();	

	@Override
	public abstract double getX();

	@Override
	public abstract double getY();

	@Override
	public abstract double getZ();

	@Override
	public abstract double getLongitude();
	@Override
	public abstract double getRadius();
	@Override
	public abstract double getLatitude();
}
