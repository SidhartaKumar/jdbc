package com.te.demo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class DyanamicDelete {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PreparedStatement pst = null;
		Connection cn = null;
		try {
			FileInputStream file = new FileInputStream("properties.properties");
			Properties p = new Properties();
			p.load(file);

			cn = DriverManager.getConnection(p.getProperty("dburl"), p.getProperty("user"), p.getProperty("pw"));
			String query = "update employeedata2 set salary=? where name=?";
			System.out.println("enter the employee name");
			String name = s.next();
			System.out.println("enter the employee new salary");
			int salary = s.nextInt();
			pst = cn.prepareStatement(query);
			pst.setInt(1, salary);
			pst.setString(2, name);
			pst.executeUpdate();
			System.out.println("salary updated");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
