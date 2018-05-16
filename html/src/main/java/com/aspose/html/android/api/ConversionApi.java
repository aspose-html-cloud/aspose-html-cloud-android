/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="ConversionApi.java">
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

public interface ConversionApi {
    /**
     * Convert the HTML document from the storage by its name to the specified image format.
     *
     * @param name         Document name. (required)
     * @param outFormat    Resulting image format. (required)
     * @param width        Resulting image width.  (optional)
     * @param height       Resulting image height.  (optional)
     * @param leftMargin   Left resulting image margin. (optional)
     * @param rightMargin  Right resulting image margin. (optional)
     * @param topMargin    Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param xResolution  Horizontal resolution of resulting image. (optional)
     * @param yResolution  Vertical resolution of resulting image. (optional)
     * @param folder       The source document folder. (optional)
     * @param storage      The source document storage. (optional)
     * @return Call&lt;File&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/{name}/convert/image/{outFormat}")
    Call<ResponseBody> GetConvertDocumentToImage(
            @Path("name") String name,
            @Path("outFormat") String outFormat,
            @Query("width") Integer width,
            @Query("height") Integer height,
            @Query("leftMargin") Integer leftMargin,
            @Query("rightMargin") Integer rightMargin,
            @Query("topMargin") Integer topMargin,
            @Query("bottomMargin") Integer bottomMargin,
            @Query("xResolution") Integer xResolution,
            @Query("yResolution") Integer yResolution,
            @Query("folder") String folder,
            @Query("storage") String storage
    );

    /**
     * Convert the HTML page from the web by its URL to the specified image format.
     *
     * @param outFormat    Resulting image format. (required)
     * @param sourceUrl    Source page URL. (required)
     * @param width        Resulting image width.  (optional)
     * @param height       Resulting image height.  (optional)
     * @param leftMargin   Left resulting image margin. (optional)
     * @param rightMargin  Right resulting image margin. (optional)
     * @param topMargin    Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param xResolution  Horizontal resolution of resulting image. (optional)
     * @param yResolution  Vertical resolution of resulting image. (optional)
     * @param folder       The document folder. (optional)
     * @param storage      The document storage. (optional)
     * @return Call&lt;File&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/convert/image/{outFormat}")
    Call<ResponseBody> GetConvertDocumentToImageByUrl(
            @Path("outFormat") String outFormat,
            @Query("sourceUrl") String sourceUrl,
            @Query("width") Integer width,
            @Query("height") Integer height,
            @Query("leftMargin") Integer leftMargin,
            @Query("rightMargin") Integer rightMargin,
            @Query("topMargin") Integer topMargin,
            @Query("bottomMargin") Integer bottomMargin,
            @Query("xResolution") Integer xResolution,
            @Query("yResolution") Integer yResolution,
            @Query("folder") String folder,
            @Query("storage") String storage
    );

    /**
     * Convert the HTML document from the storage by its name to PDF.
     *
     * @param name         Document name. (required)
     * @param width        Resulting image width.  (optional)
     * @param height       Resulting image height.  (optional)
     * @param leftMargin   Left resulting image margin. (optional)
     * @param rightMargin  Right resulting image margin. (optional)
     * @param topMargin    Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder       The document folder. (optional)
     * @param storage      The document storage. (optional)
     * @return Call&lt;File&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/{name}/convert/pdf")
    Call<ResponseBody> GetConvertDocumentToPdf(
            @Path("name") String name,
            @Query("width") Integer width,
            @Query("height") Integer height,
            @Query("leftMargin") Integer leftMargin,
            @Query("rightMargin") Integer rightMargin,
            @Query("topMargin") Integer topMargin,
            @Query("bottomMargin") Integer bottomMargin,
            @Query("folder") String folder,
            @Query("storage") String storage
    );

    /**
     * Convert the HTML page from the web by its URL to PDF.
     *
     * @param sourceUrl    Source page URL. (required)
     * @param width        Resulting image width.  (optional)
     * @param height       Resulting image height.  (optional)
     * @param leftMargin   Left resulting image margin. (optional)
     * @param rightMargin  Right resulting image margin. (optional)
     * @param topMargin    Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder       The document folder. (optional)
     * @param storage      The document storage. (optional)
     * @return Call&lt;File&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/convert/pdf")
    Call<ResponseBody> GetConvertDocumentToPdfByUrl(
            @Query("sourceUrl") String sourceUrl,
            @Query("width") Integer width,
            @Query("height") Integer height,
            @Query("leftMargin") Integer leftMargin,
            @Query("rightMargin") Integer rightMargin,
            @Query("topMargin") Integer topMargin,
            @Query("bottomMargin") Integer bottomMargin,
            @Query("folder") String folder,
            @Query("storage") String storage
    );

    /**
     * Convert the HTML document from the storage by its name to XPS.
     *
     * @param name         Document name. (required)
     * @param width        Resulting image width.  (optional)
     * @param height       Resulting image height.  (optional)
     * @param leftMargin   Left resulting image margin. (optional)
     * @param rightMargin  Right resulting image margin. (optional)
     * @param topMargin    Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder       The document folder. (optional)
     * @param storage      The document storage. (optional)
     * @return Call&lt;File&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/{name}/convert/xps")
    Call<ResponseBody> GetConvertDocumentToXps(
            @Path("name") String name,
            @Query("width") Integer width,
            @Query("height") Integer height,
            @Query("leftMargin") Integer leftMargin,
            @Query("rightMargin") Integer rightMargin,
            @Query("topMargin") Integer topMargin,
            @Query("bottomMargin") Integer bottomMargin,
            @Query("folder") String folder,
            @Query("storage") String storage
    );

    /**
     * Convert the HTML page from the web by its URL to XPS.
     *
     * @param sourceUrl    Source page URL. (required)
     * @param width        Resulting image width.  (optional)
     * @param height       Resulting image height.  (optional)
     * @param leftMargin   Left resulting image margin. (optional)
     * @param rightMargin  Right resulting image margin. (optional)
     * @param topMargin    Top resulting image margin. (optional)
     * @param bottomMargin Bottom resulting image margin. (optional)
     * @param folder       The document folder. (optional)
     * @param storage      The document storage. (optional)
     * @return Call&lt;File&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @GET("html/convert/xps")
    Call<ResponseBody> GetConvertDocumentToXpsByUrl(
            @Query("sourceUrl") String sourceUrl,
            @Query("width") Integer width,
            @Query("height") Integer height,
            @Query("leftMargin") Integer leftMargin,
            @Query("rightMargin") Integer rightMargin,
            @Query("topMargin") Integer topMargin,
            @Query("bottomMargin") Integer bottomMargin,
            @Query("folder") String folder,
            @Query("storage") String storage
    );
}
