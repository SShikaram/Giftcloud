package com.groupon.demo.ui.test;

import com.groupon.mostest.mostaf.webui.config.IWebUiITConfig;


/**
 * Base IntegrationTest(IT) for all IT in demo project
 *
 * @author edelarosaraymun
 */
public interface IGiftcloudUiConfig extends IWebUiITConfig {
    String getGapiUrl();

    String getAdminUrl();

    String getDealId();

    String getArtDealId();

    String getArtDealUuid();

    String getArtMerchantId();
}
