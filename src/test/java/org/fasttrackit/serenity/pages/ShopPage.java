package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

import java.util.List;

@DefaultUrl("http://qa4.fasttrackit.org:8008/?post_type=product")
public class ShopPage extends PageObject {
    @FindBy(css = "#masthead > div > div > div > div > div.header-icons-wrap > div.header-search.header-search-open")
    private WebElementFacade searchField;
    @FindBy(css="#primary")
    private List<WebElementFacade> listOfProducts;
    @FindBy(css="#primary > nav.woocommerce-pagination > ul > li:nth-child(3) > a")
    private WebElementFacade nextPageLink;
    @FindBy(css=".products li:first-child .add_to_cart_button")
    private WebElementFacade firstProductAddToCartButton;
    @FindBy(css="#menu-item-124 > a")
    private WebElementFacade viewShoppingCartLink;

    private int count=0;

    public void setSearchField (String keyword){
        searchField.typeAndEnter(keyword);
    }

    public boolean verifyAddToCartButtonsAreVisible() {
        do {
            for (WebElementFacade product : listOfProducts) {
                if (!product.findElement(By.cssSelector("a:nth-child(2)")).getText().equals("Add to cart")) {
                    count += 1;
                }
            }
            clickOn(nextPageLink);
        }
        while (nextPageLink.isVisible()) ;
        return count==0;
    }
    public void clickAddToCartButtonFirstProduct(){
        clickOn(firstProductAddToCartButton);
    }
    public void clickViewShoppingCartLink(){
        waitABit(5000);
        clickOn(viewShoppingCartLink);
    }

}