package com.te.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FirstJdbc {
	
	public static void main(String[] args) {
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
			//Loading and registering driver
		//	Driver driver=new Driver();  //com.mysql.jdbc.Driver driver=new com.mysql.jdbc.Driver();
		//	DriverManager.registerDriver(driver);
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
		
		//Getting connection to the driver
		
		try {
			String dburl="jdbc:mysql://localhost:3306/employee_info?user=root&password=root";
			con=DriverManager.getConnection(dburl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Issueing Sql query
		
		try {
			String query="select * from employee;";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				System.out.println(rs.getInt("empid"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("sal"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			 {
				try {
					if(con !=null)
					con.close();
					
					if(stmt!=null) {
						stmt.close();
					}
					if(rs!=null) {
						rs.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}


