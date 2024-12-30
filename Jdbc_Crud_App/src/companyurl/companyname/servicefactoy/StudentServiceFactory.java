package companyurl.companyname.servicefactoy;

import companyurl.companyname.service.IStudentService;
import companyurl.companyname.service.StudentServiceImpl;

// abstraction logic of implementation
public class StudentServiceFactory {
	//make constructor private to avoid object creation 
	private StudentServiceFactory() {
		
	}
	private static IStudentService studentService = null;
	public static IStudentService getStudentService() {
		
		// singleton pattern code
		if (studentService==null) {
		studentService = new StudentServiceImpl();
		}
		return studentService; 
		
	}

}
