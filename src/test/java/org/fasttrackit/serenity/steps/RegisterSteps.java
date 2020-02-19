package org.fasttrackit.serenity.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.serenity.pages.HomePage;
import org.fasttrackit.serenity.pages.RegisterPage;
import org.junit.Assert;

public class RegisterSteps {
    private HomePage homePage;
    private RegisterPage registerPage;

    @Step
    public void navigateToRegisterPage(){
        homePage.open();
        homePage.clickMyAccountLink();
    }

    @Step
    public void performRegister(String email, String password){
        registerPage.setEmailField(email);
        registerPage.setPasswordField(password);
        registerPage.clickRegisterButton();
    }

    @Step
    public void checkNotRegisterTwiceSameEmail(){
        registerPage.verifyNotRegisterTwiceSameEmail();
    }


}