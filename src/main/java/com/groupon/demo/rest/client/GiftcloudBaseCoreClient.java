package com.groupon.demo.rest.client;

import org.joda.time.DateTimeZone;

import com.google.gson.FieldNamingPolicy;
import com.groupon.mostest.mostaf.common.json.DateTimeAdapter;
import com.groupon.mostest.mostaf.rest.client.RestCredentials;
import com.groupon.mostest.mostaf.rest.client.ServiceRestClient;
import com.groupon.mostest.mostaf.rest.service.IRestService;

/**
 * Base class for all ThreePip clients
 *
 * @author edelarosaraymun
 *
 * @param <ServiceT> Type of services that client implements
 */
public abstract class GiftcloudBaseCoreClient<ServiceT extends IRestService> extends ServiceRestClient<ServiceT> {
    protected static final FieldNamingPolicy FIELD_NAMING_POLICY = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;

    private static final RestCredentials     CREDENTIALS         = null;
    private static final String              DATE_TIME_FORMAT    = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final DateTimeZone        TIME_ZONE           = DateTimeZone.UTC;


    public GiftcloudBaseCoreClient(Class<ServiceT> serviceClass, String baseApiUrl,
                                   Boolean verifyFields) {
        super(serviceClass, baseApiUrl, CREDENTIALS, new DateTimeAdapter(TIME_ZONE, DATE_TIME_FORMAT),
              FIELD_NAMING_POLICY, verifyFields);

    }



}
