package org.fasttrackit.serenity.features;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.serenity.steps.CartSteps;
import org.fasttrackit.serenity.steps.CheckoutSteps;
import org.fasttrackit.serenity.steps.LoginSteps;
import org.fasttrackit.serenity.steps.OrderSteps;
import org.fasttrackit.serenity.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class OrderTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @Steps
    private LoginSteps loginSteps;
    @Steps
    private CartSteps cartSteps;
    @Steps
    private CheckoutSteps checkoutSteps;
    @Steps
    private OrderSteps ordersSteps;

    @Test
    public void productOrderSavedInOrdersPageTest(){
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        String keyword = "Belt";
        cartSteps.searchForKeyword(keyword);
        cartSteps.chooseFirstProduct();
        cartSteps.addToCartProduct();
        cartSteps.navigateToCartPage();
        checkoutSteps.placeOrderProduct(Constants.FIRST_NAME, Constants.LAST_NAME,Constants.COUNTRY,
                Constants.STREET_ADDRESS, Constants.TOWN, Constants.COUNTY, Constants.POSTCODE,
                Constants.PHONE, Constants.USER_EMAIL);

        checkoutSteps.verifyProductPlacedInOrder();
        ordersSteps.navigateToMyAccountPage();
        ordersSteps.navigateToOrdersPage();
        ordersSteps.navigateToViewOrderPage();
        ordersSteps.compareProductName();
    }

}