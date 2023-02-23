package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    //sleep method without exception
//This method will accept int (in seconds) and execute Thread.sleep() for given duration

    public static void sleep(int second){
        second*=1000;
        try{
            Thread.sleep(second);

        }catch (InterruptedException e){

        }
    }

    public static void switchWindowAndVerify( String expectedIndUrl, String expectedInTitle){


        Set<String> allWindowHandles =Driver.getDriver().getWindowHandles();
        for (String each: allWindowHandles) {
            Driver.getDriver().switchTo().window(each);//in each iteration it will keep switching.
            //while it switching we want to see a URL
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedIndUrl)) {
                break;
            }
            String actualTitle = Driver.getDriver().getTitle();

            Assert.assertTrue(actualTitle.contains(expectedInTitle));

        }
    /*

1. Create a new class calledBrowserUtils
2. Create a method to make Task1 logic re-usable
3. When method is called,it should switch window and verify title.
Method info:
• Name: switchWindowAndVerify
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl
• Arg3: String expectedTitle
     */
    }


    public static void verifyTitle(String expectedTitle){

     //   String actualTitle= driver.getTitle();

        Assert.assertEquals(Driver.getDriver().getTitle(),expectedTitle);


    }
    public static void verifyTitleContains(WebDriver driver,String expectedInTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedInTitle));
    }
    /*
     This method accepts WebElement target,
     and waits for that WebElement not to be displayed on the page
      */
    public static void waitForInvisibilityOf(WebElement target){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    /*
    This method accepts String title,
    and waits for that Title to contain given String value.
     */
    public static void waitForTitleContains(String title){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title));
    }



    /**
     * This method accepts a dropdown element and returns a List<String> that contains all options values as String.
     * @param dropdownElement
     * @return actualMonth_as_STRING
     */
    public static List<String> dropdownOptions_as_STRING(WebElement dropdownElement){

        Select month = new Select(dropdownElement);
        //Storing all the ACTUAL options into a List of WebElements
        List<WebElement> actualMonth_as_WEBELEMENT = month.getOptions();

        //Creating an EMPTY list of String to store ACTUAL <option> as String
        List<String> actualMonth_as_STRING = new ArrayList<>();

        //Looping through the List<WebElement>, getting all options' texts, and storing them into List<String>
        for (WebElement each : actualMonth_as_WEBELEMENT) {

            actualMonth_as_STRING.add(each.getText());

        }

        return actualMonth_as_STRING;

    }


    public static void clickRadioButton(List<WebElement>radioButtons,String attributeValue){

        for (WebElement each: radioButtons){
            if(each.getAttribute("value").equals(attributeValue)){
                each.click();
            }
        }

    }
    //MOves the mouse to given element. @param element on which to hover
public static void hover(WebElement element){
    Actions actions = new Actions(Driver.getDriver());
    actions.moveToElement(element).perform();
}

//return a list of String from List of elements
// @param list of webelements
//@return list of String
public static List<String>getElementsText(List<WebElement>list){
        List<String>elemText = new ArrayList<>();
    for (WebElement el:list) {
        elemText.add(el.getText());
    }
    return elemText;
}

}

