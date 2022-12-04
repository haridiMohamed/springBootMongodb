package com.Smongodb.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

//@SpringBootApplication(exclude = {
//		MongoAutoConfiguration.class,
//		MongoDataAutoConfiguration.class
//})
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	CommandLineRunner runner(StudentRepository studentRepository){
		return args -> {
			String email = "simo@gmail.com";
			Address address = new Address("maroc","ksar el kbir","10000");
			Student student = new Student("mohamed","haridi",email,Gender.MALE,address, List.of("Computer Science","Math"), BigDecimal.TEN, LocalDateTime.now());
			//studentRepository.insert(student);
			studentRepository.findStudentByEmail(email).ifPresentOrElse(s->{
				System.out.println(student+" already exists");
			},()->{
				System.out.println("Inserting student "+student);
			});
		};
	}

}
