package com.ht.dao;

import com.ht.model.Student;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao{

    @Override
    public List<Student> getAllStudent() {
        return getSqlSession().selectList("com.ht.dao.getAllStudent");
    }

    @Override
    public Student getStudentById(String id) {
        return getSqlSession().selectOne("com.ht.dao.getStudentById","16310320218");
    }

    @Override
    public void addStudent(Student student) {

    }

    @Override
    public void deleteStudentById(String id) {

    }

    @Override
    public List<Student> getStudentsByClassId(int classId) {
        return null;
    }
}
