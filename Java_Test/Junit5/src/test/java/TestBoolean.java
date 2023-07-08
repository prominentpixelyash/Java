import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBoolean {

    @Test
    public void testBooleanTrue(){
        assertTrue(501>101);
        assertTrue(501<101,"501 is greater than 101");
    }

    @Test
    public void testBooleanFalse(){
        assertFalse("Yash".equals("Rajput"));
        assertFalse("yash".equals("yash"),"Both String is equals");
    }

}
