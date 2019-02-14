package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardHelper extends HelperBase {
    WebDriver wd;

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void clickTheCreateNewBoardOnTheEndOfList() {
        WebElement personalBoards = wd.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
        int boardsCount = personalBoards.findElements(By.xpath(".//*[@class='boards-page-board-section-list-item']")).size();
        personalBoards.findElement(By.xpath(".//*[@class='boards-page-board-section-list-item'][" + (boardsCount) + "]")).click();
    }

    public int PersonalBoardsCount() {
        WebElement personalBoards = wd.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
        return personalBoards.findElements(By.xpath(".//*[@class='boards-page-board-section-list-item']")).size() - 1;
    }

    public void addBoardTitle(String boardName) throws InterruptedException {
        type(boardName, By.cssSelector("input.subtle-input"));
        click(By.xpath("//*[@class='subtle-chooser-trigger unstyled-button org-chooser-trigger']"));
        click(By.xpath("//ul[@class='pop-over-list org-chooser']//li[last()]"));
        Thread.sleep(3000);
        click(By.xpath("//button[contains(text(),'Team Visible')]"));
        click(By.xpath("//span[contains(text(),'Public')]"));
        click(By.xpath("//input[@value='Yes, Make Board Public']"));

    }

    public void clickTheCreateButton() {
        click(By.cssSelector("[type=submit]"));
    }

//    public void selectCreateBoard() {
//        click(By.cssSelector(".js-new-board"));
//    }


    public void selectCreateBoard() {
        click(By.cssSelector("a.js-new-board .sub-name"));
    }

//    public void addBoardTitle(String text) {
//        type(text, By.cssSelector(".subtle-input"));
//    }

    public void clickCreateButton() {
        click(By.cssSelector("button[type='submit']"));
    }


    public void selectBoard() {
        WebElement personalBoards = wd.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
        int boardsCount = personalBoards.findElements(By.xpath(".//*[@class='boards-page-board-section-list-item']")).size()-1;
        personalBoards.findElement(By.xpath(".//*[@class='boards-page-board-section-list-item'][" + (boardsCount) + "]")).click();
    }

    public void clickMoreButton() {
        click(By.cssSelector(".js-open-more"));
    }

    public void clickCloseBoard() {
        click(By.cssSelector(".js-close-board"));
    }

    public void confirmCloseBoard() {
        click(By.cssSelector(".js-confirm[value='Close']"));
    }
}
