package com.te.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStatic {
public static void main(String[] args) {
		
		Connection con=null;
		Statement stmt=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Create Connection
		
		try {
			String dburl="jdbc:mysql://localhost:3306/employee_info";
			con=DriverManager.getConnection(dburl,"root","root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Writing the query
		
		
		
		try {
			String query="delete from employeedata where empid=2";
			stmt=con.createStatement();
			int n=stmt.executeUpdate(query);
			System.out.println(n+" Rows Updated");
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(con !=null)
					con.close();
					
					if(stmt!=null) {
						stmt.close();
						}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
	}


}
