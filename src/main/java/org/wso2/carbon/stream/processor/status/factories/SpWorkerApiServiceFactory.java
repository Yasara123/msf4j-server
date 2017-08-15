package org.wso2.carbon.stream.processor.status.factories;

import org.wso2.carbon.stream.processor.status.api.SpWorkerApiService;
import org.wso2.carbon.stream.processor.status.impl.SpWorkerApiServiceImpl;

/**
 * .
 */
public class SpWorkerApiServiceFactory {
    private static final SpWorkerApiService service = new SpWorkerApiServiceImpl();

    public static SpWorkerApiService getSpWorkerApi() {
        return service;
    }
}
