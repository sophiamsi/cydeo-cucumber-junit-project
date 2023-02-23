@smoke
  Feature: Log out Function
Scenario: User can log out and ends up in login page
Given the user is logged in
And the user clicks the avatar icon
And the user clicks the logout label
Then the user should see the url "http://qa.seamlessly.net/index.php/login"

    Scenario: User can not go to home page again by clicking step back button after successfully logged out.
      Given the user is logged in
      And the user clicks the avatar icon
      And the user clicks the logout label
      Then the user should see the url "http://qa.seamlessly.net/index.php/login"
      When the user clicks step back button
      Then the user should see the url "http://qa.seamlessly.net/index.php/login"