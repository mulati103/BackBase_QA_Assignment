@register
Feature:As an user, I should be able to sign up with correct credentials and homepage should be displayed

  Background:
    Given user is on the Home page

  Scenario:when user login with valid credential, user should be able to homepage is displayed
    When user clicks on Sign up button
    And user logs in with valid credentials
    Then user should see "BBlog" homepage is displayed





