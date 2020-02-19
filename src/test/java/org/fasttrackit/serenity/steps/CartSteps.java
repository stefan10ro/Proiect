package org.fasttrackit.serenity.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.serenity.pages.*;
import org.junit.Assert;

public class CartSteps {
    private ShopPage shopPage;
    private SearchPage searchPage;
    private ProductsPage productPage;
    private CartPage cartPage;

    @Step
    public void searchForKeyword(String keyword) {
        shopPage.setSearchField(keyword);
    }
    @Step
    public void chooseFirstProduct(){
        searchPage.clickFirstProductLink();
    }
    @Step
    public void addToCartProduct(){
        productPage.clickAddToCartButton();
    }
    @Step
    public void navigateToCartPage() {
        productPage.clickViewCartButton();
    }

    @Step
    public void checkProductinCart(){
        Assert.assertTrue(cartPage.verifyProductSentToCart());
    }
    @Step
    public void updateProductQuantityInCart(String quantity){
        cartPage.selectQuantity(quantity);
        cartPage.clickUpdateCartButton();
    }

    @Step
    public void checkTotalPrice(String quantity){
        Assert.assertTrue(cartPage.verifyTotalPrice(quantity));
    }

    @Step
    public void removeProduct(){
        cartPage.clickProductRemoveLink();
    }
    @Step
    public void verifyCartIsEmpty(){
        Assert.assertTrue("The product is not removed form the cart",cartPage.checkCartEmpty());
    }

}