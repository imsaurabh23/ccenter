package com.saurabh.ccenter.service;

import com.saurabh.ccenter.model.StudentModel;
import com.saurabh.ccenter.util.LoggerMessage;
import com.saurabh.ccenter.enums.MessageEnums;
import com.saurabh.ccenter.model.FeeModel;
import com.saurabh.ccenter.repository.FeeJpaRepository;
import com.saurabh.ccenter.repository.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeeService {
    @Autowired
    private FeeJpaRepository feeJpaRepository;
    @Autowired
    private StudentJpaRepository studentJpaRepository;

    public List<FeeModel> getAllFeeDetails() {
        LoggerMessage.logAndReturn(MessageEnums.FEE_ALL_SHOWED.getMsg());
        return feeJpaRepository.findAll();
    }

    public FeeModel getById(Integer id) {
        if (feeJpaRepository.exists(id)) {
            LoggerMessage.logAndReturn(MessageEnums.FEE_SHOWED.getMsg() + id);
            return feeJpaRepository.findOne(id);
        }
        return null;
    }

    public List<FeeModel> getByDate(String transactionDate) {
        List<FeeModel> feeModelList = new ArrayList<FeeModel>();
        feeJpaRepository.findAll().forEach(feeModel -> {
            if (feeModel.transactionDate.equalsIgnoreCase(transactionDate)) {
                feeModelList.add(feeModel);
            }
        });
        LoggerMessage.logAndReturn(MessageEnums.FEE_SHOWED.getMsg() + transactionDate);
        return feeModelList;
    }

    public List<FeeModel> getByName(String name){
        List<Integer> studentIdList=new ArrayList<Integer>();
        studentJpaRepository.findAll().forEach(studentModel -> {
            if(studentModel.name.equalsIgnoreCase(name)){
                studentIdList.add(studentModel.id);
            }});
        List<FeeModel> feeModelList = new ArrayList<FeeModel>();
        studentIdList.forEach(id->feeJpaRepository.findAll().forEach(feeModel -> {
            if (feeModel.studentId.intValue()==id.intValue()) {
                feeModelList.add(feeModel);
            }
        }));
        LoggerMessage.logAndReturn(MessageEnums.FEE_SHOWED.getMsg() + name);
        return feeModelList;
    }

    public List<FeeModel> getByBatchId(Integer batchId) {
        List<FeeModel> feeModelList = new ArrayList<FeeModel>();
        feeJpaRepository.findAll().forEach(feeModel -> {
            if (feeModel.batchId.intValue()==batchId.intValue()) {
                feeModelList.add(feeModel);
            }
        });
        LoggerMessage.logAndReturn(MessageEnums.FEE_SHOWED.getMsg() ,Integer.toString(batchId));
        return feeModelList;
    }

    public String addFeeDetails(FeeModel feeModel) {
        feeModel=makeAllUpperCase(feeModel);
        FeeModel feeModelReturn = feeJpaRepository.save(feeModel);
        return LoggerMessage.logAndReturn(MessageEnums.FEE_ADD.getMsg() , feeModelReturn.studentId + " " +
                feeModelReturn.batchId + " " + feeModelReturn.transactionDate + " " + feeModelReturn.amount);
    }

    private FeeModel makeAllUpperCase(FeeModel feeModel) {
        feeModel.submittedTo=feeModel.submittedTo.toUpperCase();
        return feeModel;
    }

    public String deleteById(Integer id) {
        if (feeJpaRepository.exists(id)) {
            feeJpaRepository.delete(FeeModel.builder().id(id).build());
            return LoggerMessage.logAndReturn(MessageEnums.FEE_DELETE.getMsg(), Integer.toString(id));
        }
        return LoggerMessage.logAndReturn(MessageEnums.FEE_ID_NOT_EXIST.getMsg() ,Integer.toString(id));
    }

    public String updateById(Integer id, FeeModel feeModel) {
        if (feeJpaRepository.exists(id)) {
            feeModel.setId(id);
            feeJpaRepository.save(feeModel);
            return LoggerMessage.logAndReturn(MessageEnums.FEE_UPDATE.getMsg() ,Integer.toString(id));
        }
        return LoggerMessage.logAndReturn(MessageEnums.FEE_ID_NOT_EXIST.getMsg() ,Integer.toString(id));
    }

    public String deleteAll() {
        feeJpaRepository.deleteAll();
        return LoggerMessage.logAndReturn(MessageEnums.FEE_ALL_DELETE.getMsg());
    }

}
