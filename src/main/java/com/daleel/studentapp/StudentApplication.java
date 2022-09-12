package com.daleel.studentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

///ARR |12-09-2022| daleel| Test Project for an API exposure with mongoDB
///Student
///Get all and create new student

@SpringBootApplication
@EnableMongoRepositories("com.daleel.studentapp.repo")
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	
	///further sec config can be added once proper implementation 
	///with restrictive users
}
