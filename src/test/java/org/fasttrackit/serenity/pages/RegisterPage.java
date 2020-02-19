package org.fasttrackit.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa1.fasttrackit.org:8008/my-account/")
public class RegisterPage extends PageObject {
    @FindBy(id="reg_email")
    private WebElementFacade emailField;
    @FindBy(id="reg_password")
    private WebElementFacade passwordField;
    @FindBy(css=".woocommerce-FormRow .woocommerce-Button.button")
    private WebElementFacade registerButton;
    @FindBy(css="a[href*='action=register']")
    private WebElementFacade registerLink;
    @FindBy(css=".woocommerce-error li")
    private WebElementFacade errorMessageRegisterSameEmail;

    public void setEmailField(String email){
        typeInto(emailField, email);
    }
    public void setPasswordField(String password){
        typeInto(passwordField, password);
    }
    public void clickRegisterButton(){
        clickOn(registerButton);
    }
    public void verifyNotRegisterTwiceSameEmail(){
        errorMessageRegisterSameEmail.shouldContainText("Error: An account is already registered with your email address. Please log in.");
    }

}