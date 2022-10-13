package com.aspose.html.android.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ConversionResult extends OperationResult  {
  private String file = null;
 /**
   * Get files
   * @return files
  **/
  @SerializedName("file")
  public String getFile() {
    return file;
  }

  public void setFile(String file) {
    this.file = file;
  }

  public ConversionResult files(String file) {
    this.file = file;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversionResult {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    file: ").append(toIndentedString(file)).append("\n");
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
