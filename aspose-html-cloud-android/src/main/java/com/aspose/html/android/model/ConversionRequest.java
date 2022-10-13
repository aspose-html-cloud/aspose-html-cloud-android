package com.aspose.html.android.model;

import com.aspose.html.android.options.ConversionOptions;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class ConversionRequest   {
  private String inputPath = null;
  private String storageName = null;
  private List<String> resources = null;
  private String outputFile = null;
  private ConversionOptions options = null;

 /**
   * Get inputPath
   * @return inputPath
  **/
  @SerializedName("inputPath")
  public String getInputPath() {
    return inputPath;
  }

  public void setInputPath(String inputPath) {
    this.inputPath = inputPath;
  }

  public ConversionRequest inputPath(String inputPath) {
    this.inputPath = inputPath;
    return this;
  }

 /**
   * Get storageName
   * @return storageName
  **/
  @SerializedName("storageName")
  public String getStorageName() {
    return storageName;
  }

  public void setStorageName(String storageName) {
    this.storageName = storageName;
  }

  public ConversionRequest storageName(String storageName) {
    this.storageName = storageName;
    return this;
  }

 /**
   * Get resources
   * @return resources
  **/
  @SerializedName("resources")
  public List<String> getResources() {
    return resources;
  }

  public void setResources(List<String> resources) {
    this.resources = resources;
  }

  public ConversionRequest resources(List<String> resources) {
    this.resources = resources;
    return this;
  }

  public ConversionRequest addResourcesItem(String resourcesItem) {
    this.resources.add(resourcesItem);
    return this;
  }

 /**
   * Get outputFile
   * @return outputFile
  **/
  @SerializedName("outputFile")
  public String getOutputFile() {
    return outputFile;
  }

  public void setOutputFile(String outputFile) {
    this.outputFile = outputFile;
  }

  public ConversionRequest outputFile(String outputFile) {
    this.outputFile = outputFile;
    return this;
  }

 /**
   * Get options
   * @return options
  **/
  @SerializedName("options")
  public ConversionOptions getOptions() {
    return options;
  }

  public void setOptions(ConversionOptions options) {
    this.options = options;
  }

  public ConversionRequest options(ConversionOptions options) {
    this.options = options;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConversionRequest {\n");
    
    sb.append("    inputPath: ").append(toIndentedString(inputPath)).append("\n");
    sb.append("    storageName: ").append(toIndentedString(storageName)).append("\n");
    sb.append("    resources: ").append(toIndentedString(resources)).append("\n");
    sb.append("    outputFile: ").append(toIndentedString(outputFile)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
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
