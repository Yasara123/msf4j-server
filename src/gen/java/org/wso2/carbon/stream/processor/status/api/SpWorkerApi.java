package org.wso2.carbon.stream.processor.status.api;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import io.swagger.annotations.ApiParam;
import org.wso2.carbon.stream.processor.status.factories.SpWorkerApiServiceFactory;
import org.wso2.carbon.stream.processor.status.impl.SpWorkerApiServiceImpl;
import org.wso2.carbon.stream.processor.status.model.InlineResponse200;
import org.wso2.carbon.stream.processor.status.model.InlineResponse2001;
import org.wso2.msf4j.Microservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
@Component(
        name = "Test-Server",
        service = Microservice.class,
        immediate = true
)
@Path("/sp-worker")
@Consumes({ "text/plain" })
@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the sp-worker API")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaMSF4JServerCodegen", date = "2017-08-14T13:04:51.561Z")
public class SpWorkerApi implements Microservice {
    private static final Log log = LogFactory.getLog(SpWorkerApiServiceImpl.class);
   private final SpWorkerApiService delegate = SpWorkerApiServiceFactory.getSpWorkerApi();

    @GET
    
    @Consumes({ "text/plain" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Lists Siddhi Applications.", notes = "Provides the name of the worker and gernal details. ", response = void.class, tags={ "Artifact", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Sucessefully reached to worker.", response = void.class) })
    public Response getWorker()
            throws javax.ws.rs.NotFoundException, NotFoundException {
        return delegate.getWorker();
    }
    @GET
    @Path("/{workerID}")
    @Consumes({ "text/plain" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Provides the name of the worker and gernal details.", notes = "Provides the name of the worker and gernal details such as name, status, HA details.", response = InlineResponse200.class, tags={ "Artifact", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Sucessefully reached to the worker.", response = InlineResponse200.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Worker is not found.", response = InlineResponse200.class) })
    public Response getWorkerDetails(@ApiParam(value = "The id of the worker.",required=true) @PathParam("workerID") String workerID
)
            throws javax.ws.rs.NotFoundException, NotFoundException {
        return delegate.getWorkerDetails(workerID);
    }
    @GET
    @Path("/{workerID}/metrics")
    @Consumes({ "text/plain" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Provides the current metrics detals of the worker.", notes = "Provides the current metrics detals of the worker such as cpu,load aversge, physical and heap memory.", response = InlineResponse2001.class, tags={ "Artifact", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "Sucessefully reached to the worker.", response = InlineResponse2001.class),
        
        @io.swagger.annotations.ApiResponse(code = 404, message = "Worker is not found.", response = InlineResponse2001.class) })
    public Response getWorkerMetrics(@ApiParam(value = "The id of the worker.",required=true) @PathParam("workerID") String workerID
)
    throws NotFoundException {
        return delegate.getWorkerMetrics(workerID);
    }
    /**
     * This is the activation method of ServiceComponent. This will be called when it's references are fulfilled
     *
     * @throws Exception this will be thrown if an issue occurs while executing the activate method
     */
    @Activate
    protected void start() throws Exception {
        log.info("***************************************************");
    }

    /**
     * This is the deactivation method of ServiceComponent. This will be called when this component
     * is being stopped or references are satisfied during runtime.
     *
     * @throws Exception this will be thrown if an issue occurs while executing the de-activate method
     */
    @Deactivate
    protected void stop() throws Exception {
        log.info("######################################");
    }
}
