package com.springboot.test.service.Impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.test.entity.Student;
import com.springboot.test.repositories.StudentRepository;
import com.springboot.test.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository stuRepository;

	@Override
	public List<Student> getAllStudents() {
		
		return stuRepository.findAll();
	}

	@Override
	public void addNewStudent(@Valid Student student) {
		stuRepository.saveAndFlush(student);
		
	}

	@Override
	public Student getStudentById(int id) {
		
		return stuRepository.getOne((long) id);
	}

	@Override
	public void update(Student oldStudent) {
		stuRepository.saveAndFlush(oldStudent);
		
	}

	@Override
	public void removeBtId(int id) {
		stuRepository.deleteById((long) id);
		
	}

	@Override
	public List<Student> getAllStudentById() {
		List<Student> students = stuRepository.findAll();
		return students;
	}

}
