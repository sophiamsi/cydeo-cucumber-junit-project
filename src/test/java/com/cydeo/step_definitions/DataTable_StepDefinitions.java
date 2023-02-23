package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTable_StepDefinitions {

   /* @Then("user should see below list")
    public void user_should_see_below_list(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }*/

    @Then("user should see below list")
    public void user_should_see_below_list(List<String>fruitsAndVegetables) {
        System.out.println("fruitsAndVegetables = " + fruitsAndVegetables);
    }

    @Then("user should see below list of likedPets")
    public void userShouldSeeBelowListOfLikedPets(List<String> pets) {
        System.out.println("pets = " + pets);
    }

    @Then("officer is able to see any data he wants")
    public void officer_is_able_to_see_any_data_he_wants(Map<String,String>driverInfo) {
        System.out.println("driverInfo = " + driverInfo);
    }
    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }
    DropdownsPage dropdownsPage = new DropdownsPage();
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String>expectedMonths) {
      /*  Select month = new Select(dropdownsPage.monthDropdown);//monthDR will be loaded to month
        List<WebElement>actualMonth_as_WEBELEMENT= month.getOptions();
        List<String >actualMonth_as_String = new ArrayList<>();
        for (WebElement each: actualMonth_as_WEBELEMENT        ) {
            actualMonth_as_String.add(each.getText());

        }
         Assert.assertEquals(expectedMonths,actualMonth_as_String);
        */

        List<String> actualMonths = BrowserUtils.dropdownOptions_as_STRING(dropdownsPage.monthDropdown);

        Assert.assertEquals(expectedMonths, actualMonths );


    }

}
