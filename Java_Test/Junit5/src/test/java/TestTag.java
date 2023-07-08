import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestTag {

    @Tag("dev")
    @Test
    public void testDev(){
        System.out.println("Inside method of developer");
    }

    @Tag("pro")
    @Test
    public void testPro(){
        System.out.println("Inside method of production");
    }

    @Tag("tes")
    @Test
    public void testTest(){
        System.out.println("Inside method of testing");
    }

    @Tag("dev")
    @Test
    public void testDev1(){
        System.out.println("Inside developer method 1");
    }

}
