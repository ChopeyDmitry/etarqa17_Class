package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void clickOnLoginButton() {
        click(By.className("header-button-secondary"));
    }

    public void confirmLogin() {
        click(By.id("login"));
    }

    public void fillLoginForm(String user, String password) throws InterruptedException {
        Thread.sleep(5000);
        type(user, By.cssSelector("input[type=email]"));
        type(password, By.cssSelector("input[type=password]"));

    }

    public void login() throws InterruptedException {
        clickOnLoginButton();
        fillLoginForm("elena.telran@yahoo.com", "12345.com");
        confirmLogin();
    }

    public boolean isUserLogedIn() {
        return isElementPresent(By.cssSelector("img.member-avatar"));
    }

    public void clickOnAvatar() {
        click(By.cssSelector("img.member-avatar"));
    }

    public void clickOnLogOutButton() {
        click(By.cssSelector("a.js-logout"));
    }

    public void logout() {
        clickOnAvatar();
        clickOnLogOutButton();
    }
}
