package com.java.enumeration.howtodoinjava;

public enum DirectionConstructor {
	SOUTH(45), NORTH(0), EAST(90), WEST(70);
	
	private DirectionConstructor(final int angle) {
		this.angle = angle;
	}
	
	private int angle;

	public int getAngle() {
		return angle;
	}
	
	public String printMessage() {
		return "You are moving in " + this + " Direction";
	}
}
