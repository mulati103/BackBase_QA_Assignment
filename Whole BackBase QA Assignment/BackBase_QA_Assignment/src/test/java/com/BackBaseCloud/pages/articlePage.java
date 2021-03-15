package com.BackBaseCloud.pages;

import com.BackBaseCloud.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class articlePage extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement articleTitle;

    public String getArticleTitle(){

       return articleTitle.getText();
    }
}
