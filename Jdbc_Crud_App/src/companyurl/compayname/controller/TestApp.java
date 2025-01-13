package companyurl.compayname.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import companyurl.companyname.dto.Student;
import companyurl.companyname.service.IStudentService;
import companyurl.companyname.servicefactoy.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException  {
		// insertOperation();
		//selectOperation();
		deleteOperation();
		
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
		sc.close();
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
			sc.close();
			
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
			sc.close();
			
		}
}
