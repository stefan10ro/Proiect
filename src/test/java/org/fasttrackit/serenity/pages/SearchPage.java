package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchPage extends PageObject {
    @FindBy(css="#product-58 > div.summary.entry-summary > h1")
    private WebElementFacade searchResultsMessage;
    @FindBy(css="#primary > p")
    private WebElementFacade nothingFoundSearchResultMessage;
    @FindBy(css="article:nth-child(2) h1 a")
    private WebElementFacade firstProduct;


    public void verifySearchResultsMessage(String keyword){
        searchResultsMessage.shouldContainText("Search Results for: "+ keyword);
    }
    public boolean verifyNothingFoundSearchResultMessage(){
        return nothingFoundSearchResultMessage.containsOnlyText("No products were found matching your selection. " +
                "Please try again with some different keywords.");
    }
    public void clickFirstProductLink(){
        clickOn(firstProduct);
    }

}