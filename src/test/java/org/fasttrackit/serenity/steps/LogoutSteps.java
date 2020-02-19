package org.fasttrackit.serenity.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrackit.serenity.pages.AccountPage;
import org.fasttrackit.serenity.pages.LoginPage;
import org.junit.Assert;

public class LogoutSteps {
    private AccountPage accountPage;
    private LoginPage loginPage;

    @Step
    public void performLogout(){
        accountPage.clickLogoutLink();
    }

}