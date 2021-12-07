package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage extends Utility {
    public  CustomersPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement deposit;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositButton;
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement depositSuccessfully;
    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withDrawlTeb;
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withDrawlAmount;
    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement withDrawlButton;
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement withDrawlSuccessfully;
    public void clickOnDeposit(){clickOnElement(deposit);}
    public void enterAmount100(){sendTextToElement(amount,"100");
    }
    public void clickOnDepositButtonLast(){clickOnElement(depositButton);}
    public void verifyDepositSuccessfully(String exp){
        verifyPage(exp,depositSuccessfully);

    }
    public void clickOnWithDrawl(){
        clickOnElement(withDrawlTeb);
    }
    public void enterWithDrawlAmount50(){
        sendTextToElement(withDrawlAmount,"50");

    }
    public void clickOnWithdrawButton(){

        clickOnElement(withDrawlButton);
    }

    public void verifyWithdrawSuccessfully(String exp){
        verifyPage(exp,withDrawlSuccessfully);
    }


}
