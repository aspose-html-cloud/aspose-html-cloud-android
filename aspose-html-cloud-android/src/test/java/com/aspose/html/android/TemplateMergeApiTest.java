

package com.aspose.html.android;

import com.aspose.html.android.api.TemplateMergeApi;
import com.aspose.html.android.api.StorageApi;

import org.junit.Before;
import org.junit.Test;
import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

import static java.lang.System.out;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TemplateMergeApiTest extends BaseTest {

    private TemplateMergeApi api;
    private StorageApi storageApi;
    private String templateName;
    private String templateData;
    private String options;
    private String versionId;
    private String folder;
    private String storage;

    @Before
    public void setup() {
        api = new ApiClient().createService(TemplateMergeApi.class);
        storageApi = new ApiClient().createService(StorageApi.class);
        folder = "HtmlTestDoc";
        storage = null;
        templateName = "HtmlTemplate.html";
        templateData = "XmlSourceData.xml";
        options = "";
        versionId = null;

        try {
            //Upload data to storage
            TestHelper.uploadFile(templateData, folder);
            // Upload template to storage
            TestHelper.uploadFile(templateName, folder);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }
    /**
     * Populate HTML document template with data located as a file in the storage.
     *
     */
    @Test
    public void GetMergeHtmlTemplateTest() {

        try {
            Call<ResponseBody> call = api.GetMergeHtmlTemplate(templateName, folder + "/" + templateData,options,folder,storage);
            TestHelper.checkAndSave(call, "GetMergeHtmlTemplate.html");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    /**
     * Populate HTML document template with data from the request body. Result document will be saved to storage.
     *
     */
    @Test
    public void PostMergeHtmlTemplateTest() {

        String result = "PostMergeHtmlTemplate.html";

        // Open xml file with data for template
        File f = new File(Configuration.getTestSrcDir(), templateData);
        if(!f.exists()){
            out.println("file not found");
            fail();
        }
        RequestBody requestBody = RequestBody.create( MediaType.parse("multipart/form-data"), f);
        MultipartBody.Part file = MultipartBody.Part.createFormData("file", f.getName(), requestBody);

        // Path to save result in the storage
        String outPath = folder +  "/" + result;

        try {

            Call<ResponseBody> call = api.PostMergeHtmlTemplate(templateName, outPath, file, options, folder, storage);
            Response<ResponseBody> res = call.execute();
            assertTrue(res.isSuccessful());

            //Download result from storage
            call = storageApi.downloadFile(outPath, versionId, storage);

            //Save result to test directory
            TestHelper.checkAndSave(call, result);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
