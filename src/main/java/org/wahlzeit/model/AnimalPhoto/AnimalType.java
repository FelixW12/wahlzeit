package org.wahlzeit.model.AnimalPhoto;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.wahlzeit.services.DataObject;

public class AnimalType extends DataObject{

	final public String typeName;
	
	protected AnimalType superType = null;
	protected Set<AnimalType> subTypes = new HashSet <AnimalType>();
	
	public AnimalType getSuperType() {
		 return superType;
		 }
	public void setSuperType(AnimalType superType) {
		this.superType = superType;
		 }
	public Iterator<AnimalType> getSubTypeIterator() {
		 return subTypes.iterator();
		 }
	 public void addSubType(AnimalType ft) {
		 assert (ft != null) : "tried to set null sub-type";
		 ft.setSuperType(this);
		 subTypes.add(ft);
		 }

	 public boolean hasInstance(Animal animal) {
		 assert (animal != null) : "asked about null object";
		 if (animal.getType() == this) {
		 return true;
		 }
		 for (AnimalType type : subTypes) {
		 if (type.hasInstance(animal)) {
		 return true;
		 }
		 }
		 return false;
		 } 
	 public boolean isSubType() {
		 if(superType == null) return false;
		 
		 return true;
	 }
	
	public AnimalType(String typeName) {
		this.typeName = typeName;
	}
}
