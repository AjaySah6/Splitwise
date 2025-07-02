package com.example.demo.Exception;

public class GroupNotFoundException extends RuntimeException{
    public GroupNotFoundException(){}
    public GroupNotFoundException (String message){
        super(message);
    }
}
