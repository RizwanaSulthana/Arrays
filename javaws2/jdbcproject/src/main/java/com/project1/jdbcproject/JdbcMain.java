package com.project1.jdbcproject;
import java.sql.*;
public class JdbcMain {



public static void main(String[] args) {

try {
Class.forName("oracle.jdbc.driver.OracleDriver");
System.out.println("JDBC driver loaded");
Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "root");
System.out.println("Connection created");
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select empid,ename,salary from employee " );



while(rs.next()) {
int eid = rs.getInt("empid");
String nm=rs.getString("name");
float sal=rs.getFloat(3);
float allow = rs.getFloat("allowance");

System.out.println(eid +" " +nm +" " +sal +" " +allow );



}

con.close();
System.out.println("connection closed");
} catch (ClassNotFoundException | SQLException e) {

e.printStackTrace();
}



}



}
