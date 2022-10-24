/*
* --------------------------------------------------------------------------------------------------------------------
* <copyright company="Aspose" file="ApiClient.java">
*   Copyright (c) 2022 Aspose.HTML for Cloud
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

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import org.threeten.bp.format.DateTimeFormatter;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.security.cert.CertificateException;
import java.text.DateFormat;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class ApiClient {

    private OkHttpClient.Builder okBuilder;
    private Retrofit.Builder adapterBuilder;
    private static final JSON json = new JSON();

    private static String accessToken;
    private static String userAgent;
    private static final String clientHeaderName = "x-aspose-client";
    private static final String clientVersionHeaderName = "x-aspose-client-version";

    public ApiClient()
    {
        userAgent = Configuration.getUserAgent();
        accessToken = ApiClient.getAccessToken();
        createDefaultAdapter();
    }

    private void createDefaultAdapter() {

        String baseUrl = Configuration.getBasePath();

        if (!baseUrl.endsWith("/"))
            baseUrl = baseUrl + "/";

        okBuilder = getUnsafeOkHttpClientBuilder()
            .readTimeout(60*1000*10, TimeUnit.MILLISECONDS)
            .connectTimeout(60*1000*10, TimeUnit.MILLISECONDS)
            .addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = null;
                if (accessToken != null) {

                    Request original = chain.request();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .addHeader("Authorization", accessToken)
							.addHeader("User-Agent", userAgent)
							.addHeader(clientHeaderName, "aspose.html-cloud android sdk")
							.addHeader(clientVersionHeaderName, "22.10.1");

                    //ToDo: Kestrel decode %2F('/') and %5C ('\') to '/' bug
                    String orignUrl = original.url().toString();
                    String changeUrl = orignUrl
                            .replace("%2F", "/")
                            .replace("%5C", "/");

                    Request newRequest = requestBuilder
                            .url(changeUrl)
                            .build();
                    return chain.proceed(newRequest);
                }
                return chain.proceed(request);
            }
        });

        //Debug
        if (Configuration.getDebug()){
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);
            okBuilder.addInterceptor(logging);
        }

        adapterBuilder = new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .client(getUnsafeOkHttpClientBuilder().build())
                .addConverterFactory(new EnumConverterFactory())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonCustomConverterFactory.create(json.getGson()));
    }

    private static OkHttpClient.Builder getUnsafeOkHttpClientBuilder() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[] {
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager)trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            return builder;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static String getAccessToken(){

        OkHttpClient client = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .add("client_id", Configuration.getAPP_SID())
                .add("client_secret", Configuration.getAPI_KEY())
                .build();

        Request request = new Request.Builder()
                .url(Configuration.getAuthPath())
                .post(formBody)
                .build();

        try {
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            String out = response.body().string();
            AuthAnswer answer = json.deserialize(out, AuthAnswer.class);
            return  "Bearer " + answer.access_token;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public <S> S createService(Class<S> serviceClass) {
        return adapterBuilder
                .client(okBuilder.build())
                .build()
                .create(serviceClass);
    }

    public ApiClient setDateFormat(DateFormat dateFormat) {
        json.setDateFormat(dateFormat);
        return this;
    }

    public ApiClient setSqlDateFormat(DateFormat dateFormat) {
        json.setSqlDateFormat(dateFormat);
        return this;
    }

    public ApiClient setOffsetDateTimeFormat(DateTimeFormatter dateFormat) {
        json.setOffsetDateTimeFormat(dateFormat);
        return this;
    }

    public ApiClient setLocalDateFormat(DateTimeFormatter dateFormat) {
        json.setLocalDateFormat(dateFormat);
        return this;
    }


    public Retrofit.Builder getAdapterBuilder() {
        return adapterBuilder;
    }

    public ApiClient setAdapterBuilder(Retrofit.Builder adapterBuilder) {
        this.adapterBuilder = adapterBuilder;
        return this;
    }

    public OkHttpClient.Builder getOkBuilder() {
        return okBuilder;
    }

}

/**
 * This wrapper is to take care of this case:
 * when the deserialization fails due to JsonParseException and the
 * expected type is String, then just return the body string.
 */
class GsonResponseBodyConverterToString<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final Type type;

    GsonResponseBodyConverterToString(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String returned = value.string();
        try {
            return gson.fromJson(returned, type);
        } catch (JsonParseException e) {
            return (T) returned;
        }
    }
}

class GsonCustomConverterFactory extends Converter.Factory {
    private final Gson gson;
    private final GsonConverterFactory gsonConverterFactory;

    public static GsonCustomConverterFactory create(Gson gson) {
        return new GsonCustomConverterFactory(gson);
    }

    private GsonCustomConverterFactory(Gson gson) {
        if (gson == null)
            throw new NullPointerException("gson == null");
        this.gson = gson;
        this.gsonConverterFactory = GsonConverterFactory.create(gson);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        if (type.equals(String.class))
            return new GsonResponseBodyConverterToString<Object>(gson, type);
        else
            return gsonConverterFactory.responseBodyConverter(type, annotations, retrofit);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return gsonConverterFactory.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit);
    }
}
