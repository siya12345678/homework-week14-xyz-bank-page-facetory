package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends Utility {

    public AccountPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@ng-click='openAccount()']")
     WebElement openAccount;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerSearch;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currency;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement process;

     // By openAccount=By.xpath("//button[@ng-click='openAccount()']");
    //By customerSearch= By.xpath("//select[@id='userSelect']");//6
    //By currency=By.xpath("//select[@id='currency']");//Pound
   // By process=By.xpath("//button[@type='submit']");

    public void clickOnOpenAccount(){
        clickOnElement(openAccount);
    }
    public void selectCustomerSearch()  {

        selectFromDropDown(customerSearch,"6");

    }
    public void selectCurrency(){
        selectFromDropDown(currency,"Pound");
    }
    public void clickOnProcessButton(){
        clickOnElement(process);
    }
    public void verifyPopWindowTextAndAccept(String exp){
        alertPopUpWindowAndVerifyText(exp);
    }

}
