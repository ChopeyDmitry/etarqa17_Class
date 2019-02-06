import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (applicationManager.isUserLogedIn()) {
            applicationManager.logout();
        }
    }


    @Test
    public void testLogin() {
        applicationManager.clickOnLoginButton();
        applicationManager.fillLoginForm("elena.telran@yahoo.com", "12345.com");
        applicationManager.confirmLogin();
    }


}

