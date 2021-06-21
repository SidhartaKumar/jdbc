package com.te.demo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;



public class SelectDynamic {
public static void main(String[] data) {
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		Employee emp =new Employee();
		
		try {
			FileInputStream fis=new FileInputStream("properties.properties");
			
			Properties p= new Properties();
			p.load(fis);
			
			
			
			//String dburl="jdbc:mysql://localhost:3306/employee_info";
			
			con=DriverManager.getConnection(p.getProperty("dburl"),p.getProperty("user"),p.getProperty("pw"));
			
			String query="select * from employeedata where empid=?;";
			
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1,Integer.parseInt(data[0]));
			rs=pstmt.executeQuery();
			
			
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


