package com.saurabh.ccenter.service;

import com.saurabh.ccenter.enums.MessageEnums;
import com.saurabh.ccenter.model.UserModel;
import com.saurabh.ccenter.repository.UserJpaRepository;
import com.saurabh.ccenter.util.LoggerMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.saurabh.ccenter.enums.MessageEnums.USER_ID_NOT_EXIST;
import static com.saurabh.ccenter.enums.MessageEnums.USER_PASSWORD_NOT_MATCHED;

@Service
public class UserService {
    @Autowired
    private UserJpaRepository userJpaRepository;

    public List<UserModel> getAllUserDetails(){
        LoggerMessage.logAndReturn(MessageEnums.USER_ALL_SHOWED.getMsg());
        return userJpaRepository.findAll();
    }

    public UserModel getById( Integer id){
        if(userJpaRepository.exists(id)) {
            LoggerMessage.logAndReturn(MessageEnums.USER_SHOWED.getMsg(),Integer.toString(id));
            return userJpaRepository.findOne(id);
        }
        return null;
    }

    public List<UserModel> getByName( String name){
        List<UserModel> userModelList=new ArrayList<UserModel>();
        userJpaRepository.findAll().forEach(userModel -> {
            if(userModel.name.equalsIgnoreCase(name)){
                userModelList.add(userModel);
            }});
        LoggerMessage.logAndReturn(MessageEnums.USER_SHOWED.getMsg(),name);
        return userModelList;
    }

    public String addBatch( UserModel userModel){
        UserModel userModelReturn = userJpaRepository.save(userModel);
        return LoggerMessage.logAndReturn(MessageEnums.USER_ADD.getMsg(),userModelReturn.name);
    }

    public String deleteById(Integer id){
        if(userJpaRepository.exists(id)) {
            userJpaRepository.delete(UserModel.builder().id(id).build());
            System.out.println("Record deleted : " + id);
            return LoggerMessage.logAndReturn(MessageEnums.USER_DELETE.getMsg() ,Integer.toString(id));
        }
        return LoggerMessage.logAndReturn(MessageEnums.USER_ID_NOT_EXIST.getMsg(),Integer.toString(id));
    }

    public String updateById(Integer id, UserModel userModel){
        if(userJpaRepository.exists(id)) {
            userModel.setId(id);
            userJpaRepository.save(userModel);
            System.out.println("Record deleted : " + id);
            return LoggerMessage.logAndReturn(MessageEnums.USER_UPDATE.getMsg() ,Integer.toString(id));
        }
        return LoggerMessage.logAndReturn(MessageEnums.USER_ID_NOT_EXIST.getMsg(),Integer.toString(id));
    }

    public String deleteAll(){
        userJpaRepository.deleteAll();
        return LoggerMessage.logAndReturn(MessageEnums.BATCH_ALL_DELETE.getMsg());
    }

    public MessageEnums verifyPassword(String name, String password){
        AtomicReference<MessageEnums> response = new AtomicReference<MessageEnums>();
        response.set(MessageEnums.USER_ID_NOT_EXIST);
        userJpaRepository.findAll().forEach(userModel -> {
            if(userModel.name.equalsIgnoreCase(name)) {
                if (userModel.password.equalsIgnoreCase(password)) {
                    response.set(MessageEnums.USER_MATCHED);
                    return;
                } else {
                    response.set(MessageEnums.USER_PASSWORD_NOT_MATCHED);
                }
            }
        });
        return response.get();
    }
}
