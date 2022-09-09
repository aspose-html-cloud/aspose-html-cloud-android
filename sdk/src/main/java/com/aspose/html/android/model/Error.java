package com.aspose.html.android.model;

import com.google.gson.annotations.SerializedName;

/**
  * Error
 **/
public class Error   {
 /**
   * Code               
  **/
  private String code = null;
  

 /**
   * Message               
  **/
  private String message = null;
  

 /**
   * Description               
  **/
  private String description = null;
  

  private ErrorDetails innerError = null;
 /**
   * Code             
   * @return code
  **/
  @SerializedName("code")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Error code(String code) {
    this.code = code;
    return this;
  }

 /**
   * Message             
   * @return message
  **/
  @SerializedName("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Error message(String message) {
    this.message = message;
    return this;
  }

 /**
   * Description             
   * @return description
  **/
  @SerializedName("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Error description(String description) {
    this.description = description;
    return this;
  }

 /**
   * Get innerError
   * @return innerError
  **/
  @SerializedName("innerError")
  public ErrorDetails getInnerError() {
    return innerError;
  }

  public void setInnerError(ErrorDetails innerError) {
    this.innerError = innerError;
  }

  public Error innerError(ErrorDetails innerError) {
    this.innerError = innerError;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    innerError: ").append(toIndentedString(innerError)).append("\n");
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
