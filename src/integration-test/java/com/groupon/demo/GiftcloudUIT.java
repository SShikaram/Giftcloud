package com.groupon.demo;

import com.groupon.demo.ui.pages.GiftcloudAdminLoginPage;
import com.groupon.mostest.mostaf.common.utils.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.groupon.demo.data.ColoType;
import com.groupon.demo.ui.test.GiftcloudUiITBase;
import com.groupon.mostest.mostaf.config.models.EnvironmentType;
import com.groupon.mostest.mostaf.reporting.models.TestGroup;
import com.groupon.mostest.mostaf.rest.gapi.dto.UserCredentials;

/**
 * Integration Test
 *
 * @author edelarosaraymun
 */

public class GiftcloudUIT extends GiftcloudUiITBase {

    GiftcloudAdminLoginPage loginPage;
    public WebDriver driver;


    @Override

    @BeforeMethod(groups = TestGroup.CONFIG)
    public void beforeMethod() {
        super.beforeMethod();

        this.driver=getDriver();
        loginPage=new GiftcloudAdminLoginPage(driver,this);
    }

    @Test(groups = TestGroup.P0,
                    description = "Demo Test")
    public void test() {
        getDriver().get(getConfig().getAdminUrl());

        loginPage.setEmailInput("sshikaram.admin@groupon.com");

        loginPage.setPasswordInput("Hunnybunny1@");


        loginPage.setSubmitInput();

        SystemUtils.sleep(2000);
            }

}
