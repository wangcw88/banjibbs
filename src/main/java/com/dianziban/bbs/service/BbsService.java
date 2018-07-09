package com.dianziban.bbs.service;


import org.springframework.stereotype.Service;

@Service
public class BbsService {
    public String getMessage(int userId){
        return "Hello Message:"+String.valueOf(userId);
    }
}
