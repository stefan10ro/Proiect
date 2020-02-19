package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa4.fasttrackit.org:8008/?product=belt")
public class ProductsPage extends PageObject{
    @FindBy(css="#product-58 > div.summary.entry-summary > form > button")
    private WebElementFacade addToCartButton;
    @FindBy(css="#masthead > div > div > div > div > div.header-icons-wrap > div.navbar-cart-inner > a > span.fa.fa-shopping-cart")
    private WebElementFacade viewCartButton;

    public void clickAddToCartButton(){
        clickOn(addToCartButton);
    }
    public void clickViewCartButton(){
        clickOn(viewCartButton);
    }
}
