package Positive.Admin;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.extentReportManager;
import utils.baseTest;
import java.awt.*;
import java.io.IOException;

public class User_Management extends baseTest{
    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        loadUrl();
        webSteps.login();
        webSteps.waiting();
        webSteps.click("UM_clickAdmin");
    }

    @Test(priority = 1)
    public void adduser() throws InterruptedException, AWTException {
        extentReportManager.startTest("Test Cases for Admin", "<b> Add User </b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case  : </font>TC01: Verify that the user can successfully add a user</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>Logged to System > Click Admin > Click Add");
        webSteps.click("UM_clickAddUser");
        webSteps.select("UM_userRole",2,1);
        webSteps.type("Admin Admin123", "UM_employeeName");
        webSteps.waiting();
        webSteps.select("UM_employeeName",2,1);
        webSteps.select("UM_status",2,1);
        webSteps.type("Samindya","UM_userName");
        webSteps.type("Samindya123","UM_password");
        webSteps.type("Samindya123","UM_confirmPassword");
        webSteps.waiting();
        webSteps.click("UM_saveButton");
        webSteps.implicitWait("UM_toastMessage");
        Assert.assertEquals("Successfully Saved",webSteps.getText("UM_toastMessage"), "Passed");
    }

    @Test(priority = 2)
    public void searchuserUsingUsername() throws InterruptedException, AWTException {
        extentReportManager.startTest("Test Cases for Admin", "<b> Search user using username</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case  : </font>TC02: Verify that the user can successfully search a user using username</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>Logged to System > Click Admin > Type in Search > Click Search");
        webSteps.type("Admin","UM_searchUsername");
        webSteps.click("UM_searchButton");
        webSteps.waiting();
        Assert.assertEquals("Admin", webSteps.getText("UM_searchResultUsername"), "Passed");
    }
}
