import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBaseWikipedia {
    WebDriver wd;

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){

    }

    public void clickConfirmButton() {
        click(By.id("wpLoginAttempt"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void fillLoginForm(String login, String password) {
        click(By.id("wpName1"));
        clear(By.id("wpName1"));
        type(login, By.id("wpName1"));
        click(By.id("wpPassword1"));
        clear(By.id("wpPassword1"));
        type(password, By.id("wpPassword1"));
    }

    public void type(String login, By locator) {
        wd.findElement(locator).sendKeys(login);
    }

    public void clickOnLoginButton() {

        click(By.id("pt-login"));
    }

    public void changeLanguage() {

        click(By.cssSelector("div[lang=en]"));
    }

    public void openSite(String url) {
        wd.get(url);
    }

    protected void addToWatchlist() {
        click(By.id("ca-watch"));
    }

    public void search(String search) {
        click(By.cssSelector("input[name=search]"));
        clear(By.cssSelector("input[name=search]"));
        type(search, By.cssSelector("input[name=search]"));
        click(By.cssSelector("input[name=go]"));
    }

    public void clear(By locator) {
        wd.findElement(locator).clear();
    }
}
