package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage extends Utility {
    public AddCustomerPage(){

    PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement enterFistName;

    @FindBy(xpath = "//input[@placeholder='Last Name']" )
    WebElement enterLastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement addCustomerButton;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement homeButton;


    public void fillFistName() {

        sendTextToElement(enterFistName, "Siya");
    }
    public void fillLastName(){

        sendTextToElement(enterLastName,"Patel");
    }
    public void fillPostCode(){

        sendTextToElement(postCode, "40001");
    }
    public void addCustomerButton()
    {
        clickOnElement(addCustomerButton);
    }
    public void verifyPopUpWindowAndClick(String exp){

        alertPopUpWindowAndVerifyText(exp);
    }
    public void clickOnHomeButton(){
        clickOnElement(homeButton);

    }

}
