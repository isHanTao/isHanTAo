package com.ht.controller;

import com.ht.mapper.StudentMapper;
import com.ht.model.Student;
import com.ht.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    StudentService  studentService;
    Student student;

    @RequestMapping("/list")
    public String getAllStudents(Model model){
        model.addAttribute("list", studentService.getAllStudent());
        return "students";
    }
    @RequestMapping("/addStudent")
    public String addStudent(){
        return "add";
    }
    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public String addStudent(Student student){
        studentService.addStudent(student);
        return "redirect: /student/list";
    }
    @RequestMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        studentService.deleteStudentById(id);
        return "redirect: /student/list";
    }
    @RequestMapping(value = "/edit/{id}")
    public String editStudent(@PathVariable String id,Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit";
    }
    @RequestMapping(value = "/edit")
    public String editStudent(Student student){
        System.out.println(student);
        studentService.update(student);
        return "redirect: /student/list";
    }

}
