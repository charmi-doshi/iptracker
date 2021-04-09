package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bean.StudentBean;
import com.controller.DBConnectionHeroku;
import com.service.StudentService;

public class StudentDao implements StudentService {
	Connection conn;
	PreparedStatement pstmt;
	boolean flag=false;
	public boolean addStudent(StudentBean studentbean)
	{
		conn = DBConnectionHeroku.getConnection();
		if(conn!=null)
		{
		
			 try {
				 //insert query
				pstmt = conn.prepareStatement("insert into student(sname) values(?)");
				
				pstmt.setString(1, studentbean.getsName());
				
				
				int res = pstmt.executeUpdate();
				System.out.println("in method");
				if(res>0)
				{
					flag=true;
					System.out.println("inserted");
				}
				
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					 
		}
		return flag;
	}
	
	public List<StudentBean> getAllStudents()
	{
		Connection conn = DBConnectionHeroku.getConnection();
		List<StudentBean> students=new ArrayList<>();
		
		if(conn!=null)
		{
			try {
				pstmt = conn.prepareStatement("select * from student");
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					StudentBean studentbean = new StudentBean();
					studentbean.setsId(rs.getInt(1));
					studentbean.setsName(rs.getString(2));
					
					students.add(studentbean);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return students;
	}
}
