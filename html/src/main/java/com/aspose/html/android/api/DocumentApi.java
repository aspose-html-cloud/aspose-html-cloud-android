/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="DocumentApi.java">
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
import okhttp3.ResponseBody;

public interface DocumentApi {
    /**
     * Return the HTML document by the name from default or specified storage.
     *
     * @param name    The document name. (required)
     * @param storage The document folder (optional)
     * @param folder  The document folder. (optional)
     * @return Call&lt;File&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/{name}")
    Call<ResponseBody> GetDocument(
            @Path("name") String name,
            @Query("storage") String storage,
            @Query("folder") String folder
    );

    /**
     * Return list of HTML fragments matching the specified XPath query.
     *
     * @param name      The document name. (required)
     * @param outFormat Output format. Possible values: &#39;plain&#39; and &#39;json&#39;. (required)
     * @param xPath     XPath query string. (required)
     * @param storage   The document storage. (optional)
     * @param folder    The document folder. (optional)
     * @return Call&lt;File&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/{name}/fragments/{outFormat}")
    Call<ResponseBody> GetDocumentFragmentByXPath(
            @Path("name") String name,
            @Path("outFormat") String outFormat,
            @Query("xPath") String xPath,
            @Query("storage") String storage,
            @Query("folder") String folder
    );

    /**
     * Return all HTML document images packaged as a ZIP archive.
     *
     * @param name    The document name. (required)
     * @param folder  The document folder. (optional)
     * @param storage The document storage. (optional)
     * @return Call&lt;File&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/{name}/images/all")
    Call<ResponseBody> GetDocumentImages(
            @Path("name") String name,
            @Query("folder") String folder,
            @Query("storage") String storage
    );
}