package com.BackBaseCloud.pages;

import com.BackBaseCloud.utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "(//a[@class='nav-link'])[1]")
    private WebElement actualUserNameLink;


    @FindBy(xpath = "//a[@class='nav-link' and @ routerlink='/editor']")
    private WebElement newPostLink;

    public void clickNewPostLink(){
        newPostLink.click();
        BrowserUtils.wait(1);
    }

    public void clicksSignInButton(){
        SignInLink.click();
        BrowserUtils.wait(2);
    }


}
