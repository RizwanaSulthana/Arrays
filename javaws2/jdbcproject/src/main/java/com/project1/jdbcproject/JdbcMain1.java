package com.project1.jdbcproject;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JdbcMain1 {

	public static void main(String[] args) throws IOException ,FileNotFoundException{
		
		Properties prop=new Properties();
		prop.load(new FileReader("jdbc.properties"));
		
		String dr =prop.getProperty("driver");
		String url=prop.getProperty("connectString");
		String user=prop.getProperty("userName");
		String password=prop.getProperty("password");
		
		try {
			Class.forName(dr);
			
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","root");
			System.out.println("connection created");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select count(*) from emp");
			
			
			rs.next();
			int count=rs.getInt(1);
			System.out.println("number of emps:" +count);
          
          con.close();
        
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
