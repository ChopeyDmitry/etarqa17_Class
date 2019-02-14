package tests;

import model.Team;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TeamCreationTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException {
        if (!applicationManager.getSessionHelper().isUserLogedIn()) {
            applicationManager.getSessionHelper().login();
        }
    }

    @Test
    public void TeamCreationFromLeftNavMenu() {
        applicationManager.getTeamHelper().clickOnCreateTeamButtonOnNavMenu();
        applicationManager.getTeamHelper().fillTeamCreationForm(new Team()
                .withTeamName("NewTeam " + TimeUnit.SECONDS)
                .withDiscription("Discription"));
        applicationManager.getTeamHelper().submitTeamCreation();
    }
}
