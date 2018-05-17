package com.saurabh.ccenter.service;

import com.saurabh.ccenter.util.LoggerMessage;
import com.saurabh.ccenter.enums.MessageEnums;
import com.saurabh.ccenter.model.StudentModel;
import com.saurabh.ccenter.repository.StudentJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentJpaRepository studentJpaRepository;

    public List<StudentModel> getAllStudentDetails() {
        LoggerMessage.logAndReturn(MessageEnums.STUDENT_ALL_SHOWED.getMsg());
        return studentJpaRepository.findAll();
    }

    public StudentModel getById(Integer id) {
        if (studentJpaRepository.exists(id)) {
            LoggerMessage.logAndReturn(MessageEnums.STUDENT_SHOWED.getMsg() ,Integer.toString(id));
            return studentJpaRepository.findOne(id);
        }
        return null;
    }

    public StudentModel getByBatchId(Integer id) {
        if (studentJpaRepository.exists(id)) {
            LoggerMessage.logAndReturn(MessageEnums.STUDENT_SHOWED.getMsg() ,Integer.toString(id));
            return studentJpaRepository.findOne(id);
        }
        return null;
    }


    public List<StudentModel> getByName(String name) {
        List<StudentModel> studentModelList = new ArrayList<StudentModel>();
        studentJpaRepository.findAll().forEach(studentModel -> {
            if (studentModel.name.equalsIgnoreCase(name)) {
                studentModelList.add(studentModel);
            }
        });
        LoggerMessage.logAndReturn(MessageEnums.STUDENT_SHOWED.getMsg() + name);
        return studentModelList;
    }

    public String addStudent(StudentModel studentModel) {
        StudentModel studentModelReturn = studentJpaRepository.save(studentModel);
        return LoggerMessage.logAndReturn(MessageEnums.STUDENT_ADD.getMsg() , studentModelReturn.name);
    }

    public String deleteStudentById(Integer id) {
        if (studentJpaRepository.exists(id)) {
            studentJpaRepository.delete(StudentModel.builder().id(id).build());
            return LoggerMessage.logAndReturn(MessageEnums.STUDENT_DELETE.getMsg(),Integer.toString(id));
        }
        return LoggerMessage.logAndReturn(MessageEnums.STUDENT_ID_NOT_EXIST.getMsg() ,Integer.toString(id));
    }

    public String updateById(Integer id, StudentModel studentModel) throws IllegalAccessException {
        if (studentJpaRepository.exists(id)) {
            StudentModel savedValueModel = studentJpaRepository.findOne(id);
            for (Field field : studentModel.getClass().getDeclaredFields()) {
                if (field.get(studentModel) == null) {
                    field.set(studentModel, field.get(savedValueModel));
                }
            }
            studentJpaRepository.save(studentModel);
            return LoggerMessage.logAndReturn(MessageEnums.STUDENT_UPDATE.getMsg(),Integer.toString(id));
        }
        return LoggerMessage.logAndReturn(MessageEnums.STUDENT_ID_NOT_EXIST.getMsg() ,Integer.toString(id));
    }

    public String deleteAll() {
        studentJpaRepository.deleteAll();
        return LoggerMessage.logAndReturn(MessageEnums.STUDENT_ALL_DELETE.getMsg());
    }
}
