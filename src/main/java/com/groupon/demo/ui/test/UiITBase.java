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
public class UiITBase extends WebUiITBase<IUiConfig, IUiSession> implements IUiITBase {

    @Override
    protected IUiConfig fetchConfig() {
        return UiConfig.getInstance();
    }

    @Override
    protected IUiSession createSession() {
        return new UiSession();
    }

}
