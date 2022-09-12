package com.daleel.studentapp.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.daleel.studentapp.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
	
	List<Student> findStudentByFirstName(String firstName);

}
