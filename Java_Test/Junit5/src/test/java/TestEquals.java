import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEquals {

    @Test
    public void testNumEquals(){
        assertEquals(11,11);
        assertEquals(21.0,21.0);
        assertEquals(51.51,51.51);
    }

    @Test
    public void testCharEquals(){
        assertEquals('Y','Y');
    }

    @Test
    public void testStringEquals(){
         assertEquals("Yash","Yash");
    }

}
