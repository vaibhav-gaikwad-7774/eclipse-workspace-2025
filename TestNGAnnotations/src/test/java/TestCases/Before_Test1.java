package TestCases;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class Before_Test1 {

    @BeforeTest
    public void beforeTest() {
        System.out.println("This method will be executed before the execution of all @Test annotated methods");
    }

    @Test
    public void test1() {
        System.out.println("Test1 Executed");
    }

    @Test
    public void test2() {
        System.out.println("Test2 Executed");
    }

}