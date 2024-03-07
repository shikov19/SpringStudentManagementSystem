package com.baseapp.baseApplication.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Georgi = new Student(
                    1L,
                    "Georgi",
                    "gorgo@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)

            );
            Student Maria = new Student(
                    2L,
                    "Maria",
                    "mariam@gmail.com",
                    LocalDate.of(2005, Month.JANUARY, 5)
            );

            repository.saveAll(List.of(Georgi, Maria));

        };
    }
}
