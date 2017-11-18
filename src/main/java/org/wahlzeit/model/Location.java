
package org.wahlzeit.model;

import org.wahlzeit.model.Coordinate.Coordinate;
import org.wahlzeit.model.Coordinate.Imp.CartesianCoordinate;

/*
* Classname: Location
* 
* Version information: 1.0
*
* Date: 18.11.2017
*
* Copyright notice: Ask me
*/





public class Location {

	private Coordinate coordinate;
	
	public void setCoordinate(Coordinate c) {
		coordinate = c;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	
	/*
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
	} */
}
