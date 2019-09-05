package com.chao.crud.mapper;

import com.chao.crud.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("select * from Student")
    List<Student> selAllStudent();
    @Delete("delete from student where id=#{id}")
    int del(Integer id);
    @Select("select * from student where id=#{id}")
    Student findStudentById(Integer id);
    @Insert("insert into student(id,name,sex,gradeId)"+"values(null,#{name},#{sex},#{gradeId});")
    int addStudent(Student student);
    @Update("update student set name=#{name},sex=#{sex},gradeId=#{gradeId} where id=#{id};")
    int updateStudent(Student student);
}
