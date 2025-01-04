package companyurl.companyname.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import companyurl.companyname.daofactory.StudentDaoFactory;
import companyurl.companyname.dto.Student;
import companyurl.companyname.persistence.IStudentDao;
import companyurl.companyname.servicefactoy.StudentServiceFactory;

public class StudentServiceImpl implements IStudentService {

	private IStudentDao stdDao;
	@Override
	public String addStudent(Integer sid, String sname, Integer sage, String saddress) throws FileNotFoundException, SQLException, IOException {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.addStudent(sid, sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteStudent(Integer sid) {
		// TODO Auto-generated method stub
		return null;
	}

}
