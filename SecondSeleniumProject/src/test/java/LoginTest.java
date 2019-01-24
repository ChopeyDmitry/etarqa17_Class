import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver wd;

    @BeforeClass
        public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @Test
        public void testLogin(){
        openSite("https://trello.com/");
        clickOnLoginButton();
        fillLoginForm();
        confirmLogin();
    }

    public void clickOnLoginButton() {
        wd.findElement(By.className("header-button-secondary")).click();
    }

    public void confirmLogin() {
        wd.findElement(By.id("login")).click();
    }

    public void fillLoginForm() {
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("elena.telran@yahoo.com");

        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("12345.com");
    }

    public void openSite(String url) {
        wd.get(url);
    }

    @AfterClass
    public void tearDown(){

    }



}
