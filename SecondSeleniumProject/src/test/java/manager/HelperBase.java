package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(String text, By locator) {
        if (text != null) {
            click(locator);
            clear(locator);
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void clear(By locator) {
        wd.findElement(locator).clear();
    }

    public boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
