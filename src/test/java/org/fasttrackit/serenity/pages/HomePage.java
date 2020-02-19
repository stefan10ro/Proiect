package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa4.fasttrackit.org:8008/")
public class HomePage extends PageObject {
    @FindBy(css="#menu-item-122 > a")
    private WebElementFacade myAccountLink;
    @FindBy(css="#menu-item-123 > a")
    private WebElementFacade shopLink;
    @FindBy(css="#masthead > div > div > div > div > div.header-icons-wrap > div.header-search.header-search-open > div.header-search-input > form > input.search-field")
    private WebElementFacade searchFieldLink;

    public void clickMyAccountLink(){
        clickOn(myAccountLink);
    }

    public void clickShopLink(){
        clickOn(shopLink);
    }

    public void clickSearchFieldLink() { clickOn(searchFieldLink);}

}