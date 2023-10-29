package com.java.exception.scaler;

public class ClassNotFoundExceptionDemo {
    private static final String MYSQL_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName(MYSQL_DRIVER_CLASS);
    }
}
