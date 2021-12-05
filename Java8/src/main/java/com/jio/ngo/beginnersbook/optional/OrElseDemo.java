package com.jio.ngo.beginnersbook.optional;

import java.util.Optional;

public class OrElseDemo {

	public static void main(String[] args) {
		//Creating Optional object from a String
        Optional<String> GOT = Optional.of("Game of Thrones");        
        //Optional.empty() creates an empty Optional object        
        Optional<String> nothing = Optional.empty();
        
        System.out.println(GOT.orElse("Empty Value")); //Game of Thrones
        System.out.println(nothing.orElse("Empty Value")); // Empty Value
        
        System.out.println(GOT.orElseGet(() -> "Empty Value")); //Game of Thrones
        System.out.println(nothing.orElseGet(() -> "Empty Value")); // Empty Value
	}

}
