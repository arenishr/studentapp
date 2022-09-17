package com.daleel.studentapp.service;

import java.util.ArrayList;
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
	
	public List<Student> getDummyStudents() {
		System.out.println("entered in getDummyStudents");
		List<Student> list=new ArrayList<Student>();
		Student st1=new Student("a1","b1","c1");
		list.add(st1);
		return list;
	}

	public List<Student> getAllStudents() {
		System.out.println("entered in getAllStudents");
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
