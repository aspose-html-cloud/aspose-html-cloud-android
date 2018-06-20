/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="OcrTest.java">
*   Copyright (c) 2018 Aspose.HTML for Cloud
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

import static java.lang.System.out;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import com.aspose.html.android.api.OcrApi;
import okhttp3.ResponseBody;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.aspose.storage.android.api.StorageApi;
import retrofit2.Call;

@RunWith(Parameterized.class)
public class OcrTest {
    private String name;
    private String ocrEngineLang;
    private String folder;
    private String storage;

    private OcrApi api;
    private StorageApi storageApi;

    private static String localName = Configuration.getTestDstDir();

    public OcrTest(String name, String ocrEngineLang) {
        this.name = name;
        this.ocrEngineLang = ocrEngineLang;
        this.folder = "HtmlTestDoc";
        this.storage = null;

        this.localName = "OcrDoc_" + name + "_" + ocrEngineLang + ".html";
    }

    @Before
    public void initialize() {
        api = new ApiClient().createService(OcrApi.class);
        storageApi = new ApiClient().createService(StorageApi.class);
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]
                {
                        {"test_ocr.png", "en"},
                        {"test_ocr.jpg", "en"}
                });
    }

    @Test
    public void test() {
        out.println("Test ocr ");
        try {
            TestHelper.uploadFile(name, folder);
            Call<ResponseBody> call = api.GetRecognizeAndImportToHtml(name, ocrEngineLang, folder, storage);
            TestHelper.checkAndSave(call, localName);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
