import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW3_WikipediaAddArticleGamesOfThrone {
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
        fillLoginForm("oropennyv4110", "oropennyv");
        clickConfirmButton();
        search("Game of Thrones");
        addToWatchlist();
    }

    @AfterClass
    public void tearDown(){

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

    private void addToWatchlist() {
        wd.findElement(By.id("ca-watch")).click();
//        wd.findElement(By.id("ooui-php-3")).click();
    }

    public void search(String search) {
        wd.findElement(By.name("search")).click();
        wd.findElement(By.name("search")).clear();
        wd.findElement(By.name("search")).sendKeys(search);
        wd.findElement(By.name("go")).click();
    }
}
