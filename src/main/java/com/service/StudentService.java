package com.service;

import java.util.List;

import com.bean.StudentBean;


public interface StudentService {

	public boolean addStudent(StudentBean studentbean);
	public List<StudentBean> getAllStudents();
}
