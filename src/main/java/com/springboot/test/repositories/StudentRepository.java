package com.springboot.test.repositories;

import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.test.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	


}
