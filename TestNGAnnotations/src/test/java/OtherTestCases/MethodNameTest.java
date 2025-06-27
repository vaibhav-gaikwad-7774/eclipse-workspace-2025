package OtherTestCases;

import org.testng.annotations.Test;

public class MethodNameTest {



    @Test(priority = 0)
    public void testMethod1() {
        System.out.println("Executing testMethod1 with priority 0");
    }

    @Test(priority = -1)
    public void testMethod2() {
        System.out.println("Executing testMethod2 with priority -1");
    }


}