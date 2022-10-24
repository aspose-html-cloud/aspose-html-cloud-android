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
		<url>https://repository.aspose.cloud/repo/</url>
	</repository>
	...
</repositories>

<dependencies>
     ...
	<dependency>
		<groupId>com.aspose</groupId>
		<artifactId>aspose-html-cloud-android</artifactId>
		<version>22.10.1</version>
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

# Documentation
All URIs are relative to *https://api.aspose.cloud/*

# Possible conversions:
- HTML -> PDF, XPS, DOCX, MD, MHTML, JPEG, BMP, PNG, TIFF, GIF
- EPUB -> PDF, XPS, DOCX, JPEG, BMP, PNG, TIFF, GIF
- MD -> PDF, XPS, DOCX, HTML, MHTML, JPEG, BMP, PNG, TIFF, GIF
- MHTML -> PDF, XPS, DOCX, JPEG, BMP, PNG, TIFF, GIF

## Conversion builder

| Method                                                   | Parameters                                                                             | Description                                     |
|----------------------------------------------------------|----------------------------------------------------------------------------------------|-------------------------------------------------|
| **fromLocalFile(String fileName)**                       | fileName - full path to a local file                                                   | A source is a file in a local file system.      |
| **fromStorageFile(String fileName)**                     | fileName - path to the file in the cloud storage                                       | A source is a file in the cloud (user storage). |
| **fromStorageFile(String fileName, String storageName)** | fileName - path to the file in the cloud storage. storageName - your storage, if exist | A source is a file in the cloud (user storage). |
| **fromUrl(String url)**                                  | url - URI for conversion.                                                              | Convert from url as source.                     |
| **saveToLocal(String fileName)**                         | fileName - full path to the result.                                                    | Recreating, if the file exists.                 |
| **saveToStorage(String fileName)**                       | fileName - full path to the result.                                                    | Recreating, if the file exists.                 |
| **saveToStorage(String fileName, String storageName)**   | fileName - full path to the result. storageName - your storage, if exist               | Recreating, if the file exists.                 |
| **useOptions(ConversionOptions options)**                | options - additional options for conversion.                                           | (optional)                                      |


### useOptions(ConversionOptions)

Specifies the output format for conversion.

| Options                                                                          | Description                                                               |
|----------------------------------------------------------------------------------|---------------------------------------------------------------------------|
| [ImageConversionOptions](docs/ConversionOptions.md#ImageConversionOptions)       | Converting source file or URL to single or several images.                |  
| [PDFConversionOptions](docs/ConversionOptions.md#PDFConversionOptions)           | Converting source file or URL to PDF.                                     |
| [XPSConversionOptions](docs/ConversionOptions.md#XPSConversionOptions)           | Converting source file or URL to XPS.                                     |
| [DOCConversionOptions](docs/ConversionOptions.md#DOCConversionOptions)           | Converting source file or URL to DOCX.                                    |
| [MarkdownConversionOptions](docs/ConversionOptions.md#MarkdownConversionOptions) | Converting source file or URL to Markdown.                                |

### SaveTo...

The target directory for a conversion result.

| Method                                | Parameters                                    | Description                                                          |
|---------------------------------------|-----------------------------------------------|----------------------------------------------------------------------|
| SaveToLocal(string outputDirectory)   | outputDirectory - directory to save a result. | A directory in the local file system to save a conversion result.    |
| SaveToStorage(string outputDirectory) | outputDirectory - directory to save a result. | A directory in the cloud (user storage) to save a conversion result. |

## ConversionResult

Result object for conversion.

| Field              | Description                                       |
|--------------------|---------------------------------------------------|
| String file        | A result file.                                    |
| String description | A description in case of unsuccessful conversion. |


[Tests](./aspose-html-cloud-android/src/test/java/com/aspose/html/android/) contain various examples of using the Aspose.HTML SDK for Android.


## Dependencies
[See build.gradle](./sdk/build.gradle)


## Contact Us   
Your feedback is very important to us. Please feel free to contact us using our [Support Forums](https://forum.aspose.cloud/html).
