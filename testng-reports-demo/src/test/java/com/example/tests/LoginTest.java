package com.example.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginTest {
    private String appStatus;

    @BeforeMethod
    public void setUp() {
        appStatus = "Initialized"; // Simulate app setup
    }

    @Test
    public void testValidLogin() {
        String result = simulateLogin("user@example.com", "Pass123!");
        assertEquals(result, "Success", "Valid login should succeed");
    }

    @Test
    public void testInvalidLogin() {
        String result = simulateLogin("user@example.com", "WrongPass");
        assertEquals(result, "Failure", "Invalid login should fail");
    }

    @Test
    public void testEmptyEmail() {
        String result = simulateLogin("", "Pass123!");
        assertEquals(result, "Error: Email required", "Empty email should show error");
    }

    // Simulate login logic
    private String simulateLogin(String email, String password) {
        if (email.isEmpty()) {
            return "Error: Email required";
        }
        if (email.equals("user@example.com") && password.equals("Pass123!")) {
            return "Success";
        }
        return "Failure";
    }
}