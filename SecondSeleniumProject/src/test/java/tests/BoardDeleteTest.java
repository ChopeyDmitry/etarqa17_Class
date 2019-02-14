package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeleteTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!applicationManager.getSessionHelper().isUserLogedIn()) {
            applicationManager.getSessionHelper().login();
        }
    }

    @Test
    public void testBoardDeleteFromBody(){
        applicationManager.getBoardHelper().selectBoard();
        applicationManager.getBoardHelper().clickMoreButton();
        applicationManager.getBoardHelper().clickCloseBoard();
        applicationManager.getBoardHelper().confirmCloseBoard();


    }
}
