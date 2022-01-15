package com.project1.jdbcproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class EmpRead {

	public static void main(String[] args) {
		
try {
			
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:/emp1.dat"));
			List <Employee> emps = (List<Employee>) is.readObject();
			is.close();
			for(Employee e: emps)
				System.out.println(e);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}catch(ClassNotFoundException e1) {
				e1.printStackTrace();
			}

	}
	}


