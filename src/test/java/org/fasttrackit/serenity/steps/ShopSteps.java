package org.fasttrackit.serenity.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.serenity.pages.HomePage;
import org.fasttrackit.serenity.pages.ShopPage;
import org.junit.Assert;

public class ShopSteps {
    private HomePage homePage;
    private ShopPage shopPage;

    @Step
    public void navigateToShopPage(){
        homePage.open();
        homePage.clickShopLink();

    }
    @Step
    public void addProductToCart(){
        shopPage.clickAddToCartButtonFirstProduct();
    }
    @Step
    public void navigateToCartPage(){
        shopPage.clickViewShoppingCartLink();
    }



}
