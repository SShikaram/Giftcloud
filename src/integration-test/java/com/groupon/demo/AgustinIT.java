package com.groupon.demo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.groupon.demo.data.ColoType;
import com.groupon.demo.ui.pages.LandingPage;
import com.groupon.demo.ui.test.UiITBase;
import com.groupon.demo.util.UserCredentialsProvider;
import com.groupon.mostest.mostaf.config.models.EnvironmentType;
import com.groupon.mostest.mostaf.reporting.models.TestGroup;
import com.groupon.mostest.mostaf.rest.gapi.dto.UserCredentials;

public class AgustinIT extends UiITBase {
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
        LandingPage landingPage = new LandingPage(getDriver(), this);
        landingPage.openNewUrl("http://staging.groupon.com");
        landingPage.verify();
        landingPage.hidePopup();
        landingPage.loginPopup(getSession().getUserCredentials().getUsername(),
                               getSession().getUserCredentials().getPassword());


        Assert.assertTrue(landingPage.getUsernameLogin()
                                     .contains(getSession().getUserCredentials().getUsername().substring(0, 10)));
    }

}
