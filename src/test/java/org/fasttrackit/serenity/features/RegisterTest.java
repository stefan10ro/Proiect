package org.fasttrackit.serenity.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrackit.serenity.steps.RegisterSteps;
import org.fasttrackit.serenity.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class RegisterTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    @Steps
    private RegisterSteps registerSteps;

    @Test
    public void validRegister(){
        registerSteps.navigateToRegisterPage();
        registerSteps.performRegister(Constants.USER_EMAIL, Constants.USER_PASSWORD);
    }

    @Test
    public void registerTwiceWithTheSameEmailTest() {
        registerSteps.navigateToRegisterPage();
        registerSteps.performRegister(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        registerSteps.checkNotRegisterTwiceSameEmail();
    }
}