package com.daleel.studentapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
@ContextConfiguration(classes = StudentApplication.class)
@ExtendWith(SpringExtension.class)
@DirtiesContext
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
public class StudentApplicationTests {
	
//	@Mock
//	@Autowired
//	StudentRepository studentrepo;
//	
//	@Autowired
//    MockMvc mockMvc;
    
	@DisplayName("To test the given object is saving"
	        + " using MongoDB template")
	@Test
	public void test(@Autowired MongoTemplate mongoTemplate) {
		  // given
        DBObject objectToSave = BasicDBObjectBuilder.start()
            .add("key", "value")
            .get();

        // when
        mongoTemplate.save(objectToSave, "collection");

        // then
        assertThat(mongoTemplate.findAll(DBObject.class, "collection")).extracting("key")
            .containsOnly("value");
	}
	
	
//	@Test
//	public void getAllRecords_success() throws Exception {
//		Student RECORD_1= new Student("a1","b1","c1");
//		Student RECORD_2= new Student("a2","b2","c2");
//		Student RECORD_3= new Student("a3","b3","c3");
//	    List<Student> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2, RECORD_3));
//	    
//	    Mockito.when(studentrepo.findAll()).thenReturn(records);
//	    
//	    mockMvc.perform(MockMvcRequestBuilders
//	            .get("/patient")
//	            .contentType(MediaType.APPLICATION_JSON))
//	            .andExpect(status().isOk())
//	            .andExpect(jsonPath("$", hasSize(3)))
//	            .andExpect(jsonPath("$[2].firstName", is("a3")));
//	}
	
	
	

}

