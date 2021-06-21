package com.te.demo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class DynamicDelete {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Connection cn = null;
		PreparedStatement pst = null;
		try {
			FileInputStream file = new FileInputStream("properties.properties");
			Properties p = new Properties();
			p.load(file);
			cn = DriverManager.getConnection(p.getProperty("dburl"), p.getProperty("user"), p.getProperty("pw"));
			String query="delete from employeedata2 where empid=?";
			System.out.println("enter the employee id");
			int id=s.nextInt();
			pst = cn.prepareStatement(query);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("employee is deleted ");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
