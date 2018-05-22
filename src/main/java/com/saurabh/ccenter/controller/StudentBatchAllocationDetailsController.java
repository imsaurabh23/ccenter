package com.saurabh.ccenter.controller;

import com.saurabh.ccenter.enums.MessageEnums;
import com.saurabh.ccenter.model.FeeModel;
import com.saurabh.ccenter.model.StudentBatchAllocationModel;
import com.saurabh.ccenter.model.UserModel;
import com.saurabh.ccenter.service.StudentBathchAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/sballocation")
public class StudentBatchAllocationDetailsController {
    @Autowired
    private StudentBathchAllocationService studentBathchAllocationService;

    @GetMapping(value = "/getAll")
    public List<StudentBatchAllocationModel> getAll(){
        return studentBathchAllocationService.getAllBathcStudentAllocationDetails();
    }

    @GetMapping(value = "/searchById/{id}")
    public StudentBatchAllocationModel searchById(@PathVariable Integer id){
        return studentBathchAllocationService.getById(id);
    }

    @GetMapping(value = "/searchByName/{name}")
    public List<StudentBatchAllocationModel> searchByName(@PathVariable String date){
        return studentBathchAllocationService.searchByDate(date);
    }

    @PostMapping(value = "/add")
    public RedirectView getAll(StudentBatchAllocationModel studentBatchAllocationModel){
        String responseMsg = studentBathchAllocationService.addBatchStudentAllocation(studentBatchAllocationModel);
        if(MessageEnums.FEE_ADD.getMsg().equals(responseMsg)){
            return new RedirectView("/dashboard");
        }
        return null;
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        return studentBathchAllocationService.deleteById(id);
    }

    @PostMapping(value = "/update/{id}")
    public String updateById(@PathVariable Integer id,@RequestBody StudentBatchAllocationModel studentBatchAllocationModel){
        return studentBathchAllocationService.updateById(id,studentBatchAllocationModel);
    }

    @PostMapping(value = "/deleteAll")
    public String deleteAll(){
        return studentBathchAllocationService.deleteAll();
    }

}

