import com.prominentpixel.MyPrimeNumber;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMyPrimeNumber {

    private static MyPrimeNumber myPrimeNumber;

    @BeforeAll
    public static void testBeforeAll(){
        System.out.println("Inside before all");
        myPrimeNumber=new MyPrimeNumber();
    }

    @BeforeEach
    public void testBeforeEach(){
        System.out.println("Inside before each");
    }

    @Order(4)
    @RepeatedTest(5)
    public void repeatedTestNumberIsPrime(){
        System.out.println("***** inside repeated test *****");
    }


    @Order(2)
    @Test
    public void  testNumberIsPrime2(){
        System.out.println("Number 51 is prime -> "+myPrimeNumber.checkNumberIsPrime(51));
    }

    @Order(3)
    @Test
    public void  testNumberIsPrime3(){
        System.out.println("Inside prime 3");
    }

    @Disabled
    @Order(5)
    @Test
    public void  testNumberIsPrime4(){
        System.out.println("Inside prime 4");
    }

    @Order(6)
    @Test
    public void  testNumber(){
        assertEquals(3,2);
    }


    @DisplayName("This is special name for method to check prime number")
    @Order(1)
    @Test
    public void testNumberIsPrime(){
        System.out.println("Number 7 is prime -> "+myPrimeNumber.checkNumberIsPrime(7));
    }

    @AfterEach
    public void testAfterEach(){
        System.out.println("Inside after each");
    }

    @AfterAll
    public static void testAfterAll(){
        System.out.println("Inside after all");
        myPrimeNumber=null;
    }

}
