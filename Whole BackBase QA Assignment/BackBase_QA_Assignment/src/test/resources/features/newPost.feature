Feature: As an authorized user, I should be able to create new Post on the editor page

  @add_new_post
  Scenario: 1.Add new Post
    Given user is on the Home page
    When user clicks "Sign in" link
    And user logs in with valid username and password
    And user clicks on New Post Link
    And user enters Article Information
      | Title       | Great History of Our Country                             |
      | About       | History                                                  |
      | Description | our country is built in 1990, it is a very great country |
      | Tags        | important                                                |
    And user click on public article button
    Then user should see "Great History of Our Country" as article title


