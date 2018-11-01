

package com.aspose.html.android;

import com.aspose.html.android.api.TemplateMergeApi;
import com.aspose.storage.android.api.StorageApi;

import org.junit.Before;
import org.junit.Test;
import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;

import static java.lang.System.out;
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
            // Upload template to storage
            TestHelper.uploadFile(templateData, folder);
            //Upload data to storage
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
    public void PutMergeHtmlTemplateTest() {

        String result = "PutMergeHtmlTemplate.html";
        // Open xml file with data for template
        File f = new File(Configuration.getTestSrcDir(), templateData);

        if(!f.exists())
            out.println("file not found");

        // Prepare parameter to send.
        RequestBody file = RequestBody.create( MediaType.parse("application/octet-stream"), f);

        // Path to save result in the storage
        String outPath = folder +  "/" + result;

        try {
            api.PutMergeHtmlTemplate(templateName, outPath, file, options, folder, storage);

            //Download result from storage
            Call<ResponseBody> call = storageApi.GetDownload(outPath, versionId, storage);

            //Save result to test directory
            TestHelper.checkAndSave(call, result);

        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
