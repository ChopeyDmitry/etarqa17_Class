package tests;

import manager.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected static ApplicationManager applicationManager = new ApplicationManager();

    @BeforeClass
    public void setUp() {
        applicationManager.start();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        applicationManager.stop();
    }

}
