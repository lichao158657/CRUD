package com.chao.crud.service;

import com.chao.crud.entity.Student;
import com.github.pagehelper.PageInfo;

public interface StudentService {
    PageInfo<Student> selAllStudnet(Integer pageNum);

    int del(Integer id);

    Student findStudentById(Integer id);

    int addStudent(Student student);

    int updateStudent(Student student);
}
