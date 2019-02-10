package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoardHelper extends HelperBase{
    WebDriver wd;

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void selectCreateBoard() {
        click(By.cssSelector("a.js-new-board .sub-name"));
    }

    public void addBoardTitle(String text) {
        type(text, By.cssSelector(".subtle-input"));
    }

    public void clickCreateButton() {
        click(By.cssSelector("button[type='submit']"));
    }
}
