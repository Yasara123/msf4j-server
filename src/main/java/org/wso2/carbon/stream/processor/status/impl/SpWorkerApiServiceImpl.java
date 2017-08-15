package org.wso2.carbon.stream.processor.status.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.stream.processor.status.api.ApiResponseMessage;
import org.wso2.carbon.stream.processor.status.api.NotFoundException;
import org.wso2.carbon.stream.processor.status.api.SpWorkerApiService;

import javax.ws.rs.core.Response;

/**
 * .
 */
@javax.annotation.Generated(value = "org.wso2.carbon.stream.processor.status.codegen.languages." +
        "JavaMSF4JServerCodegen", date = "2017-08-14T13:04:51.561Z")
public class SpWorkerApiServiceImpl extends SpWorkerApiService {
    private static final Log log = LogFactory.getLog(SpWorkerApiServiceImpl.class);
    @Override
    public Response getWorker() throws NotFoundException {
        log.info("Worker Info get *************************************");
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getWorkerDetails(String workerID
 ) throws NotFoundException {
        // do some magic!
        log.info("Worker details get #############################################");
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
    @Override
    public Response getWorkerMetrics(String workerID
 ) throws NotFoundException {
        // do some magic!
        log.info("Worker metrics get $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
