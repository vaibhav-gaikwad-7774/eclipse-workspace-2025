package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class Before_Class1 {
    @BeforeClass
    public void brforeClass() {
        System.out.println("Below are types of frontend testing");
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