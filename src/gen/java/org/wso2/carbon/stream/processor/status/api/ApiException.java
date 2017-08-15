package org.wso2.carbon.stream.processor.status.api;

@javax.annotation.Generated(value = "org.wso2.carbon.stream.processor.status.codegen.languages.JavaMSF4JServerCodegen", date = "2017-08-14T13:04:51.561Z")
public class ApiException extends Exception{
    private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
