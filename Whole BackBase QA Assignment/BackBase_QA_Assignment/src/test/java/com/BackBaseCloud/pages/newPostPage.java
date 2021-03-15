package com.BackBaseCloud.pages;

import com.BackBaseCloud.utils.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class newPostPage extends BasePage{


    @FindBy(xpath = "/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-input[1]/fieldset/input")
    private WebElement articleTitleInputBox;


    @FindBy(xpath = "/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-input[2]/fieldset/input")
    private WebElement articleAboutInputBox;

    @FindBy(xpath = "/html/body/app-root/app-article-editor/div/div/div/div/app-dynamic-form/form/app-textarea/fieldset/textarea")
    private WebElement articleDescriptionInputBox;

    @FindBy(xpath = "//input[@class='form-control form-control-lg ng-untouched ng-pristine ng-valid']")
    private WebElement articleTagsInputBox;


    @FindBy(xpath = "//button[.=' Publish Article ']")
    private WebElement publishArticleButton;


    public void enterTitle(String Title){
        articleTitleInputBox.sendKeys(Title);
    }

    public void enterArticleAbout(String articleAbout){
        articleAboutInputBox.sendKeys(articleAbout);
    }
    public void enterArticleDescription(String Description){
        articleDescriptionInputBox.sendKeys(Description);
    }

    public void enterTags(String Tag){
        articleTagsInputBox.sendKeys(Tag);
    }

    public void clickArticleButton(){
        publishArticleButton.click();
    }

}
