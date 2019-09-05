package com.chao.crud.service.impl;

import com.chao.crud.entity.Student;
import com.chao.crud.mapper.StudentMapper;
import com.chao.crud.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studnetService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageInfo<Student> selAllStudnet(Integer pageNum) {
        //pageNum  当前的页码     pageSize：每页显示的条数
        if(pageNum==null){//刚开始请求的时候默认为1
            pageNum = 1;
        }
        PageHelper.startPage(pageNum,2);
        List<Student> students = studentMapper.selAllStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        return pageInfo;
    }

    @Override
    public int del(Integer id) {
        return studentMapper.del(id);
    }

    @Override
    public Student findStudentById(Integer id) {
        return studentMapper.findStudentById(id);
    }

    @Override
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }
}
