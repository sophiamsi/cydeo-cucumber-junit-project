package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WT_LoginPage {
    public WT_LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
@FindBy(name="username")
    public WebElement inputUserName;


    @FindBy(name="password")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;

    public void login(){
        this.inputUserName.sendKeys("Test");
        this.inputPassword.sendKeys("Tester");
        this.loginButton.click();
    }
}
