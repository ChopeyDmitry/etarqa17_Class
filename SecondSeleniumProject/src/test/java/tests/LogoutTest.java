package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!applicationManager.getSessionHelper().isUserLogedIn()) {
            applicationManager.getSessionHelper().login();
        }
    }

    @Test
    public void testLogout() throws InterruptedException {
        Thread.sleep(3000);
        applicationManager.getSessionHelper().clickOnAvatar();
        applicationManager.getSessionHelper().clickOnLogOutButton();

        Assert.assertFalse(applicationManager.getSessionHelper().isUserLogedIn());
    }

}
