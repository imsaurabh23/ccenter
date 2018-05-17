package com.saurabh.ccenter.controller;

import com.saurabh.ccenter.enums.MessageEnums;
import com.saurabh.ccenter.model.UserModel;
import com.saurabh.ccenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserDetailsController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAll")
    public List<UserModel> getAll(){
        return userService.getAllUserDetails();
    }

    @GetMapping(value = "/searchById/{id}")
    public UserModel searchById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @GetMapping(value = "/searchByName/{name}")
    public List<UserModel> searchByName(@PathVariable String name){
        return userService.getByName(name);
    }

    @PostMapping(value = "/add")
    public String getAll(UserModel userModel){
        System.out.println("Called");
        return userService.addBatch(userModel);
    }

    @PostMapping(value = "/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        return userService.deleteById(id);
    }

    @PostMapping(value = "/update/{id}")
    public String updateById(@PathVariable Integer id,@RequestBody UserModel userModel){
        return userService.updateById(id,userModel);
    }

    @PostMapping(value = "/deleteAll")
    public String deleteAll(){
        return userService.deleteAll();
    }

    @PostMapping(value = "/verifyPassword")
    public void verifyPassword(HttpServletResponse response, UserModel userModel) throws IOException {
        MessageEnums messageEnums = userService.verifyPassword(userModel.name, userModel.password);
        if(messageEnums ==MessageEnums.USER_MATCHED){
            response.sendRedirect("/dashboard");
        }
        else {
            response.sendRedirect("/");
        }
    }
}

