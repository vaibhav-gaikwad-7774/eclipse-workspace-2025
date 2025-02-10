import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SampleTest {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @Test
    public void testMethod1() {
        System.out.println("Test Method 1");
    }

    @Test
    public void testMethod2() {
        System.out.println("Test Method 2");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }
}
