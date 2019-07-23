package com.groupon.demo.ui.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.groupon.mostest.mostaf.config.models.BrandType;
import com.groupon.mostest.mostaf.config.models.CountryType;
import com.groupon.mostest.mostaf.config.models.RegionType;
import com.groupon.mostest.mostaf.webui.config.WebUiITConfig;

/**
 * Defines the configuration options for all tests in demo project
 *
 * @author edelarosaraymun
 */
public final class GiftcloudUiConfig extends WebUiITConfig implements IGiftcloudUiConfig {
    public static final String      TEST_USER_PREFIX = "demo";
    public static final String      PROJECT_NAME     = "demo";

    public static final RegionType  REGION           = RegionType.US;
    public static final CountryType COUNTRY          = CountryType.US;
    public static final BrandType   BRAND            = BrandType.GROUPON;

    private static final GiftcloudUiConfig INSTANCE         = new GiftcloudUiConfig();
    private static final Logger     LOG              = LogManager.getLogger();

    private final String            clientId;
    private final String            dealId;
    private final String            gapiUrl;
    private final String            artDealId;
    private final String            artDealUuid;
    private final String            artMerchanId;
    private final String            adminUrl;

    private boolean                 isDeviceMobile   = false;


    private GiftcloudUiConfig() {
        clientId = getValue("clientId");
        dealId = getValue("dealId");
        gapiUrl = getValue("gapiUrl");
        artDealId = getValue("artDealId");
        artDealUuid = getValue("artDealUuid");
        artMerchanId = getValue("artMerchanId");
        adminUrl = getValue("adminUrl");
    }

    public static IGiftcloudUiConfig getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean isCurrentDeviceMobile() {
        return isDeviceMobile;
    }

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public String getProjectName() {
        return PROJECT_NAME;
    }

    @Override
    public String getUserEmailAccountPrefix() {
        return TEST_USER_PREFIX;
    }

    @Override
    public String getJiraProjectName() {
        return null;
    }

    @Override
    public String getOktaUsername() {
        return null;
    }

    @Override
    public String getJiraComponent() {
        return null;
    }

    @Override
    public String getJiraEpicIssue() {
        return null;
    }

    @Override
    public String getGapiUrl() {
        return gapiUrl;
    }

    @Override
    public String getDealId() {
        return dealId;
    }

    @Override
    public String getArtDealId() {
        return artDealId;
    }

    @Override
    public String getArtDealUuid() {
        return artDealUuid;
    }

    @Override
    public String getArtMerchantId() {
        return artMerchanId;
    }

    @Override
    public String getAdminUrl() {
        return adminUrl;
    }

}
