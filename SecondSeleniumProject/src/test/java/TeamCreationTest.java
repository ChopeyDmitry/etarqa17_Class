import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if (!applicationManager.isUserLogedIn()) {
            applicationManager.login();
        }
    }

    @Test
    public void TeamCreationFromLeftNavMenu(){
        applicationManager.clickOnCreateTeamButtonOnNavMenu();
        applicationManager.fillTeamCreationForm();
        applicationManager.submitTeamCreation();
    }
}
