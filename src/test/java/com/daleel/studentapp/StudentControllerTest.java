package com.daleel.studentapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.daleel.studentapp.controller.StudentController;
import com.daleel.studentapp.service.StudentService;

@WebMvcTest(value = StudentController.class)
public class StudentControllerTest {	
	
	
	
	@MockBean
	private StudentService studentservice;
	
	@Autowired
    private MockMvc mockMvc;
	
	
	@Test
	public void testInitial() throws Exception {
		Mockito.when(studentservice.getWelcome()).thenReturn(new ResponseEntity<String>("Success", HttpStatus.OK));	
		
		MockHttpServletRequestBuilder reqBuilder= MockMvcRequestBuilders.get("/test");
		
		ResultActions result=mockMvc.perform(reqBuilder);
		MvcResult mvc=result.andReturn();
		MockHttpServletResponse response=mvc.getResponse();
		int status=response.getStatus();
		assertEquals(200, status);
	}

	
	
	
	

}

