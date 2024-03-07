package com.baseapp.baseApplication;

import com.baseapp.baseApplication.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class BaseApplication {

	public static void main(String[] args) {

		SpringApplication.run(BaseApplication.class, args);
	}



}
