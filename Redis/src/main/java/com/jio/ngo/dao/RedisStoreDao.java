<<<<<<< HEAD
package com.jio.ngo.dao;

import java.util.Map;

import com.jio.ngo.model.Customer;
import com.jio.ngo.model.Employee;

public interface RedisStoreDao 
{
	Object save(Employee employee);
	Object persist(Employee employee);
	Map<String, String> find(String sessionid,Map<String, String> employee);
	/*
	Map<Long, Employee> findAll();
	void update(Employee customer);
	void delete(String id);
	*/
	
	void save(Customer customer);

}
=======
package com.jio.ngo.dao;

import java.util.Map;

import com.jio.ngo.model.Customer;
import com.jio.ngo.model.Employee;

public interface RedisStoreDao 
{
	Object save(Employee employee);
	Object persist(Employee employee);
	Map<String, String> find(String sessionid,Map<String, String> employee);
	/*
	Map<Long, Employee> findAll();
	void update(Employee customer);
	void delete(String id);
	*/
	
	void save(Customer customer);

}
>>>>>>> 015877d33c416a44442258f23eac1907bde167c8
