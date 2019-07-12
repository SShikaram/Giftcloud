package com.groupon.demo.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.groupon.demo.ui.test.IUiITBase;

/**
 * Landing page base page object
 *
 * @author edelarosaraymun
 */
public class LandingPage extends GiftcloudUiBasePage {
    @FindBy(xpath = "//div[@id='ls-header-signin-flyout-container']")
    private WebElement loginDiv;

    @FindBy(xpath = "//input[@id='ls-signin-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@id='ls-signin-pw']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@class='btn-cta btn-signin']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@id='user-name']//span")
    private WebElement loginUsername;

    public LandingPage(WebDriver driver, IUiITBase test) {
        super(driver, test);
    }

    @Override
    protected boolean isCurrent() {
        return areVisible(loginDiv);
    }

    public void openNewUrl(String url) {
        navigateTo(url, false);
        getDriver().manage().deleteAllCookies();
    }

    public String getUsernameLogin() {
        return loginUsername.getText();
    }


    public void loginPopup(String username, String password) {
        Actions builder = new Actions(getDriver());

        builder.moveToElement(loginDiv).moveToElement(emailInput).click(emailInput).perform();
        emailInput.sendKeys(username);

        builder = new Actions(getDriver());
        builder.moveToElement(passwordInput).click(passwordInput).perform();
        passwordInput.sendKeys(password);

        builder = new Actions(getDriver());
        builder.moveToElement(loginDiv).click(loginButton).perform();
    }
}
