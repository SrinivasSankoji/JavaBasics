package com.java.enumeration.howtodoinjava;

import java.util.EnumSet;
import java.util.Set;

public class DirectionDemo {

	public static void main(String[] args) {
		Direction south=Direction.SOUTH;
		System.out.println(south);
		
		//To get the enum order
		System.out.println(Direction.EAST.ordinal());
		
		//Convert String into enum ie String should be a valid enum
		Direction corner=Direction.valueOf("EAST");
		System.out.println(corner);
		
		//To get all the enums
		Direction[] direction=Direction.values();
		for (Direction dir : direction) {
			System.out.println(dir);
		}
		
		//To get the value of the Constructor in enum
		DirectionConstructor angle=DirectionConstructor.NORTH;
		System.out.println(angle.getAngle());
		
		//Calling the Concrete Method in enum
		System.out.println(angle.EAST.printMessage());
		
		Set set=EnumSet.of(Direction.SOUTH,Direction.EAST,Direction.NORTH,Direction.WEST);
		set.forEach(System.out::println);
		
		
	}

}
