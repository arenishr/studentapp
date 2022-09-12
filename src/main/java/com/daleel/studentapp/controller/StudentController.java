package com.daleel.studentapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.daleel.studentapp.model.Student;
import com.daleel.studentapp.service.StudentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/daleel/student")
@AllArgsConstructor
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/test")
	public String checkAPI(){
		return "Daleel MongoDB API is working fine";
	}
	
	@GetMapping
	public @ResponseBody ResponseEntity<?> fetchAllStudents(){
		List<Student> studentList=studentService.getAllStudents();
		if(studentList!=null && studentList.size()>0) {
		return ResponseEntity.ok(studentList);
		}else {
		return ResponseEntity.ok("No data has been created yet");
		}
		
	}
	
	@PostMapping
	public String AddStudent(@RequestBody Student student){
		if(student.getFirstName()!=null && student.getLastName()!=null) {
			return studentService.saveStudent(student);
		}
		return "No proper inputs recieved!";
		
	}

}
