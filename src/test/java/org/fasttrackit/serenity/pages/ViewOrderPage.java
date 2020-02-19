package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ViewOrderPage extends PageObject{
    @FindBy(css=".order_item .product-name a")
    private WebElementFacade productName;
    String productNameFromViewOrder;

    public String getProductNameFromViewOrder() {
        return productNameFromViewOrder = productName.getText();
    }
}
