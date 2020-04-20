<<<<<<< HEAD
package com.jio.ngo.common;

import java.sql.Connection;
import java.util.LinkedHashMap;

public class SingletonClass {
	private static SingletonClass instance;
	LinkedHashMap<String, Connection> connectionMap = null;

	private SingletonClass() {
	}

	public static synchronized SingletonClass getInstance() {
		if (instance == null) {
			instance = new SingletonClass();
		}
		return instance;
	}

	public Connection getConnectionObj(String key) {
		System.out.println("Map >> "+connectionMap);
		if (connectionMap != null)
			return connectionMap.get(key);
		else
			return null;

	}
	
	public LinkedHashMap<String, Connection> getConnectionMap() {
		return connectionMap;
	}
	
	public boolean resetConnectionMap() {
		connectionMap = null;
		return true;
	}

	public Boolean setConnectionObj(String key, Connection conn) {
		System.out.println("Connection >> "+conn);
		if (conn != null) {
			if (connectionMap == null) {
				connectionMap = new LinkedHashMap<>();
			}
			connectionMap.put(key, conn);
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean resetConnectionObj(String key) {
		if (!"".equalsIgnoreCase(key) && connectionMap != null) {							
			connectionMap.remove(key);
			return true;
		} else {
			return false;
		}
	}
}
=======
package com.jio.ngo.common;

import java.sql.Connection;
import java.util.LinkedHashMap;

public class SingletonClass {
	private static SingletonClass instance;
	LinkedHashMap<String, Connection> connectionMap = null;

	private SingletonClass() {
	}

	public static synchronized SingletonClass getInstance() {
		if (instance == null) {
			instance = new SingletonClass();
		}
		return instance;
	}

	public Connection getConnectionObj(String key) {
		System.out.println("Map >> "+connectionMap);
		if (connectionMap != null)
			return connectionMap.get(key);
		else
			return null;

	}
	
	public LinkedHashMap<String, Connection> getConnectionMap() {
		return connectionMap;
	}
	
	public boolean resetConnectionMap() {
		connectionMap = null;
		return true;
	}

	public Boolean setConnectionObj(String key, Connection conn) {
		System.out.println("Connection >> "+conn);
		if (conn != null) {
			if (connectionMap == null) {
				connectionMap = new LinkedHashMap<>();
			}
			connectionMap.put(key, conn);
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean resetConnectionObj(String key) {
		if (!"".equalsIgnoreCase(key) && connectionMap != null) {							
			connectionMap.remove(key);
			return true;
		} else {
			return false;
		}
	}
}
>>>>>>> 015877d33c416a44442258f23eac1907bde167c8
