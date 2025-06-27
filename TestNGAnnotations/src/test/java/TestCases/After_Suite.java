package TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class After_Suite {

    @AfterSuite
    public void afterSuite() {
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