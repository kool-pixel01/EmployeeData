package com.operation;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.model.Employee;

public class EmployeeOperations {

	Scanner sc=null;
	
public void addEmployee() throws Exception {
	sc=new Scanner(System.in);
	System.out.println("enter Employee ID");
	int id=sc.nextInt();
	System.out.println("Enter Employee Name");
	String name=sc.next();
	System.out.println("Enter Employee salary");
	float sal=sc.nextFloat();
	Employee emp=new Employee(id,name,sal);
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/itcompany", "root", "root");
	String sql="insert into employee values(?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setInt(1,emp.getId());
	ps.setString(2, emp.getName());
	ps.setFloat(3, emp.getSalary());
	ps.execute();
	ps.close();
	System.out.println("Employee added succesfully");
}

public void viewEmployee() throws Exception {
	System.out.println("View All Employee");
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/itcompany", "root","root");
	String sql="select * from employee";
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getFloat(3));
	}
	
	ps.execute();
	ps.close();
	
}
public void updateEmployeeSalary() throws Exception {
sc=new Scanner(System.in);
System.out.println("Enter Employee ID to update salary");
int id=sc.nextInt();
System.out.println("Enter updated Employee salary");
float sal=sc.nextFloat();
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/itcompany", "root", "root");
String sql="update employee set salart="+sal+" where id="+id+"";
PreparedStatement ps=con.prepareStatement(sql);
int k=ps.executeUpdate();
System.out.println("Record Updated "+k+"  Employee ID "+id+" Salary"+sal);
ps.close();
	
}
public void deleteEmployee() throws Exception {
sc=new Scanner(System.in);
System.out.println("Enter EmployeeID to delete respective employee data");
int id=sc.nextInt();
Class.forName("com.mysql.cj.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/itcompany", "root", "root");
String sql="delete employee where ID="+id+"";
PreparedStatement ps=con.prepareStatement(sql);
int k=ps.executeUpdate();
System.out.println("Row affected "+k);
	
}

}
