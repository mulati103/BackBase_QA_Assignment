package com.BackBaseCloud.step_definitions;

import com.BackBaseCloud.pages.HomePage;
import com.BackBaseCloud.pages.articlePage;
import com.BackBaseCloud.pages.loginPage;
import com.BackBaseCloud.pages.newPostPage;
import com.BackBaseCloud.utils.BrowserUtils;
import com.BackBaseCloud.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import sun.java2d.pipe.DrawImage;

import java.util.Map;

public class newPostStepDefinitions {

    newPostPage newPostPage = new newPostPage();
    loginPage loginPage = new loginPage();
    HomePage homePage = new HomePage();
    articlePage articlePage = new articlePage();

    @When("user clicks {string} link")
    public void user_clicks_link(String string) {
     homePage.clicksSignInButton();
    }

    @When("user logs in with valid username and password")
    public void user_logs_in_with_valid_username_and_password() {
      loginPage.login();

    }
    @When("user clicks on New Post Link")
    public void user_clicks_on_new_post_link() {

        homePage.clickNewPostLink();

    }
    @When("user enters Article Information")
    public void user_enters_article_information(Map<String , String> dataTable) {

        String articleTitle = dataTable.get("Title");
        String articleAbout = dataTable.get("About");
        String articleDescription = dataTable.get("Description");
        String articleTags = dataTable.get("Tags");

        newPostPage.enterTitle(articleTitle);
        BrowserUtils.wait(2);
        newPostPage.enterArticleAbout(articleAbout);
        BrowserUtils.wait(2);
        newPostPage.enterArticleDescription(articleDescription);
        BrowserUtils.wait(2);
        newPostPage.enterTags(articleTags);
        BrowserUtils.wait(2);

    }
    @When("user click on public article button")
    public void user_click_on_public_article_button() {
        newPostPage.clickArticleButton();
    }


    @Then("user should see {string} as article title")
    public void userShouldSeeAsArticleTitle(String expectedTitle) {

        String actualTitle = articlePage.getArticleTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
