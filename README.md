# Aspose.HTML Cloud SDK for Android
This repository contains Aspose.HTML Cloud SDK for Android source code. This SDK allows you to work with Aspose.HTML Cloud REST APIs in your Android applications quickly and easily.

See [API Reference](https://apireference.aspose.cloud/html/) for full API specification.


## How to use the SDK?
The complete source code is available in this repository folder, you can either directly use it in your project.
   
This project includes:   
- Android dummy application - "/app"
- Module "sdk" - this SDK in "/aspose-html-cloud-android"


### Prerequisites
To use Aspose HTML for Cloud Android SDK you need to register an account with [Aspose Cloud](https://www.aspose.cloud/) and lookup/create App Key and SID at [Cloud Dashboard](https://dashboard.aspose.cloud/#/apps). There is free quota available. For more details, see [Aspose Cloud Pricing](https://purchase.aspose.cloud/pricing).


### Installation

Get ready package or build from source.

#### Maven users
Add this dependency to your project's POM:

```xml
<repositories>
    ...
	<repository>
		<id>AsposeJavaAPI</id>
		<name>Aspose Java API</name>
		<url>https://releases.aspose.cloud/java/repo/</url>
	</repository>
	...
</repositories>

<dependencies>
     ...
	<dependency>
		<groupId>com.aspose</groupId>
		<artifactId>aspose-html-cloud-android</artifactId>
		<version>22.12.1</version>
		<scope>compile</scope>
	</dependency>
	...
</dependencies>
```

Building the API client library requires [Gradle Build Tool](https://gradle.org/) to be installed.

To build the API client library, simply execute:

```shell
gradlew.bat build -x test //skip tests
```
It needs JDK-11 or bigger. Use JDK from the command line

```shell
gradle build -Dorg.gradle.java.home=e:/UTILS/Java/jdk-17/
```

To run test from command string:
```shell
gradlew.bat test
```


### Convert URL tp PDF format

```java
package com.aspose.test_package;

import com.aspose.html.Configuration;
import com.aspose.html.ConverterBuilder;
import com.aspose.html.model.OperationResult;
import com.aspose.html.options.PDFConversionOptions;

import java.io.File;

public class App {


    public static void main(String[] args) {

// Get keys from aspose site.
// There is free quota available. 
// For more details, see https://purchase.aspose.cloud/pricing

        Configuration.setBasePath("https://api.aspose.cloud");
        Configuration.setAuthPath("https://api.aspose.cloud/connect/token");
        Configuration.setUserAgent("WebKit");
        Configuration.setDebug(true);

        HtmlApi api = new HtmlApi("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX");


        String inputUrl = "https://stallman.org/articles/anonymous-payments-thru-phones.html";
        String outputFile = "c:/temp/Output.pdf";

        File f = new File(outputFile);
        if (f.exists()) f.delete();

        PDFConversionOptions opt_A5 = new PDFConversionOptions()
                .setWidth(5.8)
                .setHeight(8.3)
                .setTopMargin(0.5)
                .setBottomMargin(0.5)
                .setLeftMargin(0.5)
                .setRightMargin(0.5)
                .setQuality(95);

        JobBuilder builder = new ConverterBuilder()
                .fromUrl(inputUrl)
                .useOptions(opt)
                .saveToLocal(outputFile);

        OperationResult result = api.convert(builder);

        String f = result.getFile();

        File dst = new File(result.getFile());

        if (dst.exists()) {
            System.out.println("Result file is " + dst);
        } else {
            System.out.println("Error conversion");
        }
    }
}
```


### Vectorize the image to SVG format

```java
package com.aspose.test_package;

import com.aspose.html.Configuration;
import com.aspose.html.VectorizationBuilder;
import com.aspose.html.model.OperationResult;
import com.aspose.html.options.VectorizationOptions;

import java.io.File;

public class App {


    public static void main(String[] args) {

// Get keys from aspose site.
// There is free quota available. 
// For more details, see https://purchase.aspose.cloud/pricing

        Configuration.setBasePath("https://api.aspose.cloud");
        Configuration.setAuthPath("https://api.aspose.cloud/connect/token");
        Configuration.setUserAgent("WebKit");
        Configuration.setDebug(true);

        HtmlApi api = new HtmlApi("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", "XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX");


        VectorizationOptions opts = new VectorizationOptions()
                .setErrorThreshold(50)
                .setColorLimit(30)
                .setLineWidth(1.5)
                .setMaxIteration(10);

        JobBuilder builder = new VectorizationBuilder()
                .fromLocalFile("/path/to/input/file.png")
                .useOptions(opts)
                .saveToLocal("/path/to/output/file.svg");

        OperationResult result = api.vectorize(builder);
        File dst = new File(result.getFile());

        if (dst.exists()) {
            System.out.println("Result file is " + dst);
        } else {
            System.out.println("Error vectorization");
        }
    }
}
```


# Documentation
All URIs are relative to *https://api.aspose.cloud/*

# Possible conversions:
- HTML -> PDF, XPS, DOCX, MD, MHTML, JPEG, BMP, PNG, TIFF, GIF
- EPUB -> PDF, XPS, DOCX, JPEG, BMP, PNG, TIFF, GIF
- MD -> PDF, XPS, DOCX, HTML, MHTML, JPEG, BMP, PNG, TIFF, GIF
- MHTML -> PDF, XPS, DOCX, JPEG, BMP, PNG, TIFF, GIF
- SVG -> PDF, XPS, JPEG, BMP, PNG, TIFF, GIF
- JPEG, BMP, PNG, TIFF, GIF -> SVG


## JobBuilder (VectorizationBuilder, ConverterBuilder)

| Method                                                   | Parameters                                                                             | Description                                     |
|----------------------------------------------------------|----------------------------------------------------------------------------------------|-------------------------------------------------|
| **fromLocalFile(String fileName)**                       | fileName - full path to a local file                                                   | A source is a file in a local file system.      |
| **fromStorageFile(String fileName)**                     | fileName - path to the file in the cloud storage                                       | A source is a file in the cloud (user storage). |
| **fromStorageFile(String fileName, String storageName)** | fileName - path to the file in the cloud storage. storageName - your storage, if exist | A source is a file in the cloud (user storage). |
| **fromUrl(String url)**                                  | url - URI for conversion.                                                              | Convert from url as source.                     |
| **saveToLocal(String fileName)**                         | fileName - full path to the result.                                                    | Recreating, if the file exists.                 |
| **saveToStorage(String fileName)**                       | fileName - full path to the result.                                                    | Recreating, if the file exists.                 |
| **saveToStorage(String fileName, String storageName)**   | fileName - full path to the result. storageName - your storage, if exist               | Recreating, if the file exists.                 |
| **useOptions(Options options)**                | options - additional options for operation.                                            | (optional)                                      |

### useOptions(Options)

Specifies the output format for operation.

| Options                                                                          | Description                                      |
|----------------------------------------------------------------------------------|--------------------------------------------------|
| [ImageConversionOptions](docs/Options.md#ImageConversionOptions)       | Converting source file or URL to single or several images. |
| [PDFConversionOptions](docs/Options.md#PDFConversionOptions)           | Converting source file or URL to PDF.                      |
| [XPSConversionOptions](docs/Options.md#XPSConversionOptions)           | Converting source file or URL to XPS.                      |
| [DOCConversionOptions](docs/Options.md#DOCConversionOptions)           | Converting source file or URL to DOCX.                     |
| [MarkdownConversionOptions](docs/Options.md#MarkdownConversionOptions) | Converting source file or URL to Markdown.                 |
| [VectorizationOptions](docs/Options.md#VectorizationOptions)           | Vectorize images to SVG (trace image).                     |

### SaveTo...

The target directory for a result.

| Method                                | Parameters                                    | Description                                               |
|---------------------------------------|-----------------------------------------------|-----------------------------------------------------------|
| SaveToLocal(string outputDirectory)   | outputDirectory - directory to save a result. | A directory in the local file system to save a result.    |
| SaveToStorage(string outputDirectory) | outputDirectory - directory to save a result. | A directory in the cloud (user storage) to save a result. |

## OperationResult

Result object for operation.

| Field              | Description                                       |
|--------------------|---------------------------------------------------|
| String file        | A result file.                                    |
| String description | A description in case of unsuccessful operation.  |

[Tests](./aspose-html-cloud-android/src/test/java/com/aspose/html/android/) contain various examples of using the Aspose.HTML SDK for Android.


## Dependencies
[See build.gradle](./aspose-html-cloud-android/build.gradle)


## Contact Us   
Your feedback is very important to us. Please feel free to contact us using our [Support Forums](https://forum.aspose.cloud/html).
