package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa4.fasttrackit.org:8008/?page_id=120&orders")
public class OrderPages extends PageObject {

    @FindBy(css="#post-120 > div > div > div > table > tbody > tr > td.woocommerce-orders-table__cell.woocommerce-orders-table__cell-order-actions > a")
    private WebElementFacade viewOrderButton;
    @FindBy(css="#post-120 > div > div > div > section.woocommerce-order-details > table > tbody > tr > td.woocommerce-table__product-name.product-name > a")
    private WebElementFacade productName;

    String productNameFromViewOrder;

    public String getProductNameFromViewOrder() {
        return productNameFromViewOrder = productName.getText();
    }
    public void clickViewOrderButton(){
        clickOn(viewOrderButton);
    }
}
