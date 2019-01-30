import org.testng.annotations.Test;

public class HW3_WikipediaAddArticleGamesOfThrone extends TestBaseWikipedia{

    @Test
    public void test(){
        openSite("https://www.wikipedia.org/");
        changeLanguage();
        clickOnLoginButton();
        fillLoginForm("oropennyv4110", "oropennyv");
        clickConfirmButton();
        search("Game of Thrones");
        addToWatchlist();
    }

}
