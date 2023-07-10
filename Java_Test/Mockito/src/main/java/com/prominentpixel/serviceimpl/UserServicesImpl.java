package com.prominentpixel.serviceimpl;

import com.prominentpixel.daos.LoginDao;
import com.prominentpixel.services.UserService;

public class UserServicesImpl implements UserService {

    private LoginDao loginDao;

    public UserServicesImpl(LoginDao loginDao){
        this.loginDao=loginDao;
    }

    @Override
    public boolean login(String userName, String password) {

        if (userName=="" || password==""){
            throw new IllegalArgumentException("Username or password is empty");
        }
        else{
            int count=loginDao.checkUser(userName,password);
            if (count>0){
                return true;
            }
            return false;
        }

    }
}
