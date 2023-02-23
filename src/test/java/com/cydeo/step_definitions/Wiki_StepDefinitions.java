package com.cydeo.step_definitions;

import com.cydeo.pages.WikiResultPage;
import com.cydeo.pages.WikiSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Wiki_StepDefinitions {
WikiSearchPage wikiSearchPage= new WikiSearchPage();
    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");
    }

    @When("User types {string} in the wiki search box")
    public void userTypesInTheWikiSearchBox(String searchValue) {
        BrowserUtils.sleep(2);
wikiSearchPage.searchBox.sendKeys(searchValue);
    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        BrowserUtils.sleep(2);
wikiSearchPage.searchButton.click();
    }

    @Then("User sees {string} is in the wiki title")
    public void userSeesIsInTheWikiTitle(String expectedInTitle) {
        BrowserUtils.sleep(5);
        BrowserUtils.verifyTitle(expectedInTitle);
    }

WikiResultPage wikiResultPage = new WikiResultPage();
    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String expectedText) {
String actualHeaderText= wikiResultPage.mainHeader.getText();
        Assert.assertEquals(actualHeaderText,expectedText);
    }

    @Then("User sees {string} is in the image header")
    public void userSeesIsInTheImageHeader(String expectedText) {

        Assert.assertEquals(wikiResultPage.imageHeader.getText(),expectedText);
    }
}
