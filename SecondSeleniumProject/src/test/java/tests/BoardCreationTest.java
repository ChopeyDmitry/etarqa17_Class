package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!applicationManager.getSessionHelper().isUserLogedIn()) {
            applicationManager.getSessionHelper().login();
        }
    }
    @Test(enabled=false)
    public void testBoardCreationFromHeader() throws InterruptedException {
        Thread.sleep(3000);
        applicationManager.clickOnPlusButtonOnHeader();
        applicationManager.getBoardHelper().selectCreateBoard();
        applicationManager.getBoardHelper().addBoardTitle("NewBoard");
        applicationManager.getBoardHelper().clickCreateButton();
    }

    @Test
    public void testBoardCreationFromBody() throws InterruptedException {
        int before = applicationManager.getBoardHelper().PersonalBoardsCount();

        applicationManager.getBoardHelper().clickTheCreateNewBoardOnTheEndOfList();
        applicationManager.getBoardHelper().addBoardTitle("newBoard_body" + System.currentTimeMillis());
        applicationManager.getBoardHelper().clickTheCreateButton();
        applicationManager.returnToPreviousPage();
        Thread.sleep(3000);

        int after = applicationManager.getBoardHelper().PersonalBoardsCount();

        Assert.assertEquals(after, before+1);

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
