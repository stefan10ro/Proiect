package org.fasttrackit.serenity.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.serenity.pages.AccountPage;
import org.fasttrackit.serenity.pages.HomePage;
import org.fasttrackit.serenity.pages.LoginPage;

public class LoginSteps {
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    @Step
    public void navigateToLoginPage(){
        homePage.open();
        homePage.clickMyAccountLink();
    }

    @Step
    public void performLogin(String email, String password){
        loginPage.setEmailLoginField(email);
        loginPage.setPasswordLoginField(password);
        loginPage.clickLoginButton();

    }
    @Step
    public void checkNotLoggedInInvalidUserName(){
        loginPage.verifyNotLoggedInInvalidUserName();
    }
}