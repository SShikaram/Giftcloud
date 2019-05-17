package com.groupon.demo.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.groupon.demo.rest.dto.SummaryUgcDto;
import com.groupon.mostest.mostaf.rest.service.IRestService;

/**
 * REST service definition for UGC
 *
 * @author edelarosaraymun
 */
public interface IUgcService extends IRestService {
    @GET
    @Path("/v1.0/merchants/{merchant_id}/summary")
    SummaryUgcDto getSummary(@PathParam("merchant_id") String merchantId, @QueryParam("deal_id") String dealId);

}
