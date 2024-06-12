package com.baseapp.baseApplication.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/student")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "index";
    }


    @GetMapping("/student/new")
    public String createStudentForm(Model model) {
        Student students = new Student();
        model.addAttribute("students", students);
        return "addstudent";
    }

    @PostMapping("/student/new")
    public String addStudent(@ModelAttribute("students") Student students) {
        studentService.saveStudent(students);
        return "redirect:/student";
    }

    @GetMapping("/student/edit/{studentId}")
    public String editStudentForm(@PathVariable long studentId, Model model) {
        Student students = studentService.getStudentById(studentId);
        model.addAttribute("students", students);
        return "editstudent";
    }
    @PostMapping("/student/{studentId}")
    public String updateStudent(@PathVariable("studentId") long studentId, @ModelAttribute("students") Student students, Model model) {
        students.setId(studentId);
        studentService.updateStudent(students);
        return "redirect:/student";
    }

    @GetMapping("/student/delete/{studentId}")
    public String deleteStudent(@PathVariable("studentId") long studentId) {
        studentService.deleteStudentById(studentId);
        return "redirect:/student";
    }
}













