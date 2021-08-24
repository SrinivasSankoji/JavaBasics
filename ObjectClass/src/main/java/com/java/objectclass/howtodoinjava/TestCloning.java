package com.java.objectclass.howtodoinjava;

public class TestCloning {
	public static void main(String[] args) throws CloneNotSupportedException {
		Department department=new Department();
		department.setName("Software");
		department.setId(36);
		
		Employee original=new Employee();
		original.setEmployeeName("Java Developer");	
		original.setEmployeeId(2018);
		original.setDepartment(department);
		
		if(original instanceof Cloneable) {
		Employee cloned=(Employee)original.clone();
		System.out.println(original==cloned);
		System.out.println(original.getClass()==cloned.getClass());
		System.out.println(original.equals(cloned));
		
		//If we are performing any changes to the cloned Object
		//then those changes will also be reflected to the Original Object
		cloned.getDepartment().setName("FullStack");
		
		System.out.println(original.getDepartment().getName());
		System.out.println(cloned.getDepartment().getName());
		}
	}
}
