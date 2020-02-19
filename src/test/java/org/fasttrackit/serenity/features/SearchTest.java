package org.fasttrackit.serenity.features;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.serenity.steps.SearchSteps;
import org.fasttrackit.serenity.steps.ShopSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class SearchTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }
    @Steps
    private ShopSteps shopSteps;
    @Steps
    private SearchSteps searchSteps;

    private String keyword="Belt";

    @Test
    public void searchForAValidKeywordTest(){
        shopSteps.navigateToShopPage();
        searchSteps.searchForKeyword(keyword);
        searchSteps.checkSearchResultMessage(keyword);
    }
    @Test
    public void searchForANonValidKeywordTest(){
        shopSteps.navigateToShopPage();
        searchSteps.searchForKeyword(keyword);
        searchSteps.checkNothingFoundSearchResultMessage();
    }

}