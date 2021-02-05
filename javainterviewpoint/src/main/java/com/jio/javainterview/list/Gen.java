package com.jio.javainterview.list;

public class Gen<T> {
	T obj;
	Gen(T obj)
	{
		this.obj=obj;
	}
	public T getObj()
	{
		return obj;
	}
	public void show()
	{
		System.out.println("Type of Object is"+obj.getClass().getName());
	}
}
