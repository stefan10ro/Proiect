package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa4.fasttrackit.org:8008/")
public class AccountPage extends PageObject {
    @FindBy(css="#post-120 > div > div > div > p:nth-child(1) > strong:nth-child(2)")
    private WebElementFacade helloText;
    @FindBy(css="#post-120 > div > div > div > p:nth-child(1) > a")
    private WebElementFacade logoutLink;
    @FindBy(css="#post-120 > div > div > div > p:nth-child(2) > a:nth-child(1)li a[href*='orders']")
    private WebElementFacade ordersLink;


    public void clickLogoutLink(){
        clickOn(logoutLink);
    }
    public void clickOrdersLink(){
        clickOn(ordersLink);
    }

}