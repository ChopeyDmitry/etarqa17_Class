package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected static ApplicationManager applicationManager = new ApplicationManager(BrowserType.CHROME);

    @BeforeClass
    public void setUp() {
        applicationManager.start();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        applicationManager.stop();
    }

}
