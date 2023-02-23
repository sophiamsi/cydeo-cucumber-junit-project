Feature: Google search functionality
  Agile story: As user, when I am on the google search page. I should be able to search anything
  and see relevant results

  Scenario: Search page title verification
    When user is on the Google search page
    Then user should see title is Google

  Scenario: Search result title verification
    Given user is on the Google search page
    When user searches for apple
    Then user should see apple in the title