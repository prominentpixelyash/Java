package com.prominentpixel.servicesimpl;

import com.prominentpixel.daos.UserDao;
import com.prominentpixel.services.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao=userDao;
    }
    public String getUserEmail(Integer userId) {
        String email=userDao.getEmail(userId);
        return email;
    }
}
