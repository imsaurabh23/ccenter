package com.saurabh.ccenter.service;

import com.saurabh.ccenter.enums.MessageEnums;
import com.saurabh.ccenter.model.StudentBatchAllocationModel;
import com.saurabh.ccenter.model.UserModel;
import com.saurabh.ccenter.repository.StudentBatchAllocationJpaRepository;
import com.saurabh.ccenter.util.LoggerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class StudentBathchAllocationService {
    @Autowired
    private StudentBatchAllocationJpaRepository studentBatchAllocationJpaRepository;

    public List<StudentBatchAllocationModel> getAllBathcStudentAllocationDetails(){
        LoggerMessage.logAndReturn(MessageEnums.USER_ALL_SHOWED.getMsg());
        return studentBatchAllocationJpaRepository.findAll();
    }

    public StudentBatchAllocationModel getById( Integer id){
        if(studentBatchAllocationJpaRepository.exists(id)) {
            LoggerMessage.logAndReturn(MessageEnums.USER_SHOWED.getMsg(),Integer.toString(id));
            return studentBatchAllocationJpaRepository.findOne(id);
        }
        return null;
    }

    public List<StudentBatchAllocationModel> searchByDate( String date){
        List<StudentBatchAllocationModel> studentBatchAllocationModelsList=new ArrayList<StudentBatchAllocationModel>();
        studentBatchAllocationJpaRepository.findAll().forEach(studentBatchAllocationModel -> {
            if(studentBatchAllocationModel.allocationDate.equals(date)){
                studentBatchAllocationModelsList.add(studentBatchAllocationModel);
            }});
        LoggerMessage.logAndReturn(MessageEnums.USER_SHOWED.getMsg(),date);
        return studentBatchAllocationModelsList;
    }

    public String addBatchStudentAllocation( StudentBatchAllocationModel studentBatchAllocationModel){
        StudentBatchAllocationModel userModelReturn = studentBatchAllocationJpaRepository.save(studentBatchAllocationModel);
        return LoggerMessage.logAndReturn(MessageEnums.FEE_ADD.getMsg(),userModelReturn.studentId+" "+ userModelReturn.batchId);
    }

    public String deleteById(Integer id){
        if(studentBatchAllocationJpaRepository.exists(id)) {
            studentBatchAllocationJpaRepository.delete(StudentBatchAllocationModel.builder().id(id).build());
            System.out.println("Record deleted : " + id);
            return LoggerMessage.logAndReturn(MessageEnums.USER_DELETE.getMsg() ,Integer.toString(id));
        }
        return LoggerMessage.logAndReturn(MessageEnums.USER_ID_NOT_EXIST.getMsg(),Integer.toString(id));
    }

    public String updateById(Integer id, StudentBatchAllocationModel studentBatchAllocationModel){
        if(studentBatchAllocationJpaRepository.exists(id)) {
            studentBatchAllocationModel.setId(id);
            studentBatchAllocationJpaRepository.save(studentBatchAllocationModel);
            System.out.println("Record deleted : " + id);
            return LoggerMessage.logAndReturn(MessageEnums.USER_UPDATE.getMsg() ,Integer.toString(id));
        }
        return LoggerMessage.logAndReturn(MessageEnums.USER_ID_NOT_EXIST.getMsg(),Integer.toString(id));
    }

    public String deleteAll(){
        studentBatchAllocationJpaRepository.deleteAll();
        return LoggerMessage.logAndReturn(MessageEnums.BATCH_ALL_DELETE.getMsg());
    }

}
