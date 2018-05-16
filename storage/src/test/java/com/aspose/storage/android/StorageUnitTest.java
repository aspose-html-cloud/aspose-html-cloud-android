/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="StorageUnitTest.java">
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


package com.aspose.storage.android;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.junit.Test;

import static org.junit.Assert.*;

import com.aspose.storage.android.api.StorageApi;
import com.aspose.storage.android.model.DiscUsageResponse;
import com.aspose.storage.android.model.FileExistResponse;
import com.aspose.storage.android.model.MoveFileResponse;
import com.aspose.storage.android.model.MoveFolderResponse;
import com.aspose.storage.android.model.RemoveFileResponse;
import com.aspose.storage.android.model.RemoveFolderResponse;
import com.aspose.storage.android.model.ResponseMessage;
import com.aspose.storage.android.model.FileVersionsResponse;
import com.aspose.storage.android.model.StorageExistResponse;
import retrofit2.Call;
import retrofit2.Response;

import java.io.File;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class StorageUnitTest {

    public static StorageApi storageApi = new ApiClient().createService(StorageApi.class);
    public StorageUnitTest(){}

    //File API
    @Test
    public void PutCreate(){

        ResponseMessage response = null;

        try {

            File f = new File(StorageApi.class.getResource("/test.txt").toURI());
            RequestBody requestFile = RequestBody.create( MediaType.parse("application/octet-stream"), f);

            Call<ResponseMessage> call = storageApi.PutCreate("TestFolder/test.txt",requestFile, null, null);

            Response<ResponseMessage> res = call.execute();
            assertTrue(res.isSuccessful());

            response = res.body();
            System.out.println(response);

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    public void GetDownload(){

        ResponseMessage res_create = null;
        ResponseBody res_download = null;
        try {


            // Upload test file
            File f = new File(StorageApi.class.getResource("/testDownload.jpg").toURI());
            RequestBody requestFile = RequestBody.create( MediaType.parse("application/octet-stream"), f);

            Call<ResponseMessage> call_create = storageApi.PutCreate("HtmlTestDoc/testDownload.jpg",requestFile, null, null);

            Response<ResponseMessage> res = call_create.execute();
            assertTrue(res.isSuccessful());

            res_create = res.body();
            System.out.println(res_create);


            Call<ResponseBody> call_download = storageApi.GetDownload("HtmlTestDoc/testDownload.jpg", null, null);

            Response<ResponseBody> res1 = call_download.execute();
            assertTrue(res1.isSuccessful());

            res_download = res1.body();
            System.out.println(res_download);

            assertTrue(TestHelper.saveToDisc(res_download,"TestResult.jpg"));

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    public void PostMoveFile(){

        ResponseMessage response_create = null;
        MoveFileResponse response_move = null;

        try {

            //Upload file
            File f = new File(StorageApi.class.getResource("/test.txt").toURI());
            RequestBody requestFile = RequestBody.create( MediaType.parse("application/octet-stream"), f);

            Call<ResponseMessage> call_create = storageApi.PutCreate("TestFolder/test.txt",requestFile, null, null);
            Response<ResponseMessage> res_create = call_create.execute();
            assertTrue(res_create.isSuccessful());

            response_create = res_create.body();
            System.out.println(response_create);

            // Move file
            Call<MoveFileResponse> call_move = storageApi.PostMoveFile("TestFolder/test.txt", "TestFolder/test_moved.txt", null, null, null);
            Response<MoveFileResponse> res_move = call_move.execute();
            assertTrue(res_move.isSuccessful());

            response_move = res_move.body();
            System.out.println(response_move);

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    public void DeleteFile(){

        RemoveFileResponse res_delete_body = null;
        ResponseMessage res_create_body= null;
        FileExistResponse res_exist_body = null;
        Response<FileExistResponse> res_exist;
        try {
            //Create test file
            File f = new File(StorageApi.class.getResource("/test.txt").toURI());
            RequestBody requestFile = RequestBody.create( MediaType.parse("application/octet-stream"), f);

            Call<ResponseMessage> call_create = storageApi.PutCreate("TestFolder/testDel.txt",requestFile, null, null);

            Response<ResponseMessage> res = call_create.execute();
            assertTrue(res.isSuccessful());

            res_create_body = res.body();
            System.out.println(res_create_body);

            // Check if the file exists
            Call<FileExistResponse> call = storageApi.GetIsExist("TestFolder/testDel.txt", null, null);

            res_exist = call.execute();
            assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            System.out.println(res_exist_body);
            assertTrue(res_exist_body.getFileExist().getIsExist());

            //Delete file
            Call<RemoveFileResponse> call_response = storageApi.DeleteFile("TestFolder/testDel.txt", null,null);

            Response<RemoveFileResponse> res2 = call_response.execute();
            assertTrue(res2.isSuccessful());

            res_delete_body = res2.body();
            System.out.println(res_delete_body);

            // Check if the file not exists
            call = storageApi.GetIsExist("TestFolder/testDel.txt", null, null);

            res_exist = call.execute();
            assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            System.out.println(res_exist_body);
            assertFalse(res_exist_body.getFileExist().getIsExist());


        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    //Folder API
    @Test
    public void GetListFiles(){

        ResponseBody response = null;

        try {
            Call<ResponseBody> call = storageApi.GetListFiles("HtmlTestDoc", null);
            Response<ResponseBody> res = call.execute();
            assertTrue(res.isSuccessful());

            response = res.body();
            System.out.println(response);

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    public void PutCreateFolder(){

        ResponseMessage response = null;

        try {
            Call<ResponseMessage> call = storageApi.PutCreateFolder("TestFolder",null,null);

            Response<ResponseMessage> res = call.execute();
            assertTrue(res.isSuccessful());

            response = res.body();
            System.out.println(response);

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    public void PostMoveFolder(){

        ResponseMessage response_create = null;
        MoveFolderResponse response_move = null;

        try {

            //Create folder
            Call<ResponseMessage> call_create = storageApi.PutCreateFolder("TestFolder", null, null);
            Response<ResponseMessage> res_create = call_create.execute();
            assertTrue(res_create.isSuccessful());

            response_create = res_create.body();
            System.out.println(response_create);

            // Move folder
            Call<MoveFolderResponse> call_move = storageApi.PostMoveFolder("TestFolder", "MoveTestFolder", "", "");
            Response<MoveFolderResponse> res_move = call_move.execute();
            assertTrue(res_move.isSuccessful());

            response_move = res_move.body();
            System.out.println(response_move);

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    public void DeleteFolder(){

        RemoveFolderResponse res_delete_body = null;
        ResponseMessage res_create_body = null;

        try {

            //Create remote folder
            Call<ResponseMessage> call_create = storageApi.PutCreateFolder("TestDeleteFolder",null,null);

            Response<ResponseMessage> res = call_create.execute();
            assertTrue(res.isSuccessful());

            res_create_body = res.body();
            System.out.println(res_create_body);

            Call<RemoveFolderResponse> call_response = storageApi.DeleteFolder("TestDeleteFolder", null, false);

            Response<RemoveFolderResponse> res1 = call_response.execute();
            assertTrue(res.isSuccessful());

            res_delete_body = res1.body();
            System.out.println(res_delete_body);

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    //Storage API    
    @Test
    public void GetIsStorageExist(){

        StorageExistResponse response = null;

        try {
            Call<StorageExistResponse> call = storageApi.GetIsStorageExist("/");

            Response<StorageExistResponse> res = call.execute();
            assertTrue(res.isSuccessful());

            response = res.body();
            System.out.println(response);

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    public void GetIsExist(){

        FileExistResponse response = null;
        try {
            Call<FileExistResponse> call = storageApi.GetIsExist("TestFolder/test.txt", null, null);

            Response<FileExistResponse> res = call.execute();
            assertTrue(res.isSuccessful());

            response = res.body();
            System.out.println(response);

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    public void GetDiscUsage(){

        DiscUsageResponse response = null;

        try {
            Call<DiscUsageResponse> call = storageApi.GetDiscUsage(null);

            Response<DiscUsageResponse> res = call.execute();
            assertTrue(res.isSuccessful());

            response = res.body();
            System.out.println(response);

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }

    @Test
    public void GetListFileVersions(){
        FileVersionsResponse response = null;

        try {
            Call<FileVersionsResponse> call = storageApi.GetListFileVersions("TestFolder/test.txt", null);
            Response<FileVersionsResponse> res = call.execute();
            assertTrue(res.isSuccessful());

            response = res.body();
            System.out.println(response);

        } catch (Exception ex) {
            ex.printStackTrace();
            fail();
        }
    }
}
