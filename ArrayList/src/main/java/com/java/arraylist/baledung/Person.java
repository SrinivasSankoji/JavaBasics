package com.java.arraylist.baledung;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@Builder
@ToString
public class Person {
    private final String givenName;
    private final String additionalName;
    private final String familyName;
    private final List<String> tags;

    public List<String> getTags() {
        return Collections.unmodifiableList(tags);
    }

    public static void main(String[] args) {
       List<String> tags= new ArrayList();
        tags.add("fictional");
        tags.add("incidental");
        Person person = Person.builder()
                .givenName("Aaron")
                .tags(tags)  //Person(givenName=Aaron, additionalName=null, familyName=null, tags=[non-fictional, important])
               // .tags(Arrays.asList("fictional","incidental")) // throws UnsupportedOperationException
                .build();
        person.getTags().clear();
        person.getTags().add("non-fictional");
        person.getTags().add("important");

        System.out.println(person);
    }
}
