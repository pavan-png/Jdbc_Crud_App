package companyurl.compayname.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import companyurl.companyname.service.IStudentService;
import companyurl.companyname.servicefactoy.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the id of the student");
		Integer id = sc.nextInt();
		System.out.println("enter the name of the student");
		String name = sc.next();
		System.out.println("enter the age of the student");
		Integer age = sc.nextInt();
		System.out.println("enter the address of the student");
		String address = sc.next();
		String msg = studentService.addStudent(id, name, age, address);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record inserted successfully");
		}
		else {
			System.out.println("record insertion failed");
		}
		sc.close();
	}

}
