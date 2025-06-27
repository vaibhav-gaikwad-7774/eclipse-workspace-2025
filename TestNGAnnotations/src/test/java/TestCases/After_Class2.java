package TestCases;


import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

public class After_Class2 {
    @AfterClass
    public void afterClass() {
        System.out.println("These are type of backend testing");
    }
    @Test
    public void fun1() {
        System.out.println("Structural testing");
    }
    @Test
    public void fun2() {
        System.out.println("Functional Testing");
    }
    @Test
    public void fun3() {
        System.out.println("Non-Functional Testing");
    }
}