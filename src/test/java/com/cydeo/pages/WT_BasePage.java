package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WT_BasePage {
    public WT_BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//button[text()='View all orders']")
  public WebElement viewAllOrdersLink;

    @FindBy(xpath = "//button[text()='View all products']")
    public WebElement viewAllProductLink;

    @FindBy(xpath = "//button[text()='Order']")
    public WebElement ordersLink;

    @FindBy(xpath = "//button[text()='Logout']")
    public WebElement logOutLink;
}
