package com.saurabh.ccenter.controller;

import com.saurabh.ccenter.enums.MessageEnums;
import com.saurabh.ccenter.model.BatchModel;
import com.saurabh.ccenter.model.FeeModel;
import com.saurabh.ccenter.repository.FeeJpaRepository;
import com.saurabh.ccenter.repository.StudentJpaRepository;
import com.saurabh.ccenter.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/fee")
public class FeeDetailsController {
    @Autowired
    private FeeService feeService;

    @GetMapping(value = "/getAll")
    public List<FeeModel> getAll() {
        return feeService.getAllFeeDetails();
    }

    @GetMapping(value = "/searchById/{id}")
    public FeeModel searchById(@PathVariable Integer id) {
        return feeService.getById(id);
    }

    @GetMapping(value = "/searchByDate/{transactionDate}")
    public List<FeeModel> searchByDate(@PathVariable String transactionDate) {
        return feeService.getByDate(transactionDate);
    }

    @GetMapping(value = "/searchByName/{name}")
    public List<FeeModel> searchByName(@PathVariable String name){
        return feeService.getByName(name);
    }

    @GetMapping(value = "/searchByBatchId/{batchId}")
    public List<FeeModel> searchByBatchId(@PathVariable Integer batchId) {
        return feeService.getByBatchId(batchId);
    }

    @PostMapping(value = "/add")
    public RedirectView getAll(FeeModel feeModel){
        String responseMsg = feeService.addFeeDetails(feeModel);
        if(MessageEnums.FEE_ADD.getMsg().equals(responseMsg)){
            return new RedirectView("/dashboard");
        }
        return null;
    }

    @PostMapping(value = "/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return feeService.deleteById(id);
    }

    @PostMapping(value = "/update/{id}")
    public String update(@PathVariable Integer id, @RequestBody FeeModel feeModel) {
        return feeService.updateById(id,feeModel);
    }

    @PostMapping(value = "/deleteAll")
    public String deleteAll() {
        return feeService.deleteAll();
    }


}
