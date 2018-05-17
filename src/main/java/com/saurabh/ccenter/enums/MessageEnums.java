package com.saurabh.ccenter.enums;

public enum  MessageEnums {
    BATCH_SHOWED("Batch Record Showed: "),
    BATCH_ALL_SHOWED("ALL Batch Record Showed!!!"),
    BATCH_ALL_DELETE("ALL Batch Record Deleted!!!"),
    BATCH_ADD("Batch Record Added : "),
    BATCH_UPDATE("Batch Record Updated : "),
    BATCH_DELETE("Batch Record Deleted : "),
    BATCH_ID_NOT_EXIST("Batch Id does'nt exist : "),
    FEE_ALL_SHOWED("ALL Fee Record Showed!!!"),
    FEE_SHOWED("Fee Record Showed: "),
    FEE_ALL_DELETE("ALL Fee Record Deleted!!!"),
    FEE_ADD("Fee Record Added : "),
    FEE_UPDATE("Fee Record Updated : "),
    FEE_DELETE("Fee Record Deleted : "),
    FEE_ID_NOT_EXIST("Fee Id does'nt exist : "),
    STUDENT_SHOWED("Student Record Showed: "),
    STUDENT_ALL_SHOWED("ALL Student Record Showed!!!"),
    STUDENT_ALL_DELETE("ALL Student Record Deleted!!!"),
    STUDENT_ADD("Student Record Added : "),
    STUDENT_UPDATE("Student Record Updated : "),
    STUDENT_DELETE("Student Record Deleted : "),
    STUDENT_ID_NOT_EXIST("Student Id does'nt exist : "),
    USER_SHOWED("User Record Showed: "),
    USER_ALL_SHOWED("ALL User Record Showed!!!"),
    USER_ALL_DELETE("ALL User Record Deleted!!!"),
    USER_ADD("User Record Added : "),
    USER_UPDATE("User Record Updated : "),
    USER_DELETE("User Record Deleted : "),
    USER_ID_NOT_EXIST("User Id does'nt exist : "),
    USER_PASSWORD_NOT_MATCHED("Password didn't matched !!!"),
    USER_MATCHED("User name and password matched");
    String msg;
    MessageEnums(String msg) {
        this.msg=msg;
    }
    public String getMsg(){
        return msg;
    }
}
