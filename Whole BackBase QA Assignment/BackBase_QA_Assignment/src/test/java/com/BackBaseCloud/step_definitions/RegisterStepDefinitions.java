package com.BackBaseCloud.step_definitions;

import com.BackBaseCloud.pages.RegisterPage;
import com.BackBaseCloud.utils.BrowserUtils;
import com.BackBaseCloud.utils.ConfigurationReader;
import com.BackBaseCloud.utils.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.List;

public class RegisterStepDefinitions {


    RegisterPage registerPage = new RegisterPage();

    @Given("user is on the Home page")
    public void userIsOnTheHomePage() {

     Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user clicks on Sign up button")
    public void userClicksOnSignUpButton() {

        registerPage.clickSignUpButton();
    }


    @And("user logs in with valid credentials")
    public void userLogsInWithValidCredentials() {

      registerPage.signUp();

    }

    @Then("user should see {string} homepage is displayed")
    public void user_should_see_homepage_is_displayed(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}
