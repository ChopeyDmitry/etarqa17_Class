import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions() {
        if (!applicationManager.isUserLogedIn()) {
            applicationManager.login();
        }
    }
    @Test
    public void testBoardCreationFromHeader() throws InterruptedException {
        Thread.sleep(3000);
        applicationManager.clickOnPlusButtonOnHeader();
        applicationManager.selectCreateBoard();
        applicationManager.addBoardTitle("NewBoard");
        applicationManager.clickCreateButton();
    }
}
