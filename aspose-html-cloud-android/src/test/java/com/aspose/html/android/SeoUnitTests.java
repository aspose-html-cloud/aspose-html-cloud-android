/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="SeoUnitTests.java">
*   Copyright (c) 2020 Aspose.HTML for Cloud
* </copyright>
* <summary>
*   Permission is hereby granted, free of charge, to any person obtaining a copy
*  of this software and associated documentation files (the "Software"), to deal
*  in the Software without restriction, including without limitation the rights
*  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
*  copies of the Software, and to permit persons to whom the Software is
*  furnished to do so, subject to the following conditions:
*
*  The above copyright notice and this permission notice shall be included in all
*  copies or substantial portions of the Software.
*
*  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
*  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
*  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
*  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
*  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
*  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
*  SOFTWARE.
* </summary>
* --------------------------------------------------------------------------------------------------------------------
*/
package com.aspose.html.android;

import com.aspose.html.android.api.SeoApi;
import com.aspose.html.android.api.StorageApi;
import com.aspose.html.android.model.DiscUsage;
import com.aspose.html.android.model.FileVersions;
import com.aspose.html.android.model.FilesList;
import com.aspose.html.android.model.FilesUploadResult;
import com.aspose.html.android.model.ObjectExist;
import com.aspose.html.android.model.StorageExist;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class SeoUnitTests {

    public static SeoApi seoApi;

    public SeoUnitTests(){
        Configuration.setAPI_KEY("html.cloud");
        Configuration.setAPP_SID("html.cloud");
        Configuration.setBasePath("https://api-qa.aspose.cloud/v3.0");
        Configuration.setAuthPath("https://api-qa.aspose.cloud/connect/token");
        Configuration.setUserAgent("WebKit");
        Configuration.setDebug(true);
        Configuration.setTestSrcDir("sourceTest");
        Configuration.setTestDstDir("destTest");
        seoApi = new ApiClient().createService(SeoApi.class);
    }

    @Test
    public void seoWarning(){
        String sourceUrl = "https://edition.cnn.com/";
        Call<ResponseBody> call = seoApi.GetSeoWarning(sourceUrl);
        try {
            TestHelper.checkAndSave(call, "SeoWarning.json");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }
    @Test
    public void htmlWarning(){
        String sourceUrl = "https://edition.cnn.com/";
        Call<ResponseBody> call = seoApi.GetHtmlWarning(sourceUrl);
        try {
            TestHelper.checkAndSave(call, "HtmlWarning.json");
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }
}
