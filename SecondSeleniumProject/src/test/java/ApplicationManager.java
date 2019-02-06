import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    public void start() {
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
        type(user, By.cssSelector("input[type=email]"));
        type(password, By.cssSelector("input[type=password]"));

    }

    public void type(String text, By locator) {
        click(locator);
        clear(locator);
        wd.findElement(locator).sendKeys(text);
    }

    private void clear(By locator) {
        wd.findElement(locator).clear();
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void login() {
        clickOnLoginButton();
        fillLoginForm("elena.telran@yahoo.com", "12345.com");
        confirmLogin();
    }

    public void stop() throws InterruptedException {
        Thread.sleep(3000);
//        wd.close();
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

    public void clickOnCreateTeamButtonOnNavMenu() {
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
    }

    public void fillTeamCreationForm() {
        type("NewTeam", By.id("org-display-name"));
        type("Discription", By.id("org-desc"));
    }

    public void submitTeamCreation() {
        click(By.cssSelector("input[value=Create]"));
    }

    public void logout() {
        clickOnAvatar();
        clickOnLogOutButton();
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("div.header-user .icon-add"));
    }

    public void selectCreateBoard() {
        click(By.cssSelector("a.js-new-board .sub-name"));
    }

    public void addBoardTitle(String text) {
        type(text, By.cssSelector(".subtle-input"));
    }

    public void clickCreateButton() {
        click(By.cssSelector("button[type='submit']"));
    }
}
