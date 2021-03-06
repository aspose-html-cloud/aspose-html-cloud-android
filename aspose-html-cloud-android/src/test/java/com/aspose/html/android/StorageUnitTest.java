/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="StorageUnitTest.java">
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

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.MultipartBody;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

import com.aspose.html.android.api.StorageApi;
import com.aspose.html.android.model.DiscUsage;
import com.aspose.html.android.model.FileVersions;
import com.aspose.html.android.model.FilesList;
import com.aspose.html.android.model.FilesUploadResult;
import com.aspose.html.android.model.ObjectExist;
import com.aspose.html.android.model.StorageExist;
import retrofit2.Call;
import retrofit2.Response;
import java.io.File;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class StorageUnitTest {

    public static StorageApi storageApi;

    public StorageUnitTest(){
        Configuration.setAPI_KEY("html.cloud");
        Configuration.setAPP_SID("html.cloud");
        Configuration.setBasePath("https://api-qa.aspose.cloud/v3.0");
        Configuration.setAuthPath("https://api-qa.aspose.cloud/connect/token");
        Configuration.setUserAgent("WebKit");
        Configuration.setDebug(true);
        Configuration.setTestSrcDir("sourceTest");
        Configuration.setTestDstDir("destTest");
        storageApi = new ApiClient().createService(StorageApi.class);
    }

    //File API
    @Test
    public void uploadFile(){

        try {
            File f = new File(Configuration.getTestSrcDir(), "test.txt");
            RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), f);
            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", f.getName(), requestBody);
            Call<FilesUploadResult> call = storageApi.uploadFile("HtmlTestDoc/test.txt",fileToUpload, null);

            Response<FilesUploadResult> res = call.execute();

            Assert.assertTrue(res.isSuccessful());

            FilesUploadResult result = res.body();

            assertEquals(1, result.getUploaded().size());
            assertEquals(0, result.getErrors().size());
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void downloadFile(){

        try {
            // Upload test file
            File f = new File(Configuration.getTestSrcDir(), "testDownload.jpg");
            RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), f);
            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", f.getName(), requestBody);

            Call<FilesUploadResult> call_create = storageApi.uploadFile("HtmlTestDoc/testDownload.jpg",fileToUpload, null);

            Response<FilesUploadResult> res = call_create.execute();
            Assert.assertTrue(res.isSuccessful());

            FilesUploadResult result = res.body();
            assertEquals(1, result.getUploaded().size());
            assertEquals(0, result.getErrors().size());

            Call<ResponseBody> call_download = storageApi.downloadFile("HtmlTestDoc/testDownload.jpg", null, null);

            Response<ResponseBody> res1 = call_download.execute();
            Assert.assertTrue(res1.isSuccessful());

            ResponseBody res_download = res1.body();
            Assert.assertTrue(TestHelper.saveToDisc(res_download,"TestDownloadResult.jpg"));
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void moveFile(){

        try {
            //Upload file
            File f = new File(Configuration.getTestSrcDir(), "test.txt");
            RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), f);
            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", f.getName(), requestBody);

            Call<FilesUploadResult> call_create = storageApi.uploadFile("HtmlTestDoc/test_moving_file.txt", fileToUpload, null);
            Response<FilesUploadResult> res_create = call_create.execute();
            Assert.assertTrue(res_create.isSuccessful());

            FilesUploadResult result = res_create.body();
            assertEquals(1, result.getUploaded().size());
            assertEquals(0, result.getErrors().size());

            // Move file
            Call<Void> call_move = storageApi.moveFile("HtmlTestDoc/test_moving_file.txt",
                    "HtmlTestDoc/test_moved_file.txt", null, null, null);
            Response<Void> res_move = call_move.execute();
            Assert.assertTrue(res_move.isSuccessful());

            // Check if the new file exists
            Call<ObjectExist> call = storageApi.objectExists("HtmlTestDoc/test_moved_file.txt", null, null);

            Response<ObjectExist> res_exist = call.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            ObjectExist res_exist_body = res_exist.body();
            Assert.assertTrue("Error, moved new file not exis",res_exist_body.isExists());
            Assert.assertFalse("Error, must be file, not folder", res_exist_body.isFolder());

            // Check if the old file not exists
            call = storageApi.objectExists("HtmlTestDoc/test_moving_file.txt",
                    null, null);

            res_exist = call.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assert.assertFalse("Error, moving old file exist",res_exist_body.isExists());
            Assert.assertFalse("Error, must be file, not folder", res_exist_body.isFolder());

        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void deleteFile(){

        try {
            //Create test file
            File f = new File(Configuration.getTestSrcDir(), "test.txt");
            RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), f);
            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", f.getName(), requestBody);

            Call<FilesUploadResult> call_create = storageApi.uploadFile("HtmlTestDoc/test_delete_file.txt",fileToUpload, null);

            Response<FilesUploadResult> res = call_create.execute();
            Assert.assertTrue(res.isSuccessful());

            FilesUploadResult result = res.body();
            assertEquals(1, result.getUploaded().size());
            assertEquals(0, result.getErrors().size());

            // Check if the file exists
            Call<ObjectExist> call = storageApi.objectExists("HtmlTestDoc/test_delete_file.txt",
                    null, null);

            Response<ObjectExist> res_exist = call.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            ObjectExist res_exist_body = res_exist.body();
            Assert.assertTrue("Error, must be exist, not exist",res_exist_body.isExists());
            Assert.assertFalse("Error, must be file, not folder", res_exist_body.isFolder());

            //Delete file
            Call<Void> call_response = storageApi.deleteFile("HtmlTestDoc/test_delete_file.txt", null,null);

            Response<Void> res2 = call_response.execute();
            Assert.assertTrue(res2.isSuccessful());

            // Check if the file not exists
            call = storageApi.objectExists("HtmlTestDoc/test_delete_file.txt",
                    null, null);

            res_exist = call.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assert.assertFalse("Error, file exist after delete",res_exist_body.isExists());
            Assert.assertFalse("Error, must be false, file not exist", res_exist_body.isFolder());
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }

    //Folder API
    @Test
    public void getFilesList(){

        try {
            Call<FilesList> call = storageApi.getFilesList("HtmlTestDoc", null);
            Response<FilesList> res = call.execute();
            Assert.assertTrue(res.isSuccessful());

            FilesList response = res.body();
            Assert.assertTrue(TestHelper.saveToDisc(response.toString(),"FileList.json"));

        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void createFolder(){

        try {
            String folderName = "CreateTestFolder";
            Call<Void> call = storageApi.createFolder(folderName,null);

            Response<Void> res = call.execute();
            Assert.assertTrue(res.isSuccessful());

            // Check is folder exist
            Call<ObjectExist> call_exist = storageApi.objectExists(folderName,
                    null, null);

            Response<ObjectExist> res_exist = call_exist.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            ObjectExist res_exist_body = res_exist.body();
            Assert.assertTrue("Error, must be exist folder after creating",res_exist_body.isExists());
            Assert.assertTrue("Error, must be folder, not folder", res_exist_body.isFolder());

            //Delete test folder
            Call<Void> call_response = storageApi.deleteFolder(folderName, null, false);
            Response<Void> res1 = call_response.execute();
            Assert.assertTrue(res1.isSuccessful());

            //Check deleted folder
            call_exist = storageApi.objectExists(folderName,null, null);

            res_exist = call_exist.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assert.assertFalse("Error, must be  not exist folder after deleting", res_exist_body.isExists());
            Assert.assertFalse("Error, must be false after deleting folder", res_exist_body.isFolder());
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void moveFolder(){

        String movingFolder = "TestMovingFolder";
        String movedFolder = "TestMovedFolder";

        try {
            //Create folder
            Call<Void> call_create = storageApi.createFolder(movingFolder, null);
            Response<Void> res_create = call_create.execute();
            Assert.assertTrue(res_create.isSuccessful());

            // Move folder
            Call<Void> call_move = storageApi.moveFolder(movingFolder, movedFolder, "", "");
            Response<Void> res_move = call_move.execute();
            Assert.assertTrue(res_move.isSuccessful());

            //Checking is new folder exists.
            Call<ObjectExist> call_exist = storageApi.objectExists(movedFolder,
                    null, null);

            Response<ObjectExist> res_exist = call_exist.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            ObjectExist res_exist_body = res_exist.body();
            Assert.assertTrue("Error, must be exist new folder after moved",res_exist_body.isExists());
            Assert.assertTrue("Error, must be folder after moved", res_exist_body.isFolder());

            //Checking is old folder deleted.
            call_exist = storageApi.objectExists(movingFolder,null, null);

            res_exist = call_exist.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assert.assertFalse("Error, must be not exist old folder after moved",res_exist_body.isExists());
            Assert.assertFalse("Error, must be false after moved", res_exist_body.isFolder());

            //Delete moved folder
            Call<Void> call_delete = storageApi.deleteFolder(movedFolder, null, true);
            Response<Void> res_delete = call_delete.execute();
            Assert.assertTrue(res_delete.isSuccessful());

            //Ensure moved folder is deleted
            call_exist = storageApi.objectExists(movedFolder,null, null);

            res_exist = call_exist.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assert.assertFalse("Error, must be not exist new folder after delete",res_exist_body.isExists());
            Assert.assertFalse("Error, must be false after delete", res_exist_body.isFolder());
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void deleteFolder(){

        try {

            String folderName = "TestDeleteFolder";

            //Create remote folder
            Call<Void> call_create = storageApi.createFolder(folderName,null);

            Response<Void> res = call_create.execute();
            Assert.assertTrue(res.isSuccessful());

            //Ensure is folder exist
            Call<ObjectExist> call_exist = storageApi.objectExists(folderName,
                    null, null);

            Response<ObjectExist> res_exist = call_exist.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            ObjectExist res_exist_body = res_exist.body();
            Assert.assertTrue("Error, must be exist new folder after create",res_exist_body.isExists());
            Assert.assertTrue("Error, must be folder after create", res_exist_body.isFolder());

            Call<Void> call_response = storageApi.deleteFolder(folderName, null, true);

            Response<Void> res1 = call_response.execute();
            Assert.assertTrue(res.isSuccessful());

            //Ensure is folder deleted
            call_exist = storageApi.objectExists(folderName,null, null);

            res_exist = call_exist.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assert.assertFalse("Error, must be not exist new folder after delete",res_exist_body.isExists());
            Assert.assertFalse("Error, must be false after delete", res_exist_body.isFolder());
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }

    //Storage API    
    @Test
    public void storageExists(){

        String storageNotExist = "NotExistStorage";
        String storageExist = "/";

        try {
            Call<StorageExist> call = storageApi.storageExists(storageNotExist);
            Response<StorageExist> res = call.execute();
            Assert.assertTrue(res.isSuccessful());

            StorageExist result = res.body();
            Assert.assertFalse("Stotage not exist, but result is exist", result.isExists());

            //ToDo: Storage not defined
//            call = storageApi.storageExists(storageExist);
//            res = call.execute();
//            assertTrue(res.isSuccessful());

//            result = res.body();
//            assertTrue("Stotage exist, but result is not exist", result.isExists());
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void objectExists(){

        String existFile = "HtmlTestDoc/test.txt";
        String notExistFile = "HtmlTestDoc/fake.txt";
        String existFolder = "HtmlTestDoc";
        String notExistFolder = "FakeFolder";

        try {
            // Upload file
            File f = new File(Configuration.getTestSrcDir(), "test.txt");
            RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), f);
            MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", f.getName(), requestBody);
            Call<FilesUploadResult> call_upload = storageApi.uploadFile("HtmlTestDoc/test.txt",fileToUpload, null);

            Response<FilesUploadResult> res = call_upload.execute();

            Assert.assertTrue(res.isSuccessful());

            FilesUploadResult result = res.body();

            assertEquals(1, result.getUploaded().size());
            assertEquals(0, result.getErrors().size());

            // Exist file
            Call<ObjectExist> call = storageApi.objectExists(existFile, null, null);

            Response<ObjectExist> res_exist = call.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            ObjectExist res_exist_body = res_exist.body();
            Assert.assertTrue("Error, must be exist ",res_exist_body.isExists());
            Assert.assertFalse("Error, must be file, not folder", res_exist_body.isFolder());

            // Not exist file
            call = storageApi.objectExists(notExistFile, null, null);

            res_exist = call.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assert.assertFalse("Error, must be not exist ",res_exist_body.isExists());
            Assert.assertFalse("Error, must be false for not exist file", res_exist_body.isFolder());

            // Exist folder
            call = storageApi.objectExists(existFolder, null, null);

            res_exist = call.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assert.assertTrue("Error, must be exist ",res_exist_body.isExists());
            Assert.assertTrue("Error, must be folder", res_exist_body.isFolder());

            // Not exist folder
            call = storageApi.objectExists(notExistFolder, null, null);

            res_exist = call.execute();
            Assert.assertTrue(res_exist.isSuccessful());

            res_exist_body = res_exist.body();
            Assert.assertFalse("Error, must be not exist ",res_exist_body.isExists());
            Assert.assertFalse("Error, must be false for not exist folder", res_exist_body.isFolder());

            // Delete test file
            Call<Void> call_response = storageApi.deleteFile("HtmlTestDoc/test.txt", null,null);

            Response<Void> res2 = call_response.execute();
            Assert.assertTrue(res2.isSuccessful());
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getDiscUsage(){

        try {
            Call<DiscUsage> call = storageApi.getDiscUsage(null);

            Response<DiscUsage> res = call.execute();
            Assert.assertTrue(res.isSuccessful());

            DiscUsage result = res.body();

            Assert.assertTrue(result.getUsedSize() > 0);
            Assert.assertTrue(result.getTotalSize() > 0);

        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void getFileVersions(){

        try {
            Call<FileVersions> call = storageApi.getFileVersions("HtmlTestDoc/test.txt", null);
            Response<FileVersions> res = call.execute();
            Assert.assertTrue(res.isSuccessful());

            FileVersions result = res.body();

            Assert.assertTrue(TestHelper.saveToDisc(result.toString(),"FileVersions.json"));
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail();
        }
    }
}
