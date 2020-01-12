package com.springboot.test.service;

import java.util.List;

import javax.validation.Valid;

import com.springboot.test.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();

	void addNewStudent(@Valid Student student);

	Student getStudentById(int id);

	void update(Student oldStudent);

	void removeBtId(int id);

	List<Student> getAllStudentById();

}
