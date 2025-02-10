import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGExampleClass {

    // Before each method
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method: Setup before each test method.");
    }

    // After each method
    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method: Cleanup after each test method.");
    }

    // Before the class
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class: Setup before the test class.");
    }

    // After the class
    @AfterClass
    public void afterClass() {
        System.out.println("After Class: Cleanup after the test class.");
    }

    // Test method 1
    @Test
    public void testMethod1() {
        System.out.println("Test Method 1: Running test method 1.");
    }

    // Test method 2
    @Test
    public void testMethod2() {
        System.out.println("Test Method 2: Running test method 2.");
    }
}
