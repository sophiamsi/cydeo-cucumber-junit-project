package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
In this class we will be able to create "Pre" and"post" condition for all of the Scenarios and given steps
 */
public class Hooks {
    //import the @Before coming from io.cucumber. java
    @Before

    public void setupMethod(){
        System.out.println("->> @Before : Running before each scenario");
    }

    //will be executed automatically after Every scenario in the project
    @After
    public void teardownMethod(Scenario scenario){
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        System.out.println("---> @After:Running after each scenario");
        Driver.closeDriver();
    }

   // @BeforeStep
    public void setupStep(){
        System.out.println("------>@BeforeStep:Running before each Step");
    }
   // @AfterStep
    public void tearDown(){
        System.out.println("------>@AfterStep:Running before each Step");
    }
}
