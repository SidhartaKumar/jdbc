package com.te.demo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class SelectStatic {
	public static void main(String[] args) {
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		Employee emp =new Employee();
		
		try {
			FileInputStream fis=new FileInputStream("properties.properties");
			
			Properties p= new Properties();
			p.load(fis);
			
			
			
			//String dburl="jdbc:mysql://localhost:3306/employee_info";
			
			con=DriverManager.getConnection(p.getProperty("dburl"),p.getProperty("user"),p.getProperty("pw"));
			
			String query="select * from employeedata where empid=1;";
			
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
			while(rs.next()) {
				emp.setEmpid(rs.getInt("empid"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDoj(rs.getDate("doj"));
				
			}
			
			
			
			
			
			
			
		
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
		System.out.println(emp.empid + " "+ emp.name+" "+ emp.salary+" "+ emp.doj);

	}
}
