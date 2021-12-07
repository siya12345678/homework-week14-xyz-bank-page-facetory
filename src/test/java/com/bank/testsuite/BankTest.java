package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class BankTest extends TestBase {
    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    AccountPage accountPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    CustomersPage customerPage;


    @BeforeMethod(groups = {"sanity","smoke","regression"})
    public void inIt1() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        accountPage = new AccountPage();
        openAccountPage = new OpenAccountPage();
        customerLoginPage = new CustomerLoginPage();
        customerPage = new CustomersPage();

    }

    @Test(priority = 1,groups = {"smoke","regression"})
    public void bankManagerShouldAddCustomerSuccessFully() {
        homePage.clickOnBankManagerLogin();
        bankManagerLoginPage.clickOnAddCustomerTab();
        addCustomerPage.fillFistName();
        addCustomerPage.fillLastName();
        addCustomerPage.fillPostCode();
        addCustomerPage.addCustomerButton();
        String expected = "Customer added successfully with customer id :6";
        addCustomerPage.verifyPopUpWindowAndClick(expected);
    }

    @Test(priority = 2,groups = {"sanity","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        bankManagerShouldAddCustomerSuccessFully();
        homePage.clickOnHomeButton();
        homePage.clickOnBankManagerLogin();
        accountPage.clickOnOpenAccount();
        accountPage.selectCustomerSearch();
        accountPage.selectCurrency();
        accountPage.clickOnProcessButton();
        String exp="Account created successfully with account Number :1016";
        System.out.println(exp);
        accountPage.verifyPopWindowTextAndAccept(exp);
    }

    @Test(priority = 3,groups = {"sanity","regression"})
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        bankManagerShouldOpenAccountSuccessfully();
        homePage.clickOnHomeButton();
        Thread.sleep(2000);
        homePage.clickOnCustomerLogin();
        Thread.sleep(2000);
        customerLoginPage.searchCustomerFromDropDown();
        Thread.sleep(2000);
       customerLoginPage.clickOnLoginButton();
        Thread.sleep(3000);
        customerLoginPage.verifyLogoutTabAndClickOnLogoutPage();
    }

    @Test(priority = 4,groups = {"regression"})
        public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
            customerShouldLoginAndLogoutSuccessfully();
            Thread.sleep(2000);
            homePage.clickOnHomeButton();
            homePage.clickOnCustomerLogin();
            Thread.sleep(2000);
            customerLoginPage.searchCustomerDropDown();
            Thread.sleep(2000);
            customerLoginPage.clickOnLoginButton();
            Thread.sleep(2000);
            customerPage.clickOnDeposit();
            customerPage.enterAmount100();
            customerPage.clickOnDepositButtonLast();
            String exp="Deposit Successful";
            customerPage.verifyDepositSuccessfully(exp);
        }


    @Test(priority = 5,groups = {"regression"})
        public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {

            customerShouldDepositMoneySuccessfully();
            Thread.sleep(2000);
            homePage.clickOnHomeButton();
            homePage.clickOnCustomerLogin();
            customerLoginPage.searchCustomerFromDropDown();
            customerLoginPage.clickOnLoginButton();
            customerPage.clickOnWithDrawl();
            customerPage.enterWithDrawlAmount50();
            customerPage.clickOnWithdrawButton();
            String exp="Transaction successful";
            customerPage.verifyWithdrawSuccessfully(exp);








        }




}
