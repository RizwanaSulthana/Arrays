package com.project1.jdbcproject;

import java.io.Serializable;

public class Employee implements Serializable{
		private int empId;
		private String name;
		private float salary;
		public Employee(int empId, String name, float salary) {
			super();
			this.empId = empId;
			this.name = name;
			this.salary = salary;
		}
		public int getEmpId() {
			return empId;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getSalary() {
			return salary;
		}
		public void setSalary(float salary) {
			this.salary = salary;
		}
		@Override
		public String toString() {
			return " EmpId:" + empId + ", Name:" + name + ", Salary:" + salary ;
		}
		
		public int compareTo(Employee e) {
			// TODO Auto-generated method stub
			return this.empId-e.empId;
		}
		
		
		

	}



