package com.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import com.operation.EmployeeOperations;

public class TestEmp {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		EmployeeOperations op=new EmployeeOperations();
		System.out.println("Enter 1 for Add Employee");
		System.out.println("Enter 2 for View All Employee Data");
		System.out.println("Enter 3 for Update Employee salary");
		System.out.println("Enter 4 for Delete Employee");
		Scanner sc=new Scanner(System.in);
		int operation=sc.nextInt();
		switch(operation) {
		case 1:
			op.addEmployee();
			break;
		case 2:
			op.viewEmployee();
			break;
		case 3:
			op.updateEmployeeSalary();
			break;
		case 4:
			op.deleteEmployee();
			break;
		default :
			System.out.println("Please Enter valid value");
		}
	}

}
