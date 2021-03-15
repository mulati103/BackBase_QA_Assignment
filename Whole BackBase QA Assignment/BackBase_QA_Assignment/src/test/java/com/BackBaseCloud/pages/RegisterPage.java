package com.BackBaseCloud.pages;

import com.BackBaseCloud.utils.BrowserUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    @FindBy(xpath="(//a[.='BBlog'])[1]")
    private WebElement BBlogUpperLink;


    @FindBy(xpath="//a[text()='Have an account?']")
    private WebElement HaveAnAccountLink;

    @FindBy(xpath = "//input[@class='form-control form-control-lg ng-untouched ng-pristine ng-invalid']")
    private WebElement username;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailAccount;

    @FindBy(xpath="//input[@placeholder='Password']")
    private WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement signupButton;

    @FindBy(xpath="(//a[.='BBlog'])[2]")
    private WebElement BBlogLowerLink;

    public void clickSignUpButton(){
        SignupLink.click();
        BrowserUtils.wait(2);
    }

    Faker faker = new Faker();
    String usernameValue = faker.name().firstName();

    String emailValue = faker.internet().safeEmailAddress();
    String passwordValue = faker.name().firstName();

    public void signUp() {
        System.out.println(usernameValue);
        System.out.println(passwordValue);
        System.out.println(emailValue);

        username.sendKeys(usernameValue);
        BrowserUtils.wait(2);

        emailAccount.sendKeys(emailValue);
        BrowserUtils.wait(2);

        password.sendKeys(passwordValue);//Keys.ENTER will be equal click on login button
        BrowserUtils.wait(2);

        signupButton.click();
    }


}
