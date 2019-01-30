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

    protected void clickOnLoginButton() {
        click(By.className("header-button-secondary"));
    }

    private void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void confirmLogin() {
        click(By.id("login"));
    }

    protected void fillLoginForm(String user, String password) {
        click(By.cssSelector("input[type=email]"));
        clear(By.cssSelector("input[type=email]"));
        type(By.cssSelector("input[type=email]"), user);

        click(By.cssSelector("input[type=password]"));
        clear(By.cssSelector("input[type=password]"));
        type(By.cssSelector("input[type=password]"), password);
    }

    private void type(By locator, String text) {
        wd.findElement(locator).sendKeys(text);
    }

    private void clear(By locator) {
        wd.findElement(locator).clear();
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void login(){
        clickOnLoginButton();
        fillLoginForm("elena.telran@yahoo.com", "12345.com");
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
        click(By.cssSelector("img.member-avatar"));
    }

    public void clickOnLogOutButton() {
        click(By.cssSelector("a.js-logout"));
    }
}
