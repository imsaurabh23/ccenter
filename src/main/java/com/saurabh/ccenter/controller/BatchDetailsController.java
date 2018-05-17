package com.saurabh.ccenter.controller;

import com.saurabh.ccenter.enums.MessageEnums;
import com.saurabh.ccenter.model.BatchModel;
import com.saurabh.ccenter.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping(value = "/batch")
public class BatchDetailsController {
    @Autowired
    private BatchService batchService;

    @GetMapping(value = "/getAll")
    public List<BatchModel> getAll(){
        return batchService.getAllBatchDetails();
    }

    @GetMapping(value = "/searchById/{id}")
    public BatchModel searchById(@PathVariable Integer id){
        return batchService.getById(id);
    }

    @GetMapping(value = "/searchByName/{name}")
    public List<BatchModel> searchByName(@PathVariable String name){
        return batchService.getByName(name);
    }

    @PostMapping(value = "/add")
    public RedirectView getAll(BatchModel batchModel){
        String responseMsg = batchService.addBatch(batchModel);
        if(MessageEnums.BATCH_ADD.getMsg().equals(responseMsg)){
            return new RedirectView("/dashboard");
        }
        return null;
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        return batchService.deleteById(id);
    }

    @PostMapping(value = "/update/{id}")
    public String updateById(@PathVariable Integer id,@RequestBody BatchModel batchModel){
        return batchService.updateById(id,batchModel);
    }

    @PostMapping(value = "/deleteAll")
    public String deleteAll(){
        return batchService.deleteAll();
    }
}

