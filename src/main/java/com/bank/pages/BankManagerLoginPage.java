package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankManagerLoginPage extends Utility {

    public  BankManagerLoginPage (){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement addCustomer;

    public void clickOnAddCustomerTab(){

        clickOnElement(addCustomer);
    }
}
