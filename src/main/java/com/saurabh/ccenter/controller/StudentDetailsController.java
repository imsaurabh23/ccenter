package com.saurabh.ccenter.controller;

import com.saurabh.ccenter.enums.MessageEnums;
import com.saurabh.ccenter.model.BatchModel;
import com.saurabh.ccenter.model.StudentModel;
import com.saurabh.ccenter.repository.StudentJpaRepository;
import com.saurabh.ccenter.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentDetailsController {
    @Autowired
    private StudentJpaRepository studentJpaRepository;

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/getAll")
    public List<StudentModel> getAll(){
        return studentService.getAllStudentDetails();
    }

    @GetMapping(value = "/searchById/{id}")
    public StudentModel searchById(@PathVariable Integer id){
        return studentService.getById(id);
    }

    @GetMapping(value = "/searchByName/{name}")
    public List<StudentModel> searchByName(@PathVariable String name){
        return studentService.getByName(name);
    }

    @PostMapping(value = "/add")
    public RedirectView getAll(StudentModel studentModel){
        String responseMsg = studentService.addStudent(studentModel);
        if(MessageEnums.STUDENT_ADD.getMsg().equals(responseMsg)){
            return new RedirectView("/dashboard");
        }
        return null;
    }
    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable Integer id){
        return studentService.deleteStudentById(id);
    }

    @PostMapping(value = "/update/{id}")
    public String updateById(@PathVariable Integer id,@RequestBody StudentModel studentModel) throws IllegalAccessException {
        return studentService.updateById(id,studentModel);
    }

    @PostMapping(value = "/deleteAll")
    public String deleteAll(){
        return studentService.deleteAll();
    }
}
