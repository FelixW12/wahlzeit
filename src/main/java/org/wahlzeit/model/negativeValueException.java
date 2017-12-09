package org.wahlzeit.model;

public class negativeValueException extends Exception
{
	public negativeValueException()
    {
        super("wert ist kleiner 0");
    }
}