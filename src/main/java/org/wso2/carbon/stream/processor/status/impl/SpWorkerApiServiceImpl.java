package org.wso2.carbon.stream.processor.status.impl;

import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.kernel.config.model.CarbonConfiguration;
import org.wso2.carbon.kernel.configprovider.CarbonConfigurationException;
import org.wso2.carbon.kernel.configprovider.ConfigProvider;
import org.wso2.carbon.stream.processor.status.api.ApiResponseMessage;
import org.wso2.carbon.stream.processor.status.api.NotFoundException;
import org.wso2.carbon.stream.processor.status.api.SpWorkerApiService;
import org.wso2.carbon.stream.processor.status.internal.WorkerDetails;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * .
 */
@javax.annotation.Generated(value = "org.wso2.carbon.stream.processor.status.codegen.languages." +
        "JavaMSF4JServerCodegen", date = "2017-08-14T13:04:51.561Z")
public class SpWorkerApiServiceImpl extends SpWorkerApiService {
    private static final Log log = LogFactory.getLog(SpWorkerApiServiceImpl.class);


    @Inject
    private ConfigProvider configProvider;

    @Override
    public Response getWorker() throws NotFoundException {
        log.info("WorkerDetails Info get *************************************");
        String jsonString;
        Response.Status status;
        try {
            CarbonConfiguration carbonConfiguration = configProvider.getConfigurationObject(
                    CarbonConfiguration.class);
            Gson gson = new Gson();
            jsonString = gson.toJson(carbonConfiguration.getId());
            status = Response.Status.OK;
        } catch (CarbonConfigurationException e) {
            status = Response.Status.NOT_FOUND;
            WorkerDetails wk = new WorkerDetails();
            Gson gson = new Gson();
            jsonString = gson.toJson(wk);
            log.error("Error");
        }
        return Response.status(status).entity(jsonString).build();
    }

    @Override
    public Response getWorkerDetails(String workerID)  {
        String jsonString;
        Response.Status status;
        try {
            CarbonConfiguration carbonConfiguration = configProvider.getConfigurationObject(
                    CarbonConfiguration.class);
            WorkerDetails wk = new WorkerDetails(carbonConfiguration.getId());
            wk.setName(carbonConfiguration.getName());
            wk.setTenant(carbonConfiguration.getTenant());
            wk.setPorts(carbonConfiguration.getPortsConfig());
            wk.setStartupResolver(carbonConfiguration.getStartupResolverConfig());
            wk.setJmx(carbonConfiguration.getJmxConfiguration());
            Gson gson = new Gson();
            jsonString = gson.toJson(wk);
            status = Response.Status.OK;
        } catch (CarbonConfigurationException e) {
            status = Response.Status.NOT_FOUND;
            WorkerDetails wk = new WorkerDetails();
            Gson gson = new Gson();
            jsonString = gson.toJson(wk);
            log.error("Error");
        }
        log.info("WorkerDetails details get #############################################");
        return Response.status(status).entity(jsonString).build();
    }
    @Override
    public Response getWorkerMetrics(String workerID) throws NotFoundException {
        // do some magic!
        log.info("WorkerDetails metrics get $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "magic!")).build();
    }
}
