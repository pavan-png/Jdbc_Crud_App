package companyurl.companyname.service;

import companyurl.companyname.daofactory.StudentDaoFactory;
import companyurl.companyname.dto.Student;
import companyurl.companyname.persistence.IStudentDao;
import companyurl.companyname.persistence.StudentDaoImpl;

public class StudentServiceImpl implements IStudentService {
	IStudentDao studentDao = null;

	@Override
	public String addStudent(Integer sid, String sname, Integer sage, String saddress) {
		studentDao = StudentDaoFactory.getStudentDao();
		return studentDao.addStudent(sid, sname, sage, saddress);
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
