package org.wso2.carbon.stream.processor.status.api;



import javax.ws.rs.core.Response;

@javax.annotation.Generated(value = "org.wso2.carbon.stream.processor.status.codegen.languages.JavaMSF4JServerCodegen", date = "2017-08-14T13:04:51.561Z")
public abstract class SpWorkerApiService {
    public abstract Response getWorker() throws NotFoundException;
    public abstract Response getWorkerDetails(String workerID
 ) throws NotFoundException;
    public abstract Response getWorkerMetrics(String workerID
 ) throws NotFoundException;
}
