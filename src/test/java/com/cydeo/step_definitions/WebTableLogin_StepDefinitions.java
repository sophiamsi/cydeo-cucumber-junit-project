package com.cydeo.step_definitions;

import com.cydeo.pages.WT_LoginPage;
import com.cydeo.pages.WT_OrderPage;
import com.cydeo.pages.WT_ViewAllOrdersPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

public class WebTableLogin_StepDefinitions {
    WT_LoginPage wt_loginPage =new WT_LoginPage();
    @Given("user is on the Web Table app login page")
    public void user_is_on_the_web_table_app_login_page() {
        Driver.getDriver().get("https://web-table-2.cydeo.com/login");
    }

    @When("user enters correct username")
    public void user_enters_correct_username() {
wt_loginPage.inputUserName.sendKeys("Test");

    }
    @When("user enters correct password")
    public void user_enters_correct_password() {
wt_loginPage.inputPassword.sendKeys("Tester");

    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
wt_loginPage.loginButton.click();
    }
    @Then("user should see orders word in the URL")
    public void user_should_see_orders_word_in_the_url() {
String actualURL=Driver.getDriver().getCurrentUrl();
String expectedInURL ="orders";
        Assert.assertTrue(actualURL.contains(expectedInURL));
    }


    @When("user enters {string} username and {string} password")
    public void userEntersUsernameAndPassword(String username, String password) {
        wt_loginPage.inputUserName.sendKeys(username);
        wt_loginPage.inputPassword.sendKeys(password);
    }

    @When("user enters below correct credentials")
    public void user_enters_below_correct_credentials(Map<String,String>credential) {
 wt_loginPage.inputUserName.sendKeys( credential.get("username"));
  wt_loginPage.inputPassword.sendKeys(credential.get("password"));

    }

    @Given("user is already logged in to The Web table app")
    public void user_is_already_logged_in_to_the_web_table_app() {
Driver.getDriver().get("https://web-table-2.cydeo.com/login");
        wt_loginPage.login();
    }

  WT_OrderPage orderPage =new WT_OrderPage();
    @When("user is on the “Order” page")
    public void user_is_on_the_order_page() {

orderPage.ordersLink.click();
    }
    @Then("user sees below options under “product” dropdown")
    public void user_sees_below_options_under_product_dropdown(List<String>expectedOptions) {
List<String> actualOptions=BrowserUtils.dropdownOptions_as_STRING(orderPage.productDropdown);
Assert.assertEquals(actualOptions,expectedOptions);
    }


    @Then("user sees Visa an enabled payment option")
    public void userSeesVISAAnEnabledPaymentOption() {
        Assert.assertTrue(orderPage.visaRadioButton.isEnabled());

    }

    @Then("user sees MasterCard an enabled payment option")
    public void userSeesMasterCardAnEnabledPaymentOption() {
        Assert.assertTrue(orderPage.masterCardRadioButton.isEnabled());

    }

    @Then("user sees American Express an enabled payment option")
    public void userSeesAmericanExpressAnEnabledPaymentOption() {
        Assert.assertTrue(orderPage.americanExpressRadioButton.isEnabled());
    }


    @And("user enters quantity {string}")
    public void userEntersQuantity(String quantity) {
        orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);
        orderPage.inputQuantity.sendKeys("2");
    }

    @Then("user clicks to the calculate button")
    public void userClicksToTheCalculateButton() {
        orderPage.calculateButton.click();
    }

    @And("user enters customer name {string}")
    public void userEntersCustomerName(String fullName) {
        orderPage.inputName.sendKeys(fullName);
        BrowserUtils.sleep(2);
    }



    @And("user enters street {string}")
    public void userEntersStreet(String street) {
        orderPage.inputStreet.sendKeys(street);
    }

    @And("user enters city {string}")
    public void userEntersCity(String city) {
        orderPage.inputCity.sendKeys(city);
        BrowserUtils.sleep(3);
    }

    @And("user enters state {string}")
    public void userEntersState(String state) {
        orderPage.inputState.sendKeys(state);
    }

    @And("user enters zip {string}")
    public void userEntersZip(String zip) {
        orderPage.inputZip.sendKeys(zip);

    }

    @And("user selects payment option {string}")
    public void userSelectsPaymentOption(String expectedCardType) {
        BrowserUtils.clickRadioButton(orderPage.cardTypes,expectedCardType);
    }

    @And("user enters credit card number {string}")
    public void userEntersCreditCardNumber(String cardNumber) {
        orderPage.inputCreditCard.sendKeys(cardNumber);
    }

    @And("user enters expiration date {string}")
    public void userEntersExpirationDate(String expDate) {
        orderPage.inputExpirationDate.sendKeys(expDate);
    }

    @And("user clicks to process order button")
    public void userClicksToProcessOrderButton() {
        BrowserUtils.sleep(2);
        orderPage.processOrderButton.click();
    }

WT_ViewAllOrdersPage wt_viewAllOrdersPage = new WT_ViewAllOrdersPage();
    @Then("user should see {string} in the first row of the web table")
    public void userShouldSeeInTheFirstRowOfTheWebTable(String expectedName) {
String actualName = wt_viewAllOrdersPage.newCustomerCell.getText();
Assert.assertEquals(actualName,expectedName);

    }
}
