package org.wso2.carbon.stream.processor.status.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * InlineResponse2001
 */
@javax.annotation.Generated(value = "org.wso2.carbon.stream.processor.status.codegen.languages.JavaMSF4JServerCodegen", date = "2017-08-14T13:04:51.561Z")
public class InlineResponse2001   {
  @JsonProperty("cpu")
  private BigDecimal cpu = null;

  @JsonProperty("heap-memory")
  private BigDecimal heapMemory = null;

  @JsonProperty("physical-memory")
  private BigDecimal physicalMemory = null;

  @JsonProperty("load-average")
  private BigDecimal loadAverage = null;

  public InlineResponse2001 cpu(BigDecimal cpu) {
    this.cpu = cpu;
    return this;
  }

   /**
   * current CPU of the worker
   * @return cpu
  **/
  @ApiModelProperty(value = "current CPU of the worker")
  public BigDecimal getCpu() {
    return cpu;
  }

  public void setCpu(BigDecimal cpu) {
    this.cpu = cpu;
  }

  public InlineResponse2001 heapMemory(BigDecimal heapMemory) {
    this.heapMemory = heapMemory;
    return this;
  }

   /**
   * current heap memory of the worker
   * @return heapMemory
  **/
  @ApiModelProperty(value = "current heap memory of the worker")
  public BigDecimal getHeapMemory() {
    return heapMemory;
  }

  public void setHeapMemory(BigDecimal heapMemory) {
    this.heapMemory = heapMemory;
  }

  public InlineResponse2001 physicalMemory(BigDecimal physicalMemory) {
    this.physicalMemory = physicalMemory;
    return this;
  }

   /**
   * current physical memory of the worker
   * @return physicalMemory
  **/
  @ApiModelProperty(value = "current physical memory of the worker")
  public BigDecimal getPhysicalMemory() {
    return physicalMemory;
  }

  public void setPhysicalMemory(BigDecimal physicalMemory) {
    this.physicalMemory = physicalMemory;
  }

  public InlineResponse2001 loadAverage(BigDecimal loadAverage) {
    this.loadAverage = loadAverage;
    return this;
  }

   /**
   * current load average of the worker
   * @return loadAverage
  **/
  @ApiModelProperty(value = "current load average of the worker")
  public BigDecimal getLoadAverage() {
    return loadAverage;
  }

  public void setLoadAverage(BigDecimal loadAverage) {
    this.loadAverage = loadAverage;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse2001 inlineResponse2001 = (InlineResponse2001) o;
    return Objects.equals(this.cpu, inlineResponse2001.cpu) &&
        Objects.equals(this.heapMemory, inlineResponse2001.heapMemory) &&
        Objects.equals(this.physicalMemory, inlineResponse2001.physicalMemory) &&
        Objects.equals(this.loadAverage, inlineResponse2001.loadAverage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cpu, heapMemory, physicalMemory, loadAverage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001 {\n");
    
    sb.append("    cpu: ").append(toIndentedString(cpu)).append("\n");
    sb.append("    heapMemory: ").append(toIndentedString(heapMemory)).append("\n");
    sb.append("    physicalMemory: ").append(toIndentedString(physicalMemory)).append("\n");
    sb.append("    loadAverage: ").append(toIndentedString(loadAverage)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

