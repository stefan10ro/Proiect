package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://qa4.fasttrackit.org:8008/?page_id=118")
public class CartPage extends PageObject {
    @FindBy(css=".checkout-button")
    private WebElementFacade proceedToCheckoutButton;
    @FindBy(css=".cart tbody tr:first-child")
    private WebElementFacade productInCart;
    @FindBy(css=".cart tbody tr:first-child .product-price>span")
    private WebElementFacade productPrice;
    @FindBy(css=".cart tbody tr:first-child .product-quantity input")
    private WebElementFacade productQuantity;
    @FindBy(css=".cart tbody tr:first-child .product-subtotal>span")
    private WebElementFacade productTotalPrice;
    @FindBy(css="button[name*='update']")
    private WebElementFacade updateCartButton;
    @FindBy(css=".product-remove a")
    private WebElementFacade productRemoveLink;
    @FindBy(css=".cart-empty")
    private WebElementFacade cartEmptyText;
    private int productPriceInt;
    private int productTotalPriceInt;

    public boolean verifyProductSentToCart(){
        return proceedToCheckoutButton.isClickable();

    }
    public void clickProceedToCheckoutButton(){
        clickOn(proceedToCheckoutButton);
    }

    public void selectQuantity(String quantity){
        typeInto(productQuantity,quantity);
    }
    public void clickUpdateCartButton() {
        clickOn(updateCartButton);
    }

    public int getProductPriceInt() {
        for (int i = 0; i < productPrice.getText().length(); i++) {
            if (productPrice.getText().charAt(i) == ',') {
                productPriceInt = Integer.valueOf(productPrice.getText().substring(0, i - 1));
            }
        }
        return productPriceInt;
    }
    public int getProductTotalPriceInt() {
        for (int i = 0; i < productTotalPrice.getText().length(); i++) {
            if (productTotalPrice.getText().charAt(i) == ',') {
                productTotalPriceInt = Integer.valueOf(productTotalPrice.getText().substring(0, i - 1));
            }
        }
        return productTotalPriceInt;
    }


    public boolean verifyTotalPrice(String quantity){
        if(productPriceInt*Integer.valueOf(quantity)==productTotalPriceInt) {
            return true;
        }
        else return false;
    }

    public void clickProductRemoveLink(){
        clickOn(productRemoveLink);
    }
    public boolean checkCartEmpty(){
        return cartEmptyText.containsOnlyText("Your cart is currently empty.");
    }
}