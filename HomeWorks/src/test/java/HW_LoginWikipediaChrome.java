import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW_LoginWikipediaChrome {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @Test
    public void test(){
        openSite("https://www.wikipedia.org/");
        changeLanguage();
        clickOnLoginButton();
        fillLoginForm("ivanovivan@fmail.com", "qwerty");
        clickConfirmButton();

    }

    public void clickConfirmButton() {
        wd.findElement(By.id("wpLoginAttempt")).click();
    }

    public void fillLoginForm(String login, String password) {
        wd.findElement(By.id("wpName1")).click();
        wd.findElement(By.id("wpName1")).clear();
        wd.findElement(By.id("wpName1")).sendKeys(login);
        wd.findElement(By.id("wpPassword1")).click();
        wd.findElement(By.id("wpPassword1")).clear();
        wd.findElement(By.id("wpPassword1")).sendKeys(password);
    }

    public void clickOnLoginButton() {
        wd.findElement(By.id("pt-login")).click();
    }

    public void changeLanguage() {
        wd.findElement(By.id("js-link-box-en")).click();
    }

    public void openSite(String url) {
        wd.get(url);
    }

    @AfterClass
    public void tearDown(){

    }


}

