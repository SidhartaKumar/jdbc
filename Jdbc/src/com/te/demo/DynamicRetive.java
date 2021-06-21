package com.te.demo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

public class DynamicRetive {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs=null;
		try {
			FileInputStream file = new FileInputStream("properties.properties");
			Properties p = new Properties();
			p.load(file);
			cn = DriverManager.getConnection(p.getProperty("dburl"), p.getProperty("user"), p.getProperty("pw"));
			String query="select * from employeedata2 where empid=?";
			System.out.println("enter the employee id whose details is to be displayed");
			int id=s.nextInt();
			pst=cn.prepareStatement(query);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
