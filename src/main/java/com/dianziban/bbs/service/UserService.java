package com.dianziban.bbs.service;

import com.dianziban.bbs.dao.UserDao;
import com.dianziban.bbs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User getUser(int id) {
        return userDao.selectById(id);
    }
}
