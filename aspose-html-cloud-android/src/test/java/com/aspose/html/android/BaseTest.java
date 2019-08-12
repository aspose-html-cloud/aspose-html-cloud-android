package com.aspose.html.android;

public class BaseTest {

    BaseTest(){
        Configuration.setAPI_KEY("html.cloud");
        Configuration.setAPP_SID("html.cloud");
        Configuration.setBasePath("https://api-qa.aspose.cloud/v3.0");
        Configuration.setAuthPath("https://api-qa.aspose.cloud/connect/token");

//        Configuration.setAPI_KEY("60487a72d6325241191177e37ae52146");
//        Configuration.setAPP_SID("80e32ca5-a828-46a4-9d54-7199dfd3764a");
//        Configuration.setBasePath("https://api-qa.aspose.cloud/v1.1");
//        Configuration.setBasePath("http://sikorsky-js3.dynabic.com:9083/v1.1");
//        Configuration.setAuthPath("https://api-qa.aspose.cloud/oauth2/token");
//        Configuration.setAuthPath("http://sikorsky-js3.dynabic.com:9083/oauth2/token");
        Configuration.setUserAgent("WebKit");
        Configuration.setDebug(true);
        Configuration.setTestSrcDir("sourceTest");
        Configuration.setTestDstDir("destTest");
    }
}
