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
import okhttp3.RequestBody;

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
     * @return Call&lt;ResponseBody&gt;
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
     * @return Call&lt;ResponseBody&gt;
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
     * @return Call&lt;ResponseBody&gt;
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
     * @return Call&lt;ResponseBody&gt;
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
     * @return Call&lt;ResponseBody&gt;
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
     * @return Call&lt;ResponseBody&gt;
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


    /**
     * Converts the HTML document (in request content) to the specified image format and uploads resulting file to storage.
     *
     * @param outFormat  (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.jpg) (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param resolution Resolution of resulting image. Default is 96 dpi. (optional)
     * @return Call&lt;ResponseBody&gt;
     */
    @retrofit2.http.FormUrlEncoded
    @PUT("html/convert/image/{outFormat}")
    Call<ResponseBody> PutConvertDocumentInRequestToImage(
            @retrofit2.http.Path("outFormat") String outFormat, @retrofit2.http.Query("outPath") String outPath, @retrofit2.http.Field("file\"; filename=\"file") RequestBody file, @retrofit2.http.Query("width") Integer width, @retrofit2.http.Query("height") Integer height, @retrofit2.http.Query("leftMargin") Integer leftMargin, @retrofit2.http.Query("rightMargin") Integer rightMargin, @retrofit2.http.Query("topMargin") Integer topMargin, @retrofit2.http.Query("bottomMargin") Integer bottomMargin, @retrofit2.http.Query("resolution") Integer resolution
    );

    /**
     * Converts the HTML document (in request content) to PDF and uploads resulting file to storage.
     *
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.pdf) (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @return Call&lt;ResponseBody&gt;
     */
    @retrofit2.http.FormUrlEncoded
    @PUT("html/convert/pdf")
    Call<ResponseBody> PutConvertDocumentInRequestToPdf(
            @retrofit2.http.Query("outPath") String outPath, @retrofit2.http.Field("file\"; filename=\"file") RequestBody file, @retrofit2.http.Query("width") Integer width, @retrofit2.http.Query("height") Integer height, @retrofit2.http.Query("leftMargin") Integer leftMargin, @retrofit2.http.Query("rightMargin") Integer rightMargin, @retrofit2.http.Query("topMargin") Integer topMargin, @retrofit2.http.Query("bottomMargin") Integer bottomMargin
    );

    /**
     * Converts the HTML document (in request content) to XPS and uploads resulting file to storage.
     *
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.xps) (required)
     * @param file A file to be converted. (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @return Call&lt;ResponseBody&gt;
     */
    @retrofit2.http.FormUrlEncoded
    @PUT("html/convert/xps")
    Call<ResponseBody> PutConvertDocumentInRequestToXps(
            @retrofit2.http.Query("outPath") String outPath, @retrofit2.http.Field("file\"; filename=\"file") RequestBody file, @retrofit2.http.Query("width") Integer width, @retrofit2.http.Query("height") Integer height, @retrofit2.http.Query("leftMargin") Integer leftMargin, @retrofit2.http.Query("rightMargin") Integer rightMargin, @retrofit2.http.Query("topMargin") Integer topMargin, @retrofit2.http.Query("bottomMargin") Integer bottomMargin
    );

    /**
     * Converts the HTML document (located on storage) to the specified image format and uploads resulting file to storage.
     *
     * @param name Document name. (required)
     * @param outFormat  (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.jpg) (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param resolution Resolution of resulting image. Default is 96 dpi. (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @return Call&lt;ResponseBody&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @PUT("html/{name}/convert/image/{outFormat}")
    Call<ResponseBody> PutConvertDocumentToImage(
            @retrofit2.http.Path("name") String name, @retrofit2.http.Path("outFormat") String outFormat, @retrofit2.http.Query("outPath") String outPath, @retrofit2.http.Query("width") Integer width, @retrofit2.http.Query("height") Integer height, @retrofit2.http.Query("leftMargin") Integer leftMargin, @retrofit2.http.Query("rightMargin") Integer rightMargin, @retrofit2.http.Query("topMargin") Integer topMargin, @retrofit2.http.Query("bottomMargin") Integer bottomMargin, @retrofit2.http.Query("resolution") Integer resolution, @retrofit2.http.Query("folder") String folder, @retrofit2.http.Query("storage") String storage
    );

    /**
     * Converts the HTML document (located on storage) to PDF and uploads resulting file to storage.
     *
     * @param name Document name. (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.pdf) (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @return Call&lt;ResponseBody&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @PUT("html/{name}/convert/pdf")
    Call<ResponseBody> PutConvertDocumentToPdf(
            @retrofit2.http.Path("name") String name, @retrofit2.http.Query("outPath") String outPath, @retrofit2.http.Query("width") Integer width, @retrofit2.http.Query("height") Integer height, @retrofit2.http.Query("leftMargin") Integer leftMargin, @retrofit2.http.Query("rightMargin") Integer rightMargin, @retrofit2.http.Query("topMargin") Integer topMargin, @retrofit2.http.Query("bottomMargin") Integer bottomMargin, @retrofit2.http.Query("folder") String folder, @retrofit2.http.Query("storage") String storage
    );

    /**
     * Converts the HTML document (located on storage) to XPS and uploads resulting file to storage.
     *
     * @param name Document name. (required)
     * @param outPath Full resulting filename (ex. /folder1/folder2/result.xps) (required)
     * @param width Resulting document page width in points (1/96 inch). (optional)
     * @param height Resulting document page height in points (1/96 inch). (optional)
     * @param leftMargin Left resulting document page margin in points (1/96 inch). (optional)
     * @param rightMargin Right resulting document page margin in points (1/96 inch). (optional)
     * @param topMargin Top resulting document page margin in points (1/96 inch). (optional)
     * @param bottomMargin Bottom resulting document page margin in points (1/96 inch). (optional)
     * @param folder The source document folder. (optional)
     * @param storage The source and resulting document storage. (optional)
     * @return Call&lt;ResponseBody&gt;
     */
    @Headers({
            "Content-Type:application/json"
    })
    @PUT("html/{name}/convert/xps")
    Call<ResponseBody> PutConvertDocumentToXps(
            @retrofit2.http.Path("name") String name, @retrofit2.http.Query("outPath") String outPath, @retrofit2.http.Query("width") Integer width, @retrofit2.http.Query("height") Integer height, @retrofit2.http.Query("leftMargin") Integer leftMargin, @retrofit2.http.Query("rightMargin") Integer rightMargin, @retrofit2.http.Query("topMargin") Integer topMargin, @retrofit2.http.Query("bottomMargin") Integer bottomMargin, @retrofit2.http.Query("folder") String folder, @retrofit2.http.Query("storage") String storage
    );

}
