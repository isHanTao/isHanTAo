package com.ht.service;

import com.ht.mapper.ClassMapper;
import com.ht.mapper.TeacherMapper;
import com.ht.model.ClassName;
import com.ht.model.Student;
import com.ht.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentService studentService;
    @Autowired
    ClassMapper classMapper;
    public String getPasswordById(String id) {
        return teacherMapper.getPasswordById(id);
    }

    public void update(Teacher teacher) {
        teacherMapper.update(teacher);
    }

    public boolean cheackId(String id) {
        boolean flag = false;
        if (teacherMapper.getTeacherById(id) == null) {
            flag = true;
        }
        return flag;
    }

    public boolean logIn(String id, String password) {
        boolean flag = false;
        String s = teacherMapper.getPasswordById(id);
        if (password.equals(s)) {
            flag = true;
        }
        return flag;
    }

    public Teacher getMessageById(String name) {
        System.out.println(teacherMapper.getTeacherById(name));
        return teacherMapper.getTeacherById(name);
    }

    public List<Student> getStudentByClassId(int id) {
        List<Student> students = studentService.getStudentsByClassId(id);
        return students;
    }

    public List<Student> getStudentByParame(Student student){
        return studentService.getStudentByParame(student);
    }
    public ClassName getClassNameById(int id){
        return classMapper.getClassNameById(id);
    }

}
