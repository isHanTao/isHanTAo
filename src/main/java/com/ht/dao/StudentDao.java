package com.ht.dao;

import com.ht.model.Student;

import java.util.List;


public interface StudentDao {
    public List<Student> getAllStudent();
    public Student getStudentById(String id);
    public void addStudent(Student student);
    public void deleteStudentById(String id);
    public List<Student> getStudentsByClassId(int classId);

}
