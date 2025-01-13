package companyurl.companyname.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import companyurl.companyname.dto.Student;

public interface IStudentDao {
	public String addStudent(Integer sid, String sname, Integer sage, String saddress) throws SQLException, FileNotFoundException, IOException;
	
	public Student searchStudent(Integer sid) throws FileNotFoundException, SQLException, IOException;
	
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress);
	
	public String deleteStudent(Integer sid) throws FileNotFoundException, IOException, SQLException;
}
