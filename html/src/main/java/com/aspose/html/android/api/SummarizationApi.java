/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="SummarizationApi.java">
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

package com.aspose.html.android.api;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SummarizationApi {
  /**
   * Get the HTML document keywords using the keyword detection service.
   * 
   * @param name Document name. (required)
   * @param folder Document folder. (optional)
   * @param storage Document storage. (optional)
   * @return Call&lt;File&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("html/{name}/summ/keywords")
  Call<ResponseBody> GetDetectHtmlKeywords(
    @retrofit2.http.Path("name") String name, @retrofit2.http.Query("folder") String folder, @retrofit2.http.Query("storage") String storage
  );

  /**
   * Get the keywords from HTML document from Web specified by its URL using the keyword detection service
   * 
   * @param sourceUrl Source document URL. (required)
   * @return Call&lt;File&gt;
   */
  @Headers({
    "Content-Type:application/json"
  })
  @GET("html/summ/keywords")
  Call<ResponseBody> GetDetectHtmlKeywordsByUrl(
    @retrofit2.http.Query("sourceUrl") String sourceUrl
  );

}
