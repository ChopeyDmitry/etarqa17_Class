package manager;

import model.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);

    }
    public void clickOnCreateTeamButtonOnNavMenu() {
       click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
    }

    public void fillTeamCreationForm(Team team) {
        type(team.getTeamName(), By.id("org-display-name"));
        type(team.getDiscription(), By.id("org-desc"));
    }

    public void submitTeamCreation() {
        click(By.cssSelector("input[value=Create]"));
    }


}
