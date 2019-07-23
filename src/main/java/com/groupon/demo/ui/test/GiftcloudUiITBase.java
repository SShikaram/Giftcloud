package com.groupon.demo.ui.test;

import org.testng.annotations.Listeners;

import com.groupon.mostest.mostaf.common.log.TestActionLogListener;
import com.groupon.mostest.mostaf.webui.listener.UiTestFailureListener;
import com.groupon.mostest.mostaf.webui.test.WebUiITBase;

/**
 * Base IntegrationTest(IT) for all IT in demo project
 *
 * @author edelarosaraymun
 */
@Listeners({TestActionLogListener.class, UiTestFailureListener.class})
public class GiftcloudUiITBase extends WebUiITBase<IGiftcloudUiConfig, IGiftcloudUiSession> implements IGiftcloudUiITBase {

    @Override
    protected IGiftcloudUiConfig fetchConfig() {
        return GiftcloudUiConfig.getInstance();
    }

    @Override
    protected IGiftcloudUiSession createSession() {
        return new GiftcloudUiSession();
    }

}
