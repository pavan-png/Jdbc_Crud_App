package companyurl.compayname.controller;

import companyurl.companyname.service.IStudentService;
import companyurl.companyname.servicefactoy.StudentServiceFactory;

public class TestApp {

	public static void main(String[] args) {
		IStudentService studentService = StudentServiceFactory.getStudentService();
		String msg = studentService.addStudent(10,"pavan", 25, "G-222");
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record inserted successfully");
		}
		else {
			System.out.println("record insertion failed");
			
		}

	}

}
