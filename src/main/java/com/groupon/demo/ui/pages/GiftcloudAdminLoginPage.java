package com.groupon.demo.ui.pages;

import com.groupon.demo.ui.test.IGiftcloudUiITBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GiftcloudAdminLoginPage extends GiftcloudUiBasePage {

    @FindBy(id = "Email")
    WebElement emailInput;

    @FindBy(id = "Password")
    WebElement passwordInput;

    @FindBy(id = "submit")
    WebElement submitInput;

    public GiftcloudAdminLoginPage(WebDriver driver, IGiftcloudUiITBase test) {

        super(driver, test);

    }

    @Override
    protected boolean isCurrent() {
        return false;
    }

    public WebElement getEmailInput() {
        return emailInput;
    }

    public void setEmailInput(String emailInput) {
        this.emailInput.sendKeys(emailInput);
    }

    public void setPasswordInput(String passwordInput) {
        this.passwordInput.sendKeys(passwordInput);
    }

    public void setSubmitInput() {
        this.submitInput.click();
    }
}

