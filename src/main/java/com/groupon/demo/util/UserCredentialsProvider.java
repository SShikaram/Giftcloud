package com.groupon.demo.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.groupon.demo.data.ColoType;
import com.groupon.demo.ui.test.IUiConfig;
import com.groupon.mostest.mostaf.aspectj.TestAction;
import com.groupon.mostest.mostaf.common.payments.models.CreditCardType;
import com.groupon.mostest.mostaf.rest.gapi.dto.GapiAuthInfoV2;
import com.groupon.mostest.mostaf.rest.gapi.dto.UserCredentials;
import com.groupon.mostest.mostaf.rest.gapi.utils.GapiUserCreateRequestProvider;
import com.groupon.mostest.mostaf.rest.gapi.utils.GapiUserUtils;

/**
 * Defines utility methods to provide user credentials for tests
 *
 * @author edelarosaraymun
 */
public final class UserCredentialsProvider {

    private static final Logger                   LOG             = LogManager.getLogger();

    private static Map<ColoType, UserCredentials> userCredentials = new HashMap<>();

    private UserCredentialsProvider() {}

    @TestAction
    public static synchronized UserCredentials get(IUiConfig config, ColoType colo) {
        UserCredentials coloCredentials = userCredentials.get(colo);
        if (coloCredentials == null) {
            coloCredentials = getOrCreateNewUser(config, colo);
            userCredentials.put(colo, coloCredentials);
        }

        return coloCredentials;
    }

    @TestAction
    private static UserCredentials getOrCreateNewUser(IUiConfig config, ColoType colo) {
        LOG.info("Creating/getting user for colo '{}' ...", colo);
        final String password = GapiUserCreateRequestProvider.DEFAULT_USER_PASSWORD;
        final GapiAuthInfoV2 authInfo = GapiUserUtils.getOrCreateDailyTestAccount(config.getGapiUrl(),
                                                                                  config, password,
                                                                                  CreditCardType.VISA);

        return UserCredentials.fromGapiAuthInfo(authInfo, password);
    }
}
