package org.wahlzeit.model.Coordinate;

import org.wahlzeit.model.coordinateNullException;
import org.wahlzeit.model.negativeValueException;

public abstract class AbstractCoordinate implements Coordinate {

	@Override
	public double getCartesianDistance(Coordinate c) {
		try {
			testPrecondition(c);
		}catch(coordinateNullException e){
			  System.err.println(e.getMessage());
			  return -1;
		}		
		double distance = Math.sqrt(Math.pow(getX() - c.getX(), 2) + Math.pow(getY() - c.getY(), 2) + Math.pow(getZ() - c.getZ(), 2));
		assertClassInvariants();
		try {
			testPostCondition(distance);
		}catch(negativeValueException e){
			  System.err.println(e.getMessage());
			  return -1;
		}	
		return distance;
		 
	}

	@Override
	public double getSphericDistance(Coordinate c) {
		try {
			testPrecondition(c);
		}catch(coordinateNullException e){
			  System.out.println(e.getMessage());
			  return -1;
		}		
		double distance =6371 *Math.acos(Math.cos(getLongitude())*Math.cos(c.getLongitude()) + Math.sin(getLongitude())*Math.sin(c.getLongitude())*Math.cos(getLatitude()-c.getLatitude()));
		assertClassInvariants();
		try {
			testPostCondition(distance);
		}catch(negativeValueException e){
			  System.out.println(e.getMessage());
			  return -1;
		}	
		return distance;
	
	}

	@Override
	public double getDistance(Coordinate c) {	
		try {
			testPrecondition(c);
		}catch(coordinateNullException e){
			  System.err.println(e.getMessage());
			  return -1;
		}
		double distance =  getSphericDistance(c);	
		assertClassInvariants();
		
		try {
			testPostCondition(distance);
		}catch(negativeValueException e){
			  System.err.println(e.getMessage());
			  return -1;
		}		

		return distance;
	}

	@Override
	public boolean isEqual(Coordinate c) {
		try {
			testPrecondition(c);
		}catch(coordinateNullException e){
			  System.err.println(e.getMessage());
			  return false;
		}	
		assertClassInvariants();		
		return this == c;	
	
	}
	
	public void testPrecondition(Object ob ) throws coordinateNullException{				
		if(ob == null)
		throw new coordinateNullException();
	}
	
	public void testPostCondition(double ob ) throws negativeValueException {
		if(ob < 0)
		throw new negativeValueException();
	}
	
	public void assertClassInvariants() {
		/*
		 * No further test until now
		 * 
		 */
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
