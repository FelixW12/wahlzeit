<<<<<<< HEAD
package org.wahlzeit.model;

=======
/*
* Classname: Location
* Inner classname: Coordinate
*
* Version information: 1.0
*
* Date: 30.10.2017
*
* Copyright notice: Ask me
*/

package org.wahlzeit.model;

import org.wahlzeit.model.Location.Coordinate;

>>>>>>> 9391bc36463339473d7faa3870cd00ff1a9aace8
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
