package com.project1.jdbcproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class JdbcMain4 {
	
	public static void main(String[]args) throws FileNotFoundException, IOException, SQLException
	{

		Properties prop=new Properties();
		prop.load(new FileReader("jdbc.properties"));
		
		String dr =prop.getProperty("driver");
		String url=prop.getProperty("connectString");
		String user=prop.getProperty("userName");
		String password=prop.getProperty("password");
		

try {
	Class.forName(dr);
	
	
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
	
	
	
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("D:/emp1.dat"));
			List <Employee> emps = (List<Employee>) is.readObject();
			is.close();
			
			PreparedStatement pst=con.prepareStatement("insert into empsml values(?,?,?)");
			
			for(Employee e: emps)
			{
				pst.setInt(1, e.getEmpId());
				pst.setString(3, e.getName());
				pst.setFloat(2, e.getSalary());
				pst.executeUpdate();
			}
			con.close();
			
				
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}catch(ClassNotFoundException e1) {
				e1.printStackTrace();
			}

	}
	}


