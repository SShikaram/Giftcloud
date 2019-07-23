package com.groupon.demo.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.groupon.demo.ui.test.IGiftcloudUiConfig;
import com.groupon.demo.ui.test.IGiftcloudUiITBase;
import com.groupon.demo.ui.test.IGiftcloudUiSession;
import com.groupon.mostest.mostaf.aspectj.TestAction;
import com.groupon.mostest.mostaf.webui.page.WebUiBasePage;

/**
 * Base class for all Demo page objects
 *
 * @author edelarosaraymun
 */
public abstract class GiftcloudUiBasePage
                extends WebUiBasePage<IGiftcloudUiITBase, IGiftcloudUiConfig, IGiftcloudUiSession> implements IGiftcloudUiBasePage {

    protected static final Logger LOG = LogManager.getLogger();

    public GiftcloudUiBasePage(WebDriver driver, IGiftcloudUiITBase test) {
        super(driver, test);
    }

    @TestAction
    public void loadPage(String url) {
        getDriver().get(url);
        verify();
    }

    @Override
    protected boolean isValid() {
        LOG.warn("isValid() has not been implemented in page " + getClass().getSimpleName());
        return true;
    }

    public void hidePopup() {
        WebElement noThxLink = getDriver().findElement(By.id("nothx"));
        if (noThxLink.isDisplayed()) {
            noThxLink.click();
        }

    }
}
