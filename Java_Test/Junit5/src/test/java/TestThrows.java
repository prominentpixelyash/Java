import com.prominentpixel.MyNumber;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestThrows {

    private static MyNumber number;

    @Test
    public static void testBeforeAll(){
        number=new MyNumber();
    }

    @Test
    public void testThrows(){
        assertThrows(NullPointerException.class,()->number.numberDivisionWithZero());
    }

    @Test
    public void testThrowsWithMessage(){
        assertThrows(ArithmeticException.class,()->number.numberDivisionWithZero(),"Num1 can't be dived by zero");
    }


    @Test
    public static void testAfterAll(){
        number=null;
    }

}
