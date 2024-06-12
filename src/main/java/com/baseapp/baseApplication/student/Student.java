package com.baseapp.baseApplication.student;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;


import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 50)
    private String name;
    @Size(min = 2, max = 50)
    private String email;
    @Transient
    private int age;

    private LocalDate dob;
    @Size(max = 6)
    private String gender;
    @Size(min = 2, max = 25)
    private String address;

    public Integer getAge(){
        return Period.between(dob, LocalDate.now()).getYears();
    }

}

