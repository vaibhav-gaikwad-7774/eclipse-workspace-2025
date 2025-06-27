package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

public class before_Suite {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("TestNG runs the test cases in alphabetical order");
    }
    @Test
    public void signup() {
        System.out.println("Test for signup");
    }
    @Test
    public void login() {
        System.out.println("Test for login");
    }
}