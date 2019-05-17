package com.groupon.demo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.groupon.demo.data.ColoType;
import com.groupon.demo.ui.pages.DealPage;
import com.groupon.demo.ui.test.IUiConfig;
import com.groupon.demo.ui.test.IUiITBase;
import com.groupon.demo.ui.test.IUiSession;
import com.groupon.demo.ui.test.UiITBase;
import com.groupon.demo.util.UserCredentialsProvider;
import com.groupon.mostest.mostaf.config.models.EnvironmentType;
import com.groupon.mostest.mostaf.reporting.models.TestGroup;
import com.groupon.mostest.mostaf.rest.gapi.dto.UserCredentials;
import com.groupon.mostest.mostaf.webui.page.GrouponLoginPage;

/**
 * Integration Test
 *
 * @author edelarosaraymun
 */

public class IntegrationTest extends UiITBase {

    @Override
    @BeforeMethod(groups = TestGroup.CONFIG)
    public void beforeMethod() {
        super.beforeMethod();
        if (getConfig().getEnvironment() == EnvironmentType.STAGING) {
            final UserCredentials userCredentials = UserCredentialsProvider.get(getConfig(), ColoType.SNC1);
            getSession().setUserCredentials(userCredentials);
        }
    }

    @Test(groups = TestGroup.P0,
                    description = "Demo Test")
    public void test() {
        DealPage dealPage = new DealPage(getDriver(), this);
        dealPage.openNewUrl(getConfig().getDealId());
        dealPage.hidePopup();
        dealPage.clickBuyButton();

        GrouponLoginPage<IUiITBase, IUiConfig, IUiSession> loginPage = null;
        loginPage = new GrouponLoginPage<IUiITBase, IUiConfig, IUiSession>(getDriver(), this);
        loginPage.verify();
        loginPage.submitCredentials(getSession().getUserCredentials());


        Assert.assertEquals(getDriver().getTitle(),
                            "Your Purchase");

    }

}
