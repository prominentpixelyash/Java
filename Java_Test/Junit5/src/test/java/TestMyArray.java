import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestMyArray {

    @Test
    public void testArray() {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        assertArrayEquals(arr1, arr2);
    }

    @Test
    public void testByteArray() {
        Byte[] arr1 = {1, 2, 3, 4, 5};
        Byte[] arr2 = {1, 2, 3, 4, 5};
        assertArrayEquals(arr1, arr2);
    }

    @Test
    public void testDoubleArray(){
        Double[] arr1={1.1,11.1,21.21,51.51};
        Double[] arr2={1.1,11.1,21.21,51.51};
        assertArrayEquals(arr1,arr2);
    }

    @Test
    public void testCharArray() {
        char[] arr1 = {'a', 'A', 'b', 'B', 'c', 'C'};
        char[] arr2 = {'a', 'A', 'b', 'B', 'c', 'C'};
        assertArrayEquals(arr1, arr2);
    }

    @Test
    public void testStringArray() {
        String[] arr1 = {"Hello","Prominent","Pixel"};
        String[] arr2 = {"Hello","Prominent","Pixel"};
        assertArrayEquals(arr1, arr2);
    }

}
