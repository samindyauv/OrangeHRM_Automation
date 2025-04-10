package Positive;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.baseTest;
import utils.extentReportManager;

import java.io.IOException;

public class Login extends baseTest {
    @BeforeMethod
    public void setUp() throws InterruptedException, IOException {

        loadUrl();
        webSteps.login();
        extentReportManager.startTest("Test Cases for Login", "<b> Login </b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Case : </font>TC01: Verify user can log in with valid credentials</b>");
        extentReportManager.testSteps("<b><font color='blue'>Test Steps : </font></b>Open URL > Enter valid credentials > Click login");
        webSteps.waiting();
    }

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        boolean urlVerification = driver.getCurrentUrl().contains("dashboard");
        Assert.assertTrue(urlVerification, "Expecting login success but not navigated to dashboard");
    }
}
