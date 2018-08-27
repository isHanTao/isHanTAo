package com.ht;

import com.ht.dao.StudentDao;
import com.ht.mapper.ClassMapper;
import com.ht.mapper.TeacherMapper;
import com.ht.model.ClassName;
import com.ht.model.Student;
import com.ht.mapper.StudentMapper;
import com.ht.model.Teacher;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DomeTest {
    private ApplicationContext applicationContext;
    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("config/spring-mvc.xml");
        BasicConfigurator.configure();
    }
    @Test
    public void test1(){
        StudentDao studentDao = (StudentDao) applicationContext.getBean("StudentDao");
        System.out.println(studentDao);
        List<Student> allStudent = studentDao.getAllStudent();
        for (Student student : allStudent) {
            System.out.println(student);
        }
        Student student = studentDao.getStudentById("16310320218");
        System.out.println(student);
    }
    @Test
    public void test2(){
        StudentMapper studentService = (StudentMapper) applicationContext.getBean("studentMapper");
        List<Student> students = studentService.getStudentByClassId(2);
        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Test
    public void test3(){
        TeacherMapper Service = (TeacherMapper) applicationContext.getBean("teacherMapper");

        System.out.println(Service.getTeacherById("0001"));
    }

    @Test
    public void test4(){
        StudentMapper studentService = (StudentMapper) applicationContext.getBean("studentMapper");
        Student student = new Student();

        student.setClassId(2);
        student.setSex("男");
        System.out.println(student);
        List<Student> students = studentService.getStudentByParame(student);
        for (Student student1 : students) {
            System.out.println(student1);
        }
    }
    @Test
    public void test5(){
        ClassMapper classMapper = (ClassMapper) applicationContext.getBean("classMapper");

        System.out.println(classMapper.getClassNameById(2));
    }

}
