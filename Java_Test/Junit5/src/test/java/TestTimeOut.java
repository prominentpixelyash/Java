import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestTimeOut {

    @Timeout(6)
    @Test
    public void testTimeout() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Inside timeout method");
    }

    @Timeout(5)
    @Test
    public void testTimeout1() throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("Inside timeout method 1");
    }

    @Test
    public void  testTimeOutWithOutTimeOutAnnotation() throws InterruptedException {
        Assertions.assertTimeout(Duration.ofSeconds(11),()->getTimeUnit(10));
        System.out.println("Inside timeout method without timeout annotation");
    }

    private void getTimeUnit(int sec) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    }

}
