package com.chao.crud.controller;

import com.chao.crud.entity.Student;
import com.chao.crud.service.StudentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudnetController {
    @Autowired
    private StudentService studentService;
    @GetMapping("students")
    public  String list(Integer pageNum,Model model){
        PageInfo<Student> pageInfo=studentService.selAllStudnet(pageNum);
        model.addAttribute("pageInfo",pageInfo);
        return"list";
    }
    @RequestMapping("student/{id}")
    public String delete(@PathVariable("id")Integer id){
//        System.out.println(id+"______________________");
        studentService.del(id);
        return "redirect:students";
    }
    @RequestMapping("edit")
    public String edit(Integer id,Model model){
        if (id!=null){
            Student student = studentService.findStudentById(id);
            model.addAttribute("student",student);
        }
        return"edit";
    }
    @RequestMapping("/add")
    public String add(Student student){
        studentService.addStudent(student);
        return "redirect:students";
    }
    @RequestMapping("/upd")
    public String upd(Student student){
        studentService.updateStudent(student);
        return"redirect:students";
    }
}
