package com.ht.controller;

import com.ht.model.Student;
import com.ht.model.Teacher;
import com.ht.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping("/logIn")
    public String logIn() {
        return "teacherLogin";
    }
    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public String logIn(String name, String password, Model model){
        if(!teacherService.logIn(name,password)){
                model.addAttribute("message", "账户或密码错误");
                model.addAttribute("name",name);
                return "teacherLogin";
        }
        model.addAttribute("teacher",teacherService.getMessageById(name));
        model.addAttribute("className",teacherService.getClassNameById(teacherService.getMessageById(name).getClassId()));
        List<Student> students = teacherService.getStudentByClassId(teacherService.getMessageById(name).getClassId());
        model.addAttribute("students",teacherService.getStudentByClassId(teacherService.getMessageById(name).getClassId()));
        return "teacher";
    }

    @RequestMapping(value = "/logIn?name={name}")
    public String cheak(@PathVariable String name){
        String flag = "a";
        if(teacherService.cheackId(name))
            flag = "b";
        return flag;
    }
    @RequestMapping(value = "/select")
    public String select(Student student, Model model){
        System.out.println(student);
        List<Student> studentByParame = teacherService.getStudentByParame(student);

        model.addAttribute("studentByParame",studentByParame);
        return "selectRest";
    }

}
