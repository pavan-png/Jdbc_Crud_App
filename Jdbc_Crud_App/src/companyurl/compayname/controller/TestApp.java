package companyurl.compayname.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import companyurl.companyname.dto.Student;
import companyurl.companyname.service.IStudentService;
import companyurl.companyname.servicefactoy.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException  {
		Scanner sc = new Scanner(System.in);
		outerloop:
		while ( true) {
			System.out.println("1. Insert");
			System.out.println("2. update");
			System.out.println("3. delete");
			System.out.println("4. search");
			System.out.println("5.  exit ");
			System.out.println("enter the option");
			int option = sc.nextInt();
			switch(option) {
			case 1: 
				insertOperation();
				break;
			case 2: 
				updateOperation();
				break;
			case 3:
				deleteOperation();
				break;
			case 4:
				selectOperation();
				break;
			case 5: 
				System.out.println("Thank you for using our app visit again");
				break outerloop;

			}
			
			
		}
		
		
		
	}
	
	private static void updateOperation() throws FileNotFoundException, SQLException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the id of the student to be updated ");
		int sid  = sc.nextInt();
		IStudentService studentService = StudentServiceFactory.getStudentService();
		Student student = studentService.searchStudent( sid);
		if (student!=null) {
			Student newStudent = new Student();
			System.out.println("student id is "+student.getSid());
			newStudent.setSid(student.getSid());
			System.out.println("Student old name is "+student.getSname() + "Enter the new name");
			String newName = sc.next();
			if(newName.equals(" ") || newName ==" ") {
				newStudent.setSname(student.getSname());
			}
			else {
				newStudent.setSname(newName);
			}
			System.out.println("Student old age is "+student.getSage() + "Enter the new age");
			String newAge = sc.next();
			if(newAge.equals(" ") || newAge ==" ") {
				newStudent.setSage(student.getSage());
			}
			else {
				newStudent.setSage(Integer.parseInt(newAge));
			}
			System.out.println("Student old address is "+student.getSaddress() + "Enter the new address");
			String newAddress = sc.next();
			if(newAddress.equals(" ") || newAddress ==" ") {
				newStudent.setSaddress(student.getSaddress());
			}
			else {
				newStudent.setSaddress(newAddress);
			}
			
			
			String status = studentService.updateStudent(newStudent);
			if (status.equalsIgnoreCase("success")) {
				System.out.println("record updated successfully");
			}
			else {
				System.out.println("record updation failed");
			}
			
		}
		else {
			System.out.println("student record not available");
		}
	}
		
	private static void insertOperation() throws FileNotFoundException, SQLException, IOException {
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
		
		}
	
		private static void selectOperation() throws FileNotFoundException, SQLException, IOException {
			Scanner sc = new Scanner(System.in);
			System.out.println("enter the id of the student");
			Integer sid = sc.nextInt();
			IStudentService studentService = StudentServiceFactory.getStudentService();
			Student std = studentService.searchStudent(sid);
			if(std!=null) {
				System.out.println(std);
				System.out.println("sid \t sname \t sage \t saddress");
				System.out.println(std.getSid()+"\t"+std.getSname()+"\t"+std.getSage()+"\t"+std.getSaddress());
			}
			else {
				System.out.println("record not found for the given id");
			}
			
			
		}
		
		private static void deleteOperation() throws FileNotFoundException, IOException, SQLException {
			Scanner sc = new Scanner (System.in);
			System.out.println("enter the id of the student");
			int sid = sc.nextInt();
			IStudentService studentService = StudentServiceFactory.getStudentService();
			String msg = studentService.deleteStudent(sid);
			if (msg.contentEquals("success")) {
				System.out.println("record deleted successfully");
			}
			else if(msg.equalsIgnoreCase("not found")) {
				System.out.println("record not found");
			}
			else {
				System.out.println("record deletion failed");
			}
		
			
		}
}
