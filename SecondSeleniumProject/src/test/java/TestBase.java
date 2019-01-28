import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;

    @BeforeClass
        public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://trello.com/");
    }

    public void clickOnLoginButton() {
        wd.findElement(By.className("header-button-secondary")).click();
    }

    public void confirmLogin() {
        wd.findElement(By.id("login")).click();
    }

    public void fillLoginForm() {
        wd.findElement(By.cssSelector("input[type=email]")).click();
        wd.findElement(By.cssSelector("input[type=email]")).clear();
        wd.findElement(By.cssSelector("input[type=email]")).sendKeys("elena.telran@yahoo.com");

        wd.findElement(By.cssSelector("input[type=password]")).click();
        wd.findElement(By.cssSelector("input[type=password]")).clear();
        wd.findElement(By.cssSelector("input[type=password]")).sendKeys("12345.com");
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void login(){
        clickOnLoginButton();
        fillLoginForm();
        confirmLogin();
    }

    @AfterClass
    public void tearDown(){
//        wd.quit();
    }

    public boolean isUserLogedIn() {
        return isElementPresent(By.cssSelector("img.member-avatar"));
    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickOnAvatar() {
        wd.findElement(By.cssSelector("img.member-avatar")).click();
    }

    public void clickOnLogOutButton() {
        wd.findElement(By.cssSelector("a.js-logout")).click();
    }
}
