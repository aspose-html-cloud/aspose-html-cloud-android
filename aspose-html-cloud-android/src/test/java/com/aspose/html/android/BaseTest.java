package com.aspose.html.android;

public class BaseTest {

    BaseTest(){
        Configuration.setAPI_KEY("html.cloud");
        Configuration.setAPP_SID("html.cloud");
//        Configuration.setBasePath("https://api-qa.aspose.cloud/v3.0");
        Configuration.setBasePath("http://localhost:5000/v3.0");
        Configuration.setAuthPath("https://api-qa.aspose.cloud/connect/token");
        Configuration.setUserAgent("WebKit");
        Configuration.setDebug(true);
        Configuration.setTestSrcDir("sourceTest");
        Configuration.setTestDstDir("destTest");
    }
}
