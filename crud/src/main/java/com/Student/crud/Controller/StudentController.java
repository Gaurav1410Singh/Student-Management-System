package com.Student.crud.Controller;

import com.Student.crud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import com.Student.crud.Entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @PostMapping("/add")
    public String addStudent(Student student,BindingResult result,Model model){
        studentRepository.save(student);
        return "redirect:list";
    }

    @GetMapping("/signup")
    public String signupStudent(Student student){
        return "addStudent";
    }

    @GetMapping("/list")
    public String listStudent(Model model){
         model.addAttribute("student", studentRepository.findAll());
         return "Index";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") Long id, Model model){
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Student Id : "+id));
        model.addAttribute("student",student);
        return "updateStudent";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, Student student, BindingResult result, Model model){
        studentRepository.save(student);
        model.addAttribute("student",studentRepository.findAll());
        return "Index";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, Model model){
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Student Id : "+id));
        studentRepository.delete(student);
        model.addAttribute("student",studentRepository.findAll());
        return "Index";
    }
}
