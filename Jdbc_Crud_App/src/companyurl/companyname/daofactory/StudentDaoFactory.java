package companyurl.companyname.daofactory;

import companyurl.companyname.persistence.IStudentDao;
import companyurl.companyname.persistence.StudentDaoImpl;

public class StudentDaoFactory {
	private StudentDaoFactory() {
		
	}
	private static IStudentDao studentDao = null;
	
	public static  IStudentDao getStudentDao() {
		if(studentDao ==null) {
			studentDao = new StudentDaoImpl();
		}
		return studentDao;
	}

}