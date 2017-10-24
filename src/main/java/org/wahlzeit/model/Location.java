package org.wahlzeit.model;

public class Location {

	Coordinate coordinate = new Coordinate();	
	
	class Coordinate{		
		double x;
		double y;
		double z;	
		
		public double getDistance(Coordinate cor) {									
			return Math.sqrt(Math.pow(x - cor.x, 2) + Math.pow(y - cor.y, 2) + Math.pow(z - cor.z, 2));
		}
		
		public boolean isEqual(Coordinate cor) {			
			if(x == cor.x) {
				if(y == cor.y) {
					if(z == cor.z) {
						return true;
					}
				}					
			}
			return false;
		}
	}
}
