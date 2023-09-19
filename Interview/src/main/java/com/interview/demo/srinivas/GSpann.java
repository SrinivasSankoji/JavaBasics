package com.interview.demo.srinivas;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GSpann {

	public static void main(String[] args) {
		Map<String, String> ordersMap = new HashMap<>();
		ordersMap.put("order1", "Item1");
		ordersMap.put("order2", "Item7");
		ordersMap.put("order3", "Item1,Item2,Item7");
		ordersMap.put("order4", "Item7,Item2,Item3");
		ordersMap.put("order5", "Item7,Item2");

		Collection<String> result = ordersMap.values();

		// Convert List to comma separated String we use joining
		String tempList = result.stream().collect(Collectors.joining(","));
		System.out.println(tempList); //Item7,Item2,Item7,Item2,Item3,Item1,Item2,Item7,Item7,Item1

		/* Word Count */
		Map<Object, Integer> wordcount = Arrays.asList(tempList.split(",")).stream()
				.collect(Collectors.toMap(Function.identity(), w -> 1, Integer::sum));
		System.out.println(wordcount);// {Item1=2, Item2=3, Item3=1, Item7=4}
	}

}
