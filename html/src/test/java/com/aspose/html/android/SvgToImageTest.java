/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="SvgToImageTest.java">
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

import com.aspose.html.android.api.ConversionApi;
import com.aspose.storage.android.api.StorageApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import okhttp3.ResponseBody;
import retrofit2.Call;

import static java.lang.System.out;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class SvgToImageTest extends BaseTest {

    private String name;
    private String outFormat;
    private Integer width;
    private Integer height;
    private Integer leftMargin;
    private Integer rightMargin;
    private Integer topMargin;
    private Integer bottomMargin;
    private Integer xResolution;
    private Integer yResolution;
    private String folder;
    private String storage;

    private String localName;
    private ConversionApi api;
    private StorageApi storageApi;


    //Constructor that takes test data.
    public SvgToImageTest(
            String outFormat,
            Integer width,
            Integer height,
            Integer leftMargin,
            Integer rightMargin,
            Integer topMargin,
            Integer bottomMargin,
            Integer xResolution,
            Integer yResolution
    ) {
        super();
        this.name = "testpage1.svg";
        this.outFormat = outFormat;
        this.width = width;
        this.height = height;
        this.leftMargin = leftMargin;
        this.rightMargin = rightMargin;
        this.topMargin = topMargin;
        this.bottomMargin = bottomMargin;
        this.xResolution = xResolution;
        this.yResolution = yResolution;
        this.folder = "HtmlTestDoc";
        this.storage = null;

        String savedName = "SwgToImg_";

        if (width != null && height != null) {
            savedName += width + "x" + height + "_";
        } else {
            savedName += "-------" + "_";
        }

        if (xResolution != null && yResolution != null) {
            savedName += xResolution + "x" + yResolution + "_";
        } else {
            savedName += "---x---_";
        }

        if (leftMargin != null) {
            savedName += "L" + leftMargin + "_";
        } else {
            savedName += "L---" + "_";
        }

        if (rightMargin != null) {
            savedName += "R" + rightMargin + "_";
        } else {
            savedName += "R---" + "_";
        }

        if (topMargin != null) {
            savedName += "T" + topMargin + "_";
        } else {
            savedName += "T---" + "_";
        }

        if (bottomMargin != null) {
            savedName += "B" + bottomMargin;
        } else {
            savedName += "B---";
        }

        this.localName = savedName + "." + outFormat;
    }

    @Before
    public void initialize() {
        api = new ApiClient().createService(ConversionApi.class);
        storageApi = new ApiClient().createService(StorageApi.class);
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]
                {
                        {"jpeg", null, null, null, null, null, null, null, null},
                        {"jpeg", 500, 500, null, null, null, null, null, null},
                        {"jpeg", 600, 600, null, null, null, null, null, null},
                        {"jpeg", 700, 700, 0, 0, 0, 0, 100, 100},
                        {"jpeg", 800, 800, 100, 100, 100, 100, 150, 150},
                        {"jpeg", 800, 1000, 150, 150, 150, 150, 200, 200},
                        {"jpeg", 800, 1200, 100, 100, 150, 150, 50, 50},
                        {"jpeg", 800, 1400, 100, 150, 200, 0, 50, 50},
                        {"jpeg", 800, 1600, 0, 0, 0, 0, 50, 50},

                        {"png", null, null, null, null, null, null, null, null},
                        {"png", 500, 500, null, null, null, null, null, null},
                        {"png", 600, 600, null, null, null, null, null, null},
                        {"png", 700, 700, 100, 100, 100, 100, 100, 100},
                        {"png", 800, 800, 150, 150, 150, 150, 150, 150},
                        {"png", 800, 1000, 50, 100, 150, 200, 200, 200},
                        {"png", 800, 1200, 200, 150, 100, 50, 50, 50},
                        {"png", 800, 1400, 50, 50, 50, 50, 50, 50},
                        {"png", 800, 1600, 100, 100, 100, 100, 50, 50},

                        {"bmp", null, null, null, null, null, null, null, null},
                        {"bmp", 500, 500, null, null, null, null, null, null},
                        {"bmp", 600, 600, null, null, null, null, null, null},
                        {"bmp", 700, 700, 50, 100, 150, 200, 100, 100},
                        {"bmp", 800, 800, 200, 150, 100, 50, 150, 150},
                        {"bmp", 800, 1000, 50, 50, 50, 50, 200, 200},
                        {"bmp", 800, 1200, 100, 100, 100, 100, 50, 50},
                        {"bmp", 800, 1400, 150, 100, 50, 0, 50, 50},
                        {"bmp", 800, 1600, 0, 0, 0, 0, 50, 50},

                        {"tiff", null, null, null, null, null, null, null, null},
                        {"tiff", 500, 500, null, null, null, null, null, null},
                        {"tiff", 600, 600, null, null, null, null, null, null},
                        {"tiff", 700, 700, 50, 100, 150, 200, 100, 100},
                        {"tiff", 800, 800, 200, 150, 100, 50, 150, 150},
                        {"tiff", 800, 1000, 50, 50, 50, 50, 200, 200},
                        {"tiff", 800, 1200, 100, 100, 100, 100, 50, 50},
                        {"tiff", 800, 1400, 150, 150, 150, 150, 50, 50},
                        {"tiff", 800, 1600, 0, 0, 0, 0, 50, 50}

                });
    }

    @Test
    public void test() {
        out.println("Test svg to image " + outFormat);
        try {

            TestHelper.uploadFile(name, folder);

            Call<ResponseBody> call = api.GetConvertDocumentToImage( name, outFormat, width, height, leftMargin,
                    rightMargin, topMargin, bottomMargin, xResolution, yResolution, folder, storage);

            TestHelper.checkAndSave(call, localName);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}