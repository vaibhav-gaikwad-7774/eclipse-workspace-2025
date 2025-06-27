package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

public class After_Class1 {

    @AfterClass
    public void afterClass() {
        System.out.println("These are type of frontend testing");
    }
    @Test
    public void fun1() {
        System.out.println("Unit Testing");
    }
    @Test
    public void fun2() {
        System.out.println("Integration Testing:");
    }
    @Test
    public void fun3() {
        System.out.println("Regression Testing");
    }
    public void fun4() {
        System.out.println("System Testing");
    }
}