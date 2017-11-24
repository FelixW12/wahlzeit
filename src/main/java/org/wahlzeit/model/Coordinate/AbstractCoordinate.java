package org.wahlzeit.model.Coordinate;

public abstract class AbstractCoordinate implements Coordinate {

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
		return getSphericDistance(c);
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
