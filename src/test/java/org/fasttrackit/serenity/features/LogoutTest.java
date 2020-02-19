package org.fasttrackit.serenity.features;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.serenity.steps.LoginSteps;
import org.fasttrackit.serenity.steps.LogoutSteps;
import org.fasttrackit.serenity.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LogoutTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    @Steps
    private LoginSteps loginSteps;
    @Steps
    private LogoutSteps logoutSteps;

    @Test
    public void logoutTest(){
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        logoutSteps.performLogout();
    }

}