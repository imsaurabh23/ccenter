package com.saurabh.ccenter.service;

import com.saurabh.ccenter.util.LoggerMessage;
import com.saurabh.ccenter.enums.MessageEnums;
import com.saurabh.ccenter.model.BatchModel;
import com.saurabh.ccenter.repository.BatchJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BatchService {
    @Autowired
    private BatchJpaRepository batchJpaRepository;

    public List<BatchModel> getAllBatchDetails() {
        LoggerMessage.logAndReturn(MessageEnums.BATCH_ALL_SHOWED.getMsg());
        return batchJpaRepository.findAll();
    }

    public BatchModel getById(Integer id) {
        if (batchJpaRepository.exists(id)) {
            LoggerMessage.logAndReturn(MessageEnums.BATCH_SHOWED.getMsg(), Integer.toString(id));
            return batchJpaRepository.findOne(id);
        }
        return null;
    }

    public List<BatchModel> getByName(String name) {
        List<BatchModel> batchModelList = new ArrayList<BatchModel>();
        batchJpaRepository.findAll().forEach(batchModel -> {
            if (batchModel.name.equalsIgnoreCase(name)) {
                batchModelList.add(batchModel);
            }
        });
        LoggerMessage.logAndReturn(MessageEnums.BATCH_SHOWED.getMsg(), name);
        return batchModelList;
    }

    public String addBatch(BatchModel batchModel) {
        BatchModel batchModelReturn = batchJpaRepository.save(batchModel);
        return LoggerMessage.logAndReturn(MessageEnums.BATCH_ADD.getMsg(), batchModelReturn.name);
    }

    public String deleteById(Integer id) {
        if (batchJpaRepository.exists(id)) {
            batchJpaRepository.delete(BatchModel.builder().id(id).build());
            System.out.println("Record deleted : " + id);
            return LoggerMessage.logAndReturn(MessageEnums.BATCH_DELETE.getMsg(), Integer.toString(id));
        }
        return LoggerMessage.logAndReturn(MessageEnums.BATCH_ID_NOT_EXIST.getMsg(), Integer.toString(id));
    }

    public String updateById(Integer id, BatchModel batchModel) {
        if (batchJpaRepository.exists(id)) {
            batchModel.setId(id);
            batchJpaRepository.save(batchModel);
            System.out.println("Record deleted : " + id);
            return LoggerMessage.logAndReturn(MessageEnums.BATCH_UPDATE.getMsg() ,Integer.toString(id));
        }
        return LoggerMessage.logAndReturn(MessageEnums.BATCH_ID_NOT_EXIST.getMsg() ,Integer.toString(id));
    }

    public String deleteAll() {
        batchJpaRepository.deleteAll();
        return LoggerMessage.logAndReturn(MessageEnums.BATCH_ALL_DELETE.getMsg());
    }
}
