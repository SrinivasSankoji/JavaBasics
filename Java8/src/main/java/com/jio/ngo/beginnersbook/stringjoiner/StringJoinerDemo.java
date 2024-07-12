package com.jio.ngo.beginnersbook.stringjoiner;

import java.util.StringJoiner;

public class StringJoinerDemo {
    public static void main(String[] args) {
        /* Joining with Comma Separated Values */
        StringJoiner joiner = new StringJoiner(" ");
        joiner.add("Srinivas");
        joiner.add("Chary");
        joiner.add("Sankoji");
        System.out.println(joiner);
    }
}
