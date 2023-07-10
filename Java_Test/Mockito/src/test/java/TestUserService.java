import com.prominentpixel.daos.LoginDao;
import com.prominentpixel.serviceimpl.UserServicesImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestUserService {

//    @InjectMocks
    private static UserServicesImpl userServices;

//    @Mock
    private static LoginDao loginDao;


//    public void TestUserService(){
//        MockitoAnnotations.openMocks(this);
//    }

    @BeforeAll
    public static void setUp(){
        loginDao= Mockito.mock(LoginDao.class);
        userServices=new UserServicesImpl(loginDao);
    }

    @AfterAll
    public static void afterAll(){
        loginDao=null;
        userServices=null;
    }

    @Test
    public void testLoginWithCredential() {
        Mockito.when(loginDao.checkUser("yati","yati123")).thenReturn(1);
        assertTrue(userServices.login("yati","yati123"));
    }

    @Test
    public void testLoginWithOutCredential(){
        Mockito.when(loginDao.checkUser("yash","rajput")).thenReturn(0);
        assertFalse(userServices.login("yash","rajput1"));
    }

    @Test
    public void testWithOutCredential(){
        assertThrows(IllegalArgumentException.class,()->userServices.login("",""));
    }

    @Test
    public void testWithSpy(){
        List<String> listOfSpy=Mockito.spy(List.class);
        listOfSpy.add("Hello");
        System.out.println(listOfSpy.size());
        System.out.println(listOfSpy.toString());
    }

}
