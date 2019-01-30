import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    @Test
        public void testLogin(){
        clickOnLoginButton();
        fillLoginForm("elena.telran@yahoo.com", "12345.com");
        confirmLogin();
    }


}
