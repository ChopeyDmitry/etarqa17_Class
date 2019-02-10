package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        if (!applicationManager.getSessionHelper().isUserLogedIn()) {
            applicationManager.getSessionHelper().login();
        }
    }
    @Test
    public void testBoardCreationFromHeader() throws InterruptedException {
        Thread.sleep(3000);
        applicationManager.clickOnPlusButtonOnHeader();
        applicationManager.getBoardHelper().selectCreateBoard();
        applicationManager.getBoardHelper().addBoardTitle("NewBoard");
        applicationManager.getBoardHelper().clickCreateButton();
    }
//    @Test
//    public void testBoardCreationFromLeftSidebar() throws InterruptedException {
//        Thread.sleep(3000);
//        applicationManager.clickOnHomeButtonOnLeftSidebar();
//        applicationManager.clickOnCreateBoardButton();
//        applicationManager.addBoardTitle("NewBoard");
//        applicationManager.clickCreateButton();
//
//    }
}
