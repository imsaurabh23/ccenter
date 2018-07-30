package com.saurabh.ccenter.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix =   "ccenter.tables")
public class CreateQueryNames {
    private List<String> listOfTableCreationQueries=new ArrayList<>();
    public List<String> getCreateQueryNames(){
        System.out.println("QUERY ::::::::::::;:::::::::::::::::: "+listOfTableCreationQueries.get(0));
        return listOfTableCreationQueries;
    }
}
