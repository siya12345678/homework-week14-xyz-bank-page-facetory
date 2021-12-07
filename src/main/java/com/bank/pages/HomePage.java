package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    public HomePage() {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankMangerLogin;
    @FindBy(xpath = "//button[@ng-click='customer()']")
    WebElement customerLogin;
    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homeButton;

    public void clickOnHomeButton() {
        clickOnElement(homeButton);
    }

    public void clickOnCustomerLogin() {
        clickOnElement(customerLogin);
    }

    public void clickOnBankManagerLogin() {
        clickOnElement(bankMangerLogin);

    }
}