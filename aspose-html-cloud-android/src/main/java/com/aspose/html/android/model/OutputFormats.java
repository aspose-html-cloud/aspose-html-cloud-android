package com.aspose.html.android.model;

/**
 * Formats of the output files.
 */
public enum OutputFormats {
  JPEG("JPEG"),
  PNG("PNG"),
  BMP("BMP"),
  GIF("GIF"),
  TIFF("TIFF"),
  MD("MD"),
  HTML("HTML"),
  MHTML("MHTML"),
  PDF("PDF"),
  XPS("XPS"),
  DOC("DOC"),
  DOCX("DOCX"),
  SVG("SVG");

  private String value;

  OutputFormats(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static OutputFormats fromValue(String text) {
    for (OutputFormats b : OutputFormats.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
  
}
