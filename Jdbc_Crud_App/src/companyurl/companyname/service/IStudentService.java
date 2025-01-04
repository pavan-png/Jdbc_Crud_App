package companyurl.companyname.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import companyurl.companyname.dto.Student;

public interface IStudentService {
	public String addStudent(Integer sid, String sname, Integer sage, String saddress) throws FileNotFoundException, SQLException, IOException;
	
	public Student searchStudent(Integer sid);
	
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress);
	
	public String deleteStudent(Integer sid);
}
