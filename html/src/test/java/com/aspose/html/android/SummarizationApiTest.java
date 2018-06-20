/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="SummarizationApiTest.java">
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
import com.aspose.html.android.api.SummarizationApi;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.fail;
import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * API tests for SummarizationApi
 */
public class SummarizationApiTest {

    private SummarizationApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(SummarizationApi.class);
    }

    /**
     * Get the HTML document keywords using the keyword detection service.
     *
     * 
     */
    @Test
    public void GetDetectHtmlKeywordsTest() {
        String name = "test_en.html";
        String folder = "HtmlTestDoc";
        String storage = null;
        String localName = "KeywordDoc.json";

        out.println("Test keyword document");

        try {
            TestHelper.uploadFile(name, folder);
            Call<ResponseBody> call = api.GetDetectHtmlKeywords( name, folder, storage);
            TestHelper.checkAndSave(call, localName);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    /**
     * Get the keywords from HTML document from Web specified by its URL using the keyword detection service
     *
     * 
     */
    @Test
    public void GetDetectHtmlKeywordsByUrlTest() {
        String sourceUrl = "https://www.le.ac.uk/oerresources/bdra/html/page_01.htm";
        String localName = "KeywordUrl.json";
        try {
            Call<ResponseBody> call = api.GetDetectHtmlKeywordsByUrl(sourceUrl );
            TestHelper.checkAndSave(call, localName);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
