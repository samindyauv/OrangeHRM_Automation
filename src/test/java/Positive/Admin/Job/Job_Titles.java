package Positive.Admin.Job;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.awt.*;
import java.io.IOException;

public class Job_Titles extends baseTest {

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {
        loadUrl();
        webSteps.login();
        webSteps.waiting();
        webSteps.click("UM_clickAdmin");
        webSteps.click("JB_clickJob");
        webSteps.click("JB_clickJobTitle");
    }

    @Test(priority = 1)
    public void deleteJobTitle() throws InterruptedException, AWTException {
        extentReportManager.startTest("Test Cases for Admin", "<b> Delete Job Title</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case  : </font>TC02: Verify that the user can successfully delete a job title</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>Logged to System > Click Admin > Click Job > Click Job Title > Click Delete");
        webSteps.waiting();
        webSteps.click("JB_deleteButton");
        webSteps.waiting();
        webSteps.click("JB_deleteConfirmationButton");
        webSteps.implicitWait("JB_toastMessage");
        Assert.assertEquals("Successfully Deleted", webSteps.getText("JB_toastMessage"), "Passed");
    }
}
