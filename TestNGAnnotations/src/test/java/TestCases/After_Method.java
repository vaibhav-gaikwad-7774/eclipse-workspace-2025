package TestCases;


import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class After_Method {

    @AfterMethod
    public void afterMethod() {
        System.out.println("This @AfterMethod will be executed after execution of each test method");
    }
    @Test
    public void firstMethod() {
        System.out.println("This is firstMethod");
    }
    @Test
    public void secondMethod(){
        System.out.println("This is secondMethod");
    }
    @Test
    public void thirdMethod() {
        System.out.println("This is thirdMethod");
    }
    @Test
    public void fourthMethod() {
        System.out.println("This is fourthMethod");
    }
    @Test
    public void fifthMethod() {
        System.out.println("This is fifthMethod");
    }
}