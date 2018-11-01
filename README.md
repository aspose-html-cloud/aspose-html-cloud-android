# Aspose.HTML Cloud SDK for Android
This repository contains Aspose.HTML Cloud SDK for Android source code. This SDK allows you to work with Aspose.HTML Cloud REST APIs in your Android applications quickly and easily.

See [API Reference](https://apireference.aspose.cloud/html/) for full API specification.

## How to use the SDK?
The complete source code is available in this repository folder, you can either directly use it in your project.
   
This project includes:   
- Android dummy application - "/app"
- Module "html" - this SDK in "/html"
- Module "storage" - dependency for test in "/storage"

### Prerequisites

To use Aspose HTML for Cloud Android SDK you need to register an account with [Aspose Cloud](https://www.aspose.cloud/) and lookup/create App Key and SID at [Cloud Dashboard](https://dashboard.aspose.cloud/#/apps). There is free quota available. For more details, see [Aspose Cloud Pricing](https://purchase.aspose.cloud/pricing).

### Installation

Building the API client library requires [Gradle Build Tool](https://gradle.org/) to be installed.


To build the API client library, simply execute:

```shell
gradlew.bat
```

To run test from command string:
```shell
gradlew.bat test
```


### Sample usage

Before fill all fields in /setting/config.json   

Example:   
```json
{
    "basePath":"https://api.aspose.cloud/v1.1",
    "authPath":"https://api.aspose.cloud/oauth2/token",
    "apiKey":"XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX",
    "appSID":"XXXXXXXX-XXXX-XXXX-XXXX-XXXXXXXXXXXX",
    "srcTest": "sourceTest",
    "dstTest": "destTest",
    "defaultUserAgent": "Webkit",
    "debug": true
}
```

The examples below show how your application have to initiate and convert url to image using Aspose.HTML Cloud library:
```java
import java.io.*;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import com.aspose.html.android.api.ConversionApi;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


class TestConversion {


//...

    // Helper saver
    public static boolean saveToDisk(ResponseBody body, String fileName) {

        File savedFile = new File(Configuration.getTestDstDir() + File.separator + fileName);

        try (InputStream inputStream = body.byteStream();
             OutputStream outputStream = new FileOutputStream(savedFile))
        {
            byte[] fileReader = new byte[4096];
            long fileSizeDownloaded = 0;

            while (true) {
                int read = inputStream.read(fileReader);
                if (read == -1) break;

                outputStream.write(fileReader, 0, read);
                fileSizeDownloaded += read;
            }
            outputStream.flush();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public void Convert(){

        ConversionApi api = new ApiClient().createService(ConversionApi.class);
    
        String sourceUrl = "https://stallman.org/articles/anonymous-payments-thru-phones.html";
        String outFormat = "png"; // String | Resulting image format.
        Integer width = 800; // Integer | Resulting image width. 
        Integer height = 600; // Integer | Resulting image height. 
        Integer leftMargin = 10; // Integer | Left resulting image margin.
        Integer rightMargin = 10; // Integer | Right resulting image margin.
        Integer topMargin = 20; // Integer | Top resulting image margin.
        Integer bottomMargin = 20; // Integer | Bottom resulting image margin.
        Integer xResolution = 300; // Integer | Horizontal resolution of resulting image.
        Integer yResolution = 300; // Integer | Vertical resolution of resulting image.
        String folder = "MyFolder"; // String | The source document folder.
        String storage = "MyStorage"; // String | The source document storage.

        String fileName = "convertResult.jpg";
        
        try {
        Call<ResponseBody> call = api.GetConvertDocumentToImageByUrl(
            outFormat,
            sourceUrl,
            width,
            height,
            leftMargin,
            rightMargin,
            topMargin,
            bottomMargin,
            xResolution,
            yResolution,
            folder,
            storage);

/*
        // Sync request, don't use in main thread to avoid lock GUI
        Response<ResponseBody> res = call.execute();
        //Stream
        ResponseBody answer = res.body();
        boolean result = saveToDisk(answer, fileName);
        assertTrue(result);
*/
        // Async method
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Response<ResponseBody> res) {
                // Get result Repo from response.body()
                ResponseBody answer = res.body();        
                boolean result = saveToDisk(answer, fileName);
                assertTrue(result);
            }
         
            @Override
            public void onFailure(Throwable t) {
                fail();         
            }
        });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

# Documentation for API Endpoints

All URIs are relative to *https://api.aspose.cloud/v1.1*


## ConversionApi

Method | HTTP request | Description
------------- | ------------- | -------------
**GetConvertDocumentToImage** | **GET** html/{name}/convert/image/{outFormat} | Convert the HTML document from the storage by its name to the specified image format.
**GetConvertDocumentToImageByUrl** | **GET** html/convert/image/{outFormat} | Convert the HTML page from the web by its URL to the specified image format.
**GetConvertDocumentToPdf** | **GET** html/{name}/convert/pdf | Convert the HTML document from the storage by its name to PDF.
**GetConvertDocumentToPdfByUrl** | **GET** html/convert/pdf | Convert the HTML page from the web by its URL to PDF.
**GetConvertDocumentToXps** | **GET** html/{name}/convert/xps | Convert the HTML document from the storage by its name to XPS.
**GetConvertDocumentToXpsByUrl** | **GET** html/convert/xps | Convert the HTML page from the web by its URL to XPS.
**PutConvertDocumentInRequestToImage** | **PUT** html/convert/image/{outFormat} | Converts the HTML document (in request content) to the specified image format and uploads resulting file to storage.
**PutConvertDocumentInRequestToPdf** | **PUT** html/convert/pdf | Converts the HTML document (in request content) to PDF and uploads resulting file to storage.
**PutConvertDocumentInRequestToXps** | **PUT** html/convert/xps | Converts the HTML document (in request content) to XPS and uploads resulting file to storage.
**PutConvertDocumentToImage** | **PUT** html/{name}/convert/image/{outFormat} | Converts the HTML document (located on storage) to the specified image format and uploads resulting file to storage.
**PutConvertDocumentToPdf** | **PUT** html/{name}/convert/pdf | Converts the HTML document (located on storage) to PDF and uploads resulting file to storage.
**PutConvertDocumentToXps** | **PUT** html/{name}/convert/xps | Converts the HTML document (located on storage) to XPS and uploads resulting file to storage.

## DocumentApi

Method | HTTP request | Description
------------- | ------------- | -------------
**GetDocumentFragmentByXPath** | **GET** html/{name}/fragments/{outFormat} | Return list of HTML fragments matching the specified XPath query.
**GetDocumentFragmentByXPathByUrl** | **GET** html/fragments/{outFormat} | Return list of HTML fragments matching the specified XPath query by the source page URL.
**GetDocumentFragmentsByCSSSelector** | **GET** /html/{name}/fragments/css/{outFormat} | Return list of HTML fragments matching the specified CSS selector.
**GetDocumentFragmentsByCSSSelectorByUrl** | **GET** /html/fragments/css/{outFormat} | Return list of HTML fragments matching the specified CSS selector by the source page URL.
**GetDocumentImages** | **GET** html/{name}/images/all | Return all HTML document images packaged as a ZIP archive.
**GetDocumentImagesByUrl** | **GET** html/images/all | Return all HTML page images packaged as a ZIP archive by the source page URL.

## OcrApi

Method | HTTP request | Description
------------- | ------------- | -------------
**GetRecognizeAndImportToHtml** | **GET** html/{name}/ocr/import | Recognize text from the image file in the storage and import it to HTML format.
**GetRecognizeAndTranslateToHtml** | **GET** html/{name}/ocr/translate/{srcLang}/{resLang} | Recognize text from the image file in the storage, import it to HTML format and translate to specified language.

## TranslationApi

Method | HTTP request | Description
------------- | ------------- | -------------
**GetTranslateDocument** | **GET** html/{name}/translate/{srcLang}/{resLang} | Translate the HTML document specified by the name from default or specified storage. 
**GetTranslateDocumentByUrl** | **GET** html/translate/{srcLang}/{resLang} | Translate the HTML document from Web specified by its URL.

## SummarizationApi

Method | HTTP request | Description
------------- | ------------- | -------------
**GetDetectHtmlKeywords** | **GET** html/{name}/summ/keywords | Get the HTML document keywords using the keyword detection service.
**GetDetectHtmlKeywordsByUrl** | **GET** html/summ/keywords | Get the keywords from HTML document from Web specified by its URL using the keyword detection service

## TemplateMergeApi    

Method | HTTP request | Description
------------- | ------------- | -------------
*GetMergeHtmlTemplate* | **GET** /html/{templateName}/merge | Populate HTML document template with data located as a file in the storage.
*PutMergeHtmlTemplate* | **PUT** /html/{templateName}/merge | Populate HTML document template with data from the request body. Result document will be saved to storage.


[Tests](./html/src/test/java/com/aspose/html/android/) contain various examples of using the Aspose.HTML SDK for Android.

[Docs](./docs/) Full javadoc for Aspose.HTML Api SDK


Aspose HTML includes Aspose.Storage.Cloud to manipulate files on a remote server. This is used in tests for download test files to the server.

[Tests](./storage/src/test/java/com/aspose/storage/android/) contain various examples of using the Aspose.Storage SDK.

[Docs](./docs/)  Full javadoc for Aspose.Storage Api SDK


## Dependencies
[See build.gradle](./build.gradle)


## Contact Us
Your feedback is very important to us. Please feel free to contact us using our [Support Forums](https://forum.aspose.cloud/html).
