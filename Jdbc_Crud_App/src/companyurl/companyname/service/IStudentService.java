package companyurl.companyname.service;

import companyurl.companyname.dto.Student;

public interface IStudentService {
	public String addStudent(Integer sid, String sname, Integer sage, String saddress);
	
	public Student searchStudent(Integer sid);
	
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress);
	
	public String deleteStudent(Integer sid);
}
