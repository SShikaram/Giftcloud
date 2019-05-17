package com.groupon.demo.ui.test;

import com.groupon.mostest.mostaf.webui.config.IWebUiITConfig;


/**
 * Base IntegrationTest(IT) for all IT in demo project
 *
 * @author edelarosaraymun
 */
public interface IUiConfig extends IWebUiITConfig {
    String getGapiUrl();

    String getUgcUrl();

    String getDealId();

    String getArtDealId();

    String getArtDealUuid();

    String getArtMerchantId();
}
