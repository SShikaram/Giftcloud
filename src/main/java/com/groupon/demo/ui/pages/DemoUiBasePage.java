package com.groupon.demo.ui.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.groupon.demo.ui.test.IUiConfig;
import com.groupon.demo.ui.test.IUiITBase;
import com.groupon.demo.ui.test.IUiSession;
import com.groupon.mostest.mostaf.aspectj.TestAction;
import com.groupon.mostest.mostaf.webui.page.WebUiBasePage;

/**
 * Base class for all Demo page objects
 *
 * @author edelarosaraymun
 */
public abstract class DemoUiBasePage
                extends WebUiBasePage<IUiITBase, IUiConfig, IUiSession> implements IDemoUiBasePage {

    protected static final Logger LOG = LogManager.getLogger();

    public DemoUiBasePage(WebDriver driver, IUiITBase test) {
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
