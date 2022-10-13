package com.aspose.html.android.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;


/**
  * The error details
 **/

public class ErrorDetails   {
  

 /**
   * The request id  
  **/
  private String requestId = null;
  

 /**
   * Date  
  **/
  private Date date = null;
 /**
   * The request id
   * @return requestId
  **/
  @SerializedName("requestId")
  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public ErrorDetails requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

 /**
   * Date
   * @return date
  **/
  @SerializedName("date")
  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public ErrorDetails date(Date date) {
    this.date = date;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorDetails {\n");
    
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
