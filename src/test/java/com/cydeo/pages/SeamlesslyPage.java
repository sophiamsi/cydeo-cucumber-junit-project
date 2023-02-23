package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeamlesslyPage {
    public SeamlesslyPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
