package companyurl.companyname.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import companyurl.companyname.dto.Student;

public class StudentDaoImpl implements IStudentDao {

	Connection connection;
	File f;
	FileInputStream fis;
	Properties properties;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	Student student;
	
	public void login() throws SQLException {
		String configFile = "C:\\Users\\Administrator\\app\\Jdbc_Crud_App\\Jdbc_Crud_App\\src\\credentials\\loginInfo.properties";
		HikariConfig config = new HikariConfig(configFile);
		HikariDataSource dataSource = new HikariDataSource(config);
		connection = dataSource.getConnection();
	}
	
	
	public String addStudent(Integer sid, String sname, Integer sage, String saddress) throws SQLException, IOException {
	
		login();
		
		String query = "insert into student values (?,?,?,?)";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, sid);
		preparedStatement.setString(2, sname);
		preparedStatement.setInt(3,sage);
		preparedStatement.setString(4, saddress);
		Integer rowsAffected = preparedStatement.executeUpdate();
		if (rowsAffected ==1) {
			return "success";
		}
		else {
			return "failure";
		}
	}

	@Override
	public Student searchStudent(Integer sid) throws SQLException, IOException {
	
		login();
		String query = "select * from student where sid = ? ";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1,sid);
		resultSet = preparedStatement.executeQuery();
		
		if (resultSet != null) {
			if(resultSet.next()) {
			
				student = new Student();
				student.setSid(resultSet.getInt(1));
				student.setSname(resultSet.getString(2));
				student.setSage(resultSet.getInt(3));
				student.setSaddress(resultSet.getString(4));
				return student;
			
			}
		}
		
		return student;
		
	}

	@Override
	public String updateStudent(Student student) throws SQLException, IOException {
		login();
		String query = "update student set sname = ? , sage = ? , saddress = ? where sid = ? ";
		PreparedStatement pstmt = connection.prepareStatement(query);
		pstmt.setString(1, student.getSname());
		pstmt.setInt(2, student.getSage());
		pstmt.setString(3, student.getSaddress());
		pstmt.setInt(4, student.getSid());
		
		int rowsAffected = pstmt.executeUpdate();
		if (rowsAffected == 1) {
			return "success";
		}
		else {
			return "failed";
		}
	}

	@Override
	public String deleteStudent(Integer sid) throws IOException, SQLException {
		login();
		String query = "delete from student where sid = ?";
		preparedStatement = connection.prepareStatement(query);
			if (preparedStatement!=null) {
				preparedStatement.setInt(1, sid);
				int rowAffected = preparedStatement.executeUpdate();
				if (rowAffected == 1) {
					return "success";
				}
				else {
					return "not found";
				}
			}
		return "failure";
	}

	

}
