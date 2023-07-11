package com.prominentpixel;

import com.prominentpixel.daos.UserDao;
import com.prominentpixel.services.UserService;
import com.prominentpixel.servicesimpl.UserServiceImpl;
import org.easymock.EasyMock;
import org.junit.Test;

public class UserServiceTest {

    @Test
    public void testGetUserEmail(){

        UserDao daoProxy= EasyMock.createMock(UserDao.class);
        EasyMock.expect(daoProxy.getEmail(501)).andReturn("rajputyash006@gmail.com").times(2);
        EasyMock.expect(daoProxy.getEmail(502)).andReturn("yati123@gmail.com");
        EasyMock.expect(daoProxy.getEmail(503)).andReturn("nitin789@gmail.com");
        EasyMock.expect(daoProxy.getEmail(504)).andReturn("saveen147@gmail.com");
        EasyMock.expect(daoProxy.getEmail(505)).andReturn("amit159@yahoo.com");
        EasyMock.replay(daoProxy);
        UserService userService=new UserServiceImpl(daoProxy);
        String email1=userService.getUserEmail(501);
        String email2=userService.getUserEmail(502);
        String email3=userService.getUserEmail(501);
        System.out.println(email1);
        System.out.println(email2);
        System.out.println(email3);
        //reset the behaviour and interaction of mock
        EasyMock.reset(daoProxy);
        String email4=userService.getUserEmail(501);
        System.out.println(email4);
    }

}
