package com.groupon.demo.rest.client;

import javax.ws.rs.WebApplicationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.groupon.demo.rest.dto.SummaryUgcDto;
import com.groupon.demo.rest.service.IUgcService;
import com.groupon.mostest.mostaf.common.log.LogUtils;

/**
 * Rest client for Google Api
 *
 * @author edelarosaraymun
 *
 */
public class UgcCoreClient extends DemoBaseCoreClient<IUgcService> {
    private static final Logger  LOG           = LogManager.getLogger();
    private static final boolean VERIFY_FIELDS = false;

    public UgcCoreClient(String ugcHost) {
        super(IUgcService.class, ugcHost, VERIFY_FIELDS);
    }

    public SummaryUgcDto getSummary(String merchantId, String dealId) {
        try {
            return getService().getSummary(merchantId, dealId);
        }
        catch (WebApplicationException ex) {
            throw LogUtils.errorForThrow(LOG, new IllegalStateException(
                                                                        String.format("Failed to get access token"),
                                                                        ex));
        }
    }

}
