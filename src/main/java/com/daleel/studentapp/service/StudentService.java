package com.daleel.studentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daleel.studentapp.model.Student;
import com.daleel.studentapp.repo.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;

	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	public String saveStudent(Student student) {

		List<Student> list = studentRepo.findStudentByFirstName(student.getFirstName());
		if (list != null && list.size() > 0) {
			System.out.println("Student with similar first name already exists");
			return "Student with similar first name already exists";
		} else {
			studentRepo.insert(student);
			return "New student has been added successfully!";

		}
	}
}
