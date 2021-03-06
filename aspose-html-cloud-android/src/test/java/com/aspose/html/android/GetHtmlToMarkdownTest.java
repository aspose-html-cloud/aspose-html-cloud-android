/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="GetHtmlToMarkdownTest.java">
*   Copyright (c) 2019 Aspose.HTML for Cloud
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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.aspose.html.android.api.StorageApi;
import com.aspose.html.android.model.*;
import com.aspose.html.android.api.ConversionApi;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

@RunWith(Parameterized.class)
public class GetHtmlToMarkdownTest extends BaseTest{
    private final String  name;
    private final Boolean useGit;
    private final String folder;
    private final String storage;
    private final String resultName;
    private ConversionApi api;
    private StorageApi storageApi;

   //Constructor that takes test data.
    public GetHtmlToMarkdownTest(Boolean useGit)
    {
		this.name		    =	"test_md.html";			         
		this.useGit			=	useGit;       		  
		this.folder         =	"HtmlTestDoc";
		this.storage		=   null;

		String name = "GetHtmlToMarkdown_"; 
		
		if(useGit) {
			name += "usingGit";
		}else {
			name += "notUsingGit";
		}
		
		this.resultName = name + ".md"; 
    }
    
    @Before
	public void initialize() {
		api = new ApiClient().createService(ConversionApi.class);
		storageApi = new ApiClient().createService(StorageApi.class);
    }
    
    @Parameterized.Parameters
    public static Collection testData() {
    	//Use Git Markdown flavor test1 - true, test2 - false
    	return Arrays.asList(new Object[][]	{ {true}, {false} });
    }
    
    @Test
    public void test() {

    	try {
			TestHelper.uploadFile(name, folder);
			Call<ObjectExist> call = storageApi.objectExists(folder + "/" + name,	null, null);
			Response<ObjectExist> res = call.execute();
			assertTrue(res.isSuccessful());

			Call<ResponseBody> call_resp = api.GetConvertDocumentToMarkdown( name, useGit, folder, storage);

    		//Save to test directory
			TestHelper.checkAndSave(call_resp, resultName);
 
    		//Clear in the storage
			Call<Void> call_response = storageApi.deleteFile(folder + "/" + name, null, null);

			Response<Void> res2 = call_response.execute();
			assertTrue(res2.isSuccessful());
        }catch(Exception e) {
        	e.printStackTrace();
            fail();
        }
    }
}
