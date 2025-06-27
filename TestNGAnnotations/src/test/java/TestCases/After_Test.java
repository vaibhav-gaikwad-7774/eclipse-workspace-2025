package TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class After_Test {

    @AfterTest
    public void afterTest() {
        System.out.println("This method will be executed when all @Test annotated methods complete the execution");
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