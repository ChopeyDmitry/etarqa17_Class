package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    SessionHelper sessionHelper;
    BoardHelper boardHelper;
    TeamHelper teamHelper;
    WebDriver wd;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;

    }

    public void start() {
//        String browser = BrowserType.CHROME;
        if(browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new FirefoxDriver();
        } else if(browser.equals(BrowserType.EDGE)){
            wd = new EdgeDriver();
        }
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://trello.com/");
        sessionHelper = new SessionHelper(wd);
        boardHelper = new BoardHelper(wd);
        teamHelper = new TeamHelper(wd);
    }

    public void openSite(String url) {
        wd.get(url);
    }

    public void stop() throws InterruptedException {
        Thread.sleep(5000);
        wd.close();
    }


    public void clickOnPlusButtonOnHeader() {
        boardHelper.click(By.cssSelector("div.header-user .icon-add"));
    }

    public BoardHelper getBoardHelper() {
        return boardHelper;
    }

    public TeamHelper getTeamHelper() {
        return teamHelper;
    }


    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public void returnToPreviousPage() {
        wd.navigate().back();
    }

}

    //    public void clickOnHomeButtonOnLeftSidebar() {
//        click(By.cssSelector("[data-test-id='home-link']"));
//    }
//
//    public void clickOnCreateBoardButton() {
//        click(By.cssSelector("button .icon-add[css='1']"));
//    }

