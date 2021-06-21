package com.te.demo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

public class DynamicInsert {
	public static void main(String[] agrs) {
		
		
			Connection cn = null;
			PreparedStatement pst = null;
			Scanner s = new Scanner(System.in);
			try {
				FileInputStream file = new FileInputStream("properties.properties");
				Properties p = new Properties();
				p.load(file);
				cn = DriverManager.getConnection(p.getProperty("dburl"), p.getProperty("user"), p.getProperty("pw"));
				String query = "insert into employeedata2 values(?,?,?,?)";
				System.out.println("enter the employee id");
				int id = s.nextInt();
				System.out.println("enter the employee name");
				String name = s.next();
				System.out.println("enter the employee Salary");
				int salary = s.nextInt();
				System.out.println("enter the date of joining");
				String doj = s.next();
				pst = cn.prepareStatement(query);
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setInt(3, salary);
				pst.setString(4, doj);
				pst.executeUpdate();
				System.out.println("data Sucessfully added");

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				try {
					if (cn != null) {
						cn.close();
					}
					if (pst != null) {
						pst.close();
					}
					if (s != null) {
						s.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}

		}
		
		
		
	}
		
		
		


