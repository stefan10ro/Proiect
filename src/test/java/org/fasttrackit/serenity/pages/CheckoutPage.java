package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.ui.Select;

@DefaultUrl("http://qa1.fasttrackit.org:8008/checkout/")
public class CheckoutPage extends PageObject {
    @FindBy(id="billing_first_name")
    private WebElementFacade firstNameField;
    @FindBy(id="billing_last_name")
    private WebElementFacade lastNameField;
    @FindBy(id="billing_country")
    private WebElementFacade countryDropDownList;
    @FindBy(id="billing_address_1")
    private WebElementFacade streetField;
    @FindBy(id="billing_city")
    private WebElementFacade cityField;
    @FindBy(id="billing_state")
    private WebElementFacade countyDropDownList;
    @FindBy(id="billing_postcode")
    private WebElementFacade postcodeField;
    @FindBy(id="billing_phone")
    private WebElementFacade phoneField;
    @FindBy(id="billing_email")
    private WebElementFacade emailField;
    @FindBy(css=".form-row.place-order .button")
    private WebElementFacade placeOrderButton;

    public void setFirstNameField(String firstName){
        typeInto(firstNameField, firstName);
    }
    public void setLastNameField(String lastName){
        typeInto(lastNameField, lastName);
    }
    public void selectCountry(String country){
        selectFromDropdown(countryDropDownList, country);
    }
    public void setStreetField(String street){
        typeInto(streetField,street);
    }
    public void setCityField(String city){
        typeInto(cityField, city);
    }
    public void selectCounty(String county){
        selectFromDropdown(countyDropDownList,county);
    }
    public void setPostcodeField(String postcode){
        typeInto(postcodeField, postcode);
    }
    public void setPhoneField(String phone){
        typeInto(phoneField, phone);
    }
    public void setEmailField(String email){
        typeInto(emailField, email);
    }
    public void clickPlaceOrderButton() {
        waitABit(3000);
        clickOn(placeOrderButton);
    }

}