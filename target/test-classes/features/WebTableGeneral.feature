Feature:Some of the general functionality verification

  Scenario: Dropdown options verification
  Given user is already logged in to The Web table app
  When user is on the “Order” page
   Then user sees below options under “product” dropdown
  | MoneyCog|
  |Familybea|
  |Screenable|
Scenario: Payment options verification
  Given user is already logged in to The Web table app
  When user is on the “Order” page
  Then user sees Visa an enabled payment option
  Then user sees MasterCard an enabled payment option
  Then user sees American Express an enabled payment option


  Scenario: Order placement scenario
    Given user is already logged in to The Web table app
    When user is on the “Order” page
    And user enters quantity "2"
    Then user clicks to the calculate button
    And user enters customer name "Taras Bulba"
    And user enters street "Pecherska"
    And user enters city "Chicago"
    And user enters state "Illinois"
    And user enters zip "60089"
    And user selects payment option "Visa"
    And user enters credit card number "0811197652238744"
    And user enters expiration date "12/29"
    And user clicks to process order button
    Then user should see "Taras Bulba" in the first row of the web table
@wip
  Scenario Outline: Order placement scenario
    Given user is already logged in to The Web table app
    When user is on the “Order” page
    And user enters quantity "<quantity>"
    Then user clicks to the calculate button
    And user enters customer name "<customerName>"
    And user enters street "<street>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zip "<zip>"
    And user selects payment option "<paymentType>"
    And user enters credit card number "<cardNumber>"
    And user enters expiration date "<expDate>"
    And user clicks to process order button
    Then user should see "<expectedName>" in the first row of the web table

    Examples:

      | quantity | customerName | street | city | state | zip   | paymentType | cardNumber       | expDate | expectedName |
      | 3        | John Doe     | 7th st | NY   | NY    | 99999 | Visa        | 1111222233334444 | 12/25   | John Doe     |
      | 3        | Jane Doe     | 7th st | NY   | NY    | 99999 | Visa        | 1111222233334444 | 12/25   | Jane Doe     |
     # | 3        | Jack Doe     | 7th st | NY   | NY    | 99999 | Visa        | 1111222233334444 | 12/25   | Jack Doe     |
      #| 3        | Jen Doe      | 7th st | NY   | NY    | 99999 | Visa        | 1111222233334444 | 12/25   | Jen Doe      |
      #| 3        | Mike Doe     | 7th st | NY   | NY    | 99999 | Visa        | 1111222233334444 | 12/25   | Mike Doe     |
      #| 3        | Mary Doe     | 7th st | NY   | NY    | 99999 | Visa        | 1111222233334444 | 12/25   | Mary Doe     |



