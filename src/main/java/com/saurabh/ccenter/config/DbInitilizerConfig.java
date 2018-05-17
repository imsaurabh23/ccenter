package com.saurabh.ccenter.config;

import com.saurabh.ccenter.config.properties.CreateQueryNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Configuration
public class DbInitilizerConfig {

//    @Autowired
//    private DataSource dataSource;
//
////    @Value("${ccenter.tables.creation}")
////    String   listOfTableCreationQueries;
//    @Autowired
//    private CreateQueryNames createQueryNames;
//
//    @PostConstruct
//    public void initialize(){
//        try {
//           Connection connection = dataSource.getConnection();
//            Statement statement = connection.createStatement();
//            //statement.execute("");
//            System.out.println("UPDATE :::::::::::::::::");
//            createQueryNames.getCreateQueryNames().forEach(query->
//            {
//                try {
//                    statement.executeUpdate(query);
//                } catch (SQLException e) {
//                    System.out.println("EXCEPTION :::::::::::::::::");
//                    e.printStackTrace();
//                }
//            });
//            statement.close();
//            connection.close();
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
