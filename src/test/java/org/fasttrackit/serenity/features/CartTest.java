package org.fasttrackit.serenity.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.serenity.steps.CartSteps;
import org.fasttrackit.serenity.steps.ShopSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CartTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @Steps
    private ShopSteps shopSteps;
    @Steps
    private CartSteps cartSteps;

    private String keyword="#azera_shop_id_dAOLs4gAzd > div.azera_shop_grid_col_4.azera_shop_grid_column_4.azera_shop_grid_last > li.post-58.product.type-product.status-publish.has-post-thumbnail.product_cat-accessories-clothing.last.instock.sale.taxable.shipping-taxable.purchasable.product-type-simple > a.woocommerce-LoopProduct-link.woocommerce-loop-product__link > h2";
    private String quantity="5";

    @Test
    public void addProductToCartTest(){
        shopSteps.navigateToShopPage();
        cartSteps.searchForKeyword(keyword);
        cartSteps.chooseFirstProduct();
        cartSteps.addToCartProduct();
        cartSteps.navigateToCartPage();
        cartSteps.checkProductinCart();
    }
    @Test
    public void removeTheProductFromCartTest(){
        shopSteps.navigateToShopPage();
        cartSteps.searchForKeyword(keyword);
        cartSteps.chooseFirstProduct();
        cartSteps.addToCartProduct();
        cartSteps.navigateToCartPage();
        cartSteps.checkProductinCart();
        cartSteps.removeProduct();
        cartSteps.verifyCartIsEmpty();

    }
    @Test
    public void verifyTotalPriceCalculationTest(){
        shopSteps.navigateToShopPage();
        shopSteps.addProductToCart();
        shopSteps.navigateToCartPage();
        cartSteps.updateProductQuantityInCart(quantity);
        cartSteps.checkTotalPrice(quantity);
    }


}