import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@org.junit.jupiter.api.TestInstance(org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS)
public class TestInstance {

    static int i=100;
    int j=10;

    @BeforeEach
    public void testBeforeEach(){
        i++;
        j--;
    }

    @Test
    public void testInstance1(){
        System.out.println("Test instance 1 -> "+i+"<-->"+j);
    }

    @Test
    public void testInstance2(){
        System.out.println("Test instance 2 -> "+i+"<-->"+j);
    }

    @AfterEach
    public void testAfterEach(){
        i++;
        j--;
    }

}
