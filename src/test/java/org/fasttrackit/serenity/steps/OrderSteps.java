package org.fasttrackit.serenity.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.matchers.dates.DateMatchers;
import org.fasttrackit.serenity.pages.*;
import org.junit.Assert;

public class OrderSteps extends DateMatchers {
    private HomePage homePage;
    private AccountPage accountPage;
    private OrderPages ordersPage;
    private ViewOrderPage viewOrderPage;
    private OrderRecivedPage orderReceivedPage;

    @Step
    public void navigateToMyAccountPage(){
        homePage.clickMyAccountLink();
    }
    @Step
    public void navigateToOrdersPage(){
        accountPage.clickOrdersLink();
    }

    @Step
    public void navigateToViewOrderPage(){
        ordersPage.clickViewOrderButton();
    }
    @Step
    public void compareProductName(){
        Assert.assertTrue(orderReceivedPage.getProductNameFromOrderReceived().equals(viewOrderPage.getProductNameFromViewOrder()));
    }
}
