import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!applicationManager.isUserLogedIn()) {
            applicationManager.login();
        }
    }

    @Test
    public void testLogout() throws InterruptedException {
        Thread.sleep(3000);
        applicationManager.clickOnAvatar();
        applicationManager.clickOnLogOutButton();

        Assert.assertFalse(applicationManager.isUserLogedIn());
    }

}
