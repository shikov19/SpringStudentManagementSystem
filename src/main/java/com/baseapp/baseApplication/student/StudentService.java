package com.baseapp.baseApplication.student;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private StudentRepository studentRepository;

        public StudentService(StudentRepository studentRepository) {
            this.studentRepository = studentRepository;
        }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }


    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public void updateStudent(Student stud) {
            Student student = addToStudent(stud);
            studentRepository.save(student);
    }

    private Student addToStudent(Student student) {
            Student studs = Student.builder()
                    .id(student.getId())
                    .name(student.getName())
                    .address(student.getAddress())
                    .dob(student.getDob())
                    .email(student.getEmail())
                    .gender(student.getGender())
                    .age(student.getAge())
                    .build();
            return studs;
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }


}
