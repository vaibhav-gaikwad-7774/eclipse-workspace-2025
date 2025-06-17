package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import keywords.Keywords;
import utils.ExcelUtils;

public class DriverScript {
    private WebDriver driver;
    private Keywords keywords;

    @BeforeSuite
    public void setup() {
        driver = new ChromeDriver();
        keywords = new Keywords(driver);
        ExcelUtils.setExcelFile("C:\\Users\\GFG0329\\eclipse-workspace\\maven\\src\\test\\resources\\testData.xlsx");
    }

    @Test
    public void executeTests() throws Exception {
        int rowCount = ExcelUtils.getRowCount("TestSuite");
        for (int i = 1; i <= rowCount; i++) {
            String testCaseID = ExcelUtils.getCellData("TestSuite", i, 0);
            String runFlag = ExcelUtils.getCellData("TestSuite", i, 1);

            if (runFlag.equalsIgnoreCase("Y")) {
                System.out.println("Executing Test Case: " + testCaseID);
                executeTestCase(testCaseID);
            } else {
                ExcelUtils.setCellData("TestSuite", i, 3, "Skipped");
                System.out.println("Skipping Test Case: " + testCaseID);
            }
        }
    }

    private void executeTestCase(String testCaseID) throws Exception {
        int rowCount = ExcelUtils.getRowCount(testCaseID);
        boolean testPassed = true;

        for (int i = 1; i <= rowCount; i++) {
            String keyword = ExcelUtils.getCellData(testCaseID, i, 1);
            String objectName = ExcelUtils.getCellData(testCaseID, i, 2);
            String data = ExcelUtils.getCellData(testCaseID, i, 3);

            try {
                switch (keyword) {
                    case "openUrl":
                        keywords.openUrl(data);
                        break;
                    case "enterText":
                        keywords.enterText(objectName, data);
                        break;
                    case "click":
                        keywords.click(objectName);
                        break;
                    case "verifyElementPresent":
                        boolean isPresent = keywords.verifyElementPresent(objectName);
                        ExcelUtils.setCellData(testCaseID, i, 6, String.valueOf(isPresent));
                        if (!isPresent) testPassed = false;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid keyword: " + keyword);
                }
                ExcelUtils.setCellData(testCaseID, i, 5, "Pass");
            } catch (Exception e) {
                ExcelUtils.setCellData(testCaseID, i, 5, "Fail");
                ExcelUtils.setCellData(testCaseID, i, 4, e.getMessage());
                testPassed = false;
                e.printStackTrace();
            }
        }

        ExcelUtils.setCellData("TestSuite", ExcelUtils.getRowByTestCaseID("TestSuite", testCaseID), 3, testPassed ? "Pass" : "Fail");
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}