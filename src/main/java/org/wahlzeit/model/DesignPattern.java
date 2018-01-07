package org.wahlzeit.model;

public @interface DesignPattern {

	String patternName() default "component";
	String [] participants() default "";
}
