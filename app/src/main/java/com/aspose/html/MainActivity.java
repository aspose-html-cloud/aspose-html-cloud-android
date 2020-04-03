/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="MainActivity.java">
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

package com.aspose.html;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;
import com.aspose.html.android.ApiClient;
import com.aspose.html.android.Configuration;
import com.aspose.html.android.api.DocumentApi;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;


public class MainActivity extends AppCompatActivity {

    EditText mUrl;
    EditText mResult;
    DocumentApi docApi;

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mUrl = findViewById(R.id.address);
        mResult = findViewById(R.id.result);
        Configuration.setAPI_KEY("60487a72d6325241191177e37ae52146");
        Configuration.setAPP_SID("80e32ca5-a828-46a4-9d54-7199dfd3764a");
        Configuration.setBasePath("https://api-qa.aspose.cloud/v3.0");
        Configuration.setAuthPath("https://api-qa.aspose.cloud/connect/token");
        Configuration.setUserAgent("WebKit");
        Configuration.setDebug(true);
    }

    public void clickLinks(View view) {

        String textUrl = mUrl.getText().toString().trim();

        @SuppressLint("StaticFieldLeak") AsyncTask<String, Void, String> task = new AsyncTask<String, Void, String>() {

            @Override
            protected String doInBackground(String... urls) {
                docApi = new ApiClient().createService(DocumentApi.class);
                String xPath = "//a/@href";
                String outFormat = "json";
                Call<ResponseBody> call = docApi.GetDocumentFragmentByXPathByUrl(outFormat, urls[0], xPath);
                String result = null;
                try {
                    result = call.execute().body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                mResult.setText(result);
            }
        };
        task.execute(textUrl);
        Toast.makeText(this, "Get all links from url " + textUrl, Toast.LENGTH_LONG).show();
    }
}
