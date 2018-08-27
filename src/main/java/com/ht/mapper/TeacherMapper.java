package com.ht.mapper;

import com.ht.model.Student;
import com.ht.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherMapper {

    public String getPasswordById(String id);
    public void update(Teacher teacher);
    public Teacher getTeacherById(String id);


}
