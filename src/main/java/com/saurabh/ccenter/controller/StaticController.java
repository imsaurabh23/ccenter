package com.saurabh.ccenter.controller;

import com.saurabh.ccenter.model.BatchModel;
import com.saurabh.ccenter.model.StudentModel;
import com.saurabh.ccenter.model.UserModel;
import com.saurabh.ccenter.service.BatchService;
import com.saurabh.ccenter.service.FeeService;
import com.saurabh.ccenter.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
public class StaticController {
    @Autowired
    private BatchService batchService;
    @Autowired
    private FeeService feeService;
    @Autowired
    private StudentService studentService;


    @GetMapping(value = "/")
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/dashboard")
    public ModelAndView getDashboard(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

    @GetMapping(value = "/s")
    public String checkS(){
        return "redirect:/student/getAll";
    }
    @GetMapping(value = "/b")
    public String checkB(){
        return "redirect:/batch/getAll";
    }
    @GetMapping(value = "/f")
    public String checkf(){
        return "redirect:/fee/getAll";
    }
    @GetMapping(value = "/u")
    public String checku(){
        return "redirect:/user/getAll";
    }

    @GetMapping(value = "/viewAll")
    public ModelAndView getViewsAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_all");
        modelAndView.addObject("student", studentService.getAllStudentDetails());
        modelAndView.addObject("batch", batchService.getAllBatchDetails());
        modelAndView.addObject("fee", feeService.getAllFeeDetails());
        System.out.println(modelAndView);
        return modelAndView;
    }

    @GetMapping(value = "/addBatch")
    public ModelAndView addBatch(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add_batch");
        return modelAndView;
    }
    @GetMapping(value = "/addFee")
    public ModelAndView addFee(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add_fee");
        return modelAndView;
    }
    @GetMapping(value = "/addStudent")
    public ModelAndView addStudent(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("add_student");
        return modelAndView;
    }

    @GetMapping(value = "/searchStudent")
    public ModelAndView searchStudent(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("search_student");
        return modelAndView;
    }

    @PostMapping(value = "/searchByStudentId")
    public ModelAndView searchByStudentId(HttpServletResponse response, StudentModel studentModel){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_student");
        modelAndView.addObject("student", studentService.getById(studentModel.id));
        return modelAndView;

        //return studentService.getById(studentModel.id).toString();
        //return "redirect:/student/searchById/"+studentModel.id;
    }

    @PostMapping(value = "/searchByStudentName")
    public ModelAndView searchByStudentName(HttpServletResponse response, StudentModel studentModel){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_student");
        modelAndView.addObject("student", studentService.getByName(studentModel.name));
        return modelAndView;
        //return "redirect:/student/searchByName/"+studentModel.name;
    }

    @PostMapping(value = "/searchByBatchId")
    public ModelAndView searchByBatchId(HttpServletResponse response, BatchModel batchModel){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_batch");
        modelAndView.addObject("batch", batchService.getById(batchModel.id));
        return modelAndView;
        //return "redirect:/batch/searchById/"+batchModel.id;
    }

    @PostMapping(value = "/searchSudentByBatchId")
        public ModelAndView searchSudentByBatchId(HttpServletResponse response, BatchModel batchModel){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view_fee");
        modelAndView.addObject("fee", feeService.getByBatchId(batchModel.id));
        return modelAndView;
        //return "redirect:/batch/searchById/"+batchModel.id;
    }

}

