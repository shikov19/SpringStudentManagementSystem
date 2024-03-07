package com.baseapp.baseApplication.student;

import org.apache.el.stream.Optional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()) {
            throw new IllegalStateException("Email is taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long StudentId) {
        studentRepository.findById(StudentId);

        if(studentRepository.existsById(StudentId)) {
            studentRepository.deleteById(StudentId);
        } else {
            throw new IllegalStateException("Student with id " + StudentId + " does not exist");
        }
    }
}
