package com.project1.jdbcproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcMain2 {

	public static void main(String[] args) throws FileNotFoundException, IOException{

	
		
		Properties prop=new Properties();
		prop.load(new FileReader("jdbc.properties"));
		
		String dr =prop.getProperty("driver");
		String url=prop.getProperty("connectString");
		String user=prop.getProperty("userName");
		String password=prop.getProperty("password");
		
		
		try {
			Class.forName(dr);
			
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
			System.out.println("connection created");
			
			int eid=Integer.parseInt(prop.getProperty("empid"));
			String ename=prop.getProperty("ename");
			float sal=Float.parseFloat(prop.getProperty("salary"));
			int deptid=Integer.parseInt(prop.getProperty("deptid"));
			Date dob=Date.valueOf(prop.getProperty("dob"));
			String gender=prop.getProperty("gender");
			
			PreparedStatement pst=con.prepareStatement("insert into emp values(?,?,?,?,?,?)");
			
			pst.setInt(1, eid);
			pst.setString(2, ename);
			pst.setFloat(3, sal);
			pst.setDate(5, dob);
			pst.setInt(6, deptid);
			pst.setString(4, gender);
			
			pst.executeUpdate();
			System.out.println("row inserted");
			con.close();
			
	} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}

