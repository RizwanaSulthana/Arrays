package com.project1.jdbcproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcMain3 {

	public static void main(String[] args) throws FileNotFoundException, IOException
	{

		Properties prop=new Properties();
		prop.load(new FileReader("jdbc.properties"));
		
		String dr =prop.getProperty("driver");
		String url=prop.getProperty("connectString");
		String user=prop.getProperty("userName");
		String password=prop.getProperty("password");
		
		
		Connection con=null;
		PreparedStatement pst=null;
		try {
		Class.forName(dr);
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
		pst=con.prepareStatement("insert into emp values (?,?,?)");
		}
catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println(0);
			
		}
		
		BufferedReader br=new BufferedReader(new FileReader("emp.txt"));
		while(true)
		{
			String line=br.readLine();
			if(line==null)
				break;
			String fields[]=line.split(":");
			
			int eid=Integer.parseInt(fields[0]);
			String ename=fields[1];
			float sal=Float.parseFloat(fields[2]);
		/*	Date dob=Date.valueOf(fields[3]);
			int deptid=Integer.parseInt(fields[4]);
			String gender=prop.getProperty(fields[5]);
			*/
			try {
				pst.setInt(1,eid);
				pst.setString(2, ename);
				pst.setFloat(3, sal);
				/*pst.setDate(5, dob);
				pst.setInt(6, deptid);
				pst.setString(4, gender);
				*/
				pst.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("invalid date: " +line + "-->" +e.getMessage());
			}
			
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			

	}

}
