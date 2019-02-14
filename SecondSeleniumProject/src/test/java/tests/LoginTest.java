package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (applicationManager.getSessionHelper().isUserLogedIn()) {
            applicationManager.getSessionHelper().logout();
        }
    }


    @Test
    public void testLogin() throws InterruptedException {
        applicationManager.getSessionHelper().clickOnLoginButton();
        applicationManager.getSessionHelper().fillLoginForm("elena.telran@yahoo.com", "12345.com");
        applicationManager.getSessionHelper().confirmLogin();
    }


}

