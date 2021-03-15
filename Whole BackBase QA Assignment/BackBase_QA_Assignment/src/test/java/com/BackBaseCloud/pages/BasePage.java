package com.BackBaseCloud.pages;

import com.BackBaseCloud.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    @FindBy(xpath="//a[.='Home']")
    protected WebElement HomeLink;

    @FindBy(xpath="//a[@class='nav-link' and @routerlink='/login']")
    protected WebElement SignInLink;

    @FindBy(xpath="//a[text()='Sign up']")
    protected WebElement SignupLink;

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void navigateTo(String LinkName) {

          String tabXpath = "//a[.='" + LinkName + "']";
          Driver.getDriver().findElement(By.xpath(tabXpath)).click();

    }
    //url=https://candidatex:qa-is-cool@qa-task.backbasecloud.com
}
