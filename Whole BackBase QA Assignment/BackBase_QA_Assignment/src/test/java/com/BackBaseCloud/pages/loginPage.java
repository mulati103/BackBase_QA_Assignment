package com.BackBaseCloud.pages;

import com.BackBaseCloud.utils.BrowserUtils;
import com.BackBaseCloud.utils.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage{


    @FindBy(xpath = "(//input[@class='form-control form-control-lg ng-untouched ng-pristine ng-invalid'])[1]")
    private WebElement usernameInput;


    @FindBy(xpath = "/html/body/app-root/app-login/div/div/div/div/app-dynamic-form/form/app-input[2]/fieldset/input")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[.=' Sign in ']")
    private WebElement signInButton;

    public void login() {

        String usernameValue = ConfigurationReader.getProperty("username");
        String passwordValue = ConfigurationReader.getProperty("password");

        usernameInput.sendKeys(usernameValue);
        BrowserUtils.wait(1);

        passwordInput.sendKeys(passwordValue);
        BrowserUtils.wait(1);

       signInButton.click();

    }

}
