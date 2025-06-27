package TestCases;


import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Before_Group {

    @BeforeGroups(groups = {"authentication"})
    public void setUpAuthentication() {
        System.out.println("Database setup complete for authentication tests.");
    }

    @Test(groups = {"authentication"})
    public void testLogin() {
        System.out.println("Login test executed.");
    }
    @Test(groups = {"authentication"})
    public void testSignup() {
        System.out.println("Signup test executed.");
    }
    @Test(groups = {"authentication"})
    public void testSignout() {
        System.out.println("Signout test executed.");
    }

}