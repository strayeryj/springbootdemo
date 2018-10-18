package com.example.demo.utils;

import okhttp3.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Http客户端工具箱
 *
 * @author Albert
 */
public class HttpKit {

    private OkHttpClient client;

    /**
     * 无参构造，初始化client
     */
    public HttpKit() {
        super();
        this.client = new OkHttpClient().newBuilder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .writeTimeout(100, TimeUnit.SECONDS)
                .readTimeout(200, TimeUnit.SECONDS).build();
    }

    /**
     * 有参构造
     *
     * @param client client
     */
    public HttpKit(OkHttpClient client) {
        this.client = client;
    }

    /**
     * 重载同步GET
     *
     * @param url 请求路径
     * @return String 字符串
     * @throws IOException 异常
     */
    public String httpGet(String url) throws IOException {
        return this.httpGet(url, new Headers.Builder().build());
    }

    /**
     * 重载同步GET
     *
     * @param url     请求路径
     * @param headers 请求头
     * @return String 字符串
     * @throws IOException 异常
     */
    public String httpGet(String url, Headers headers) throws IOException {
        return this.httpGet(url, null, headers);
    }

    /**
     * 重载同步GET
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return String 字符串
     * @throws IOException 异常
     */
    public String httpGet(String url, Map<String, String> params) throws IOException {
        return this.httpGet(url, params, new Headers.Builder().build());
    }

    /**
     * 同步GET
     *
     * @param url     请求路径
     * @param params  请求参数
     * @param headers 请求头
     * @return String 字符串
     * @throws IOException 异常
     */
    public String httpGet(String url, Map<String, String> params, Headers headers) throws IOException {
        return this.httpGetBody(url, params, headers).string();
    }

    /**
     * 重载同步GET 返回ResponseBody
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return ResponseBody 可获取byte[]、Stream、Reader等
     * @throws IOException 异常
     */
    public ResponseBody httpGetBody(String url, Map<String, String> params) throws IOException {
        return this.httpGetBody(url, params, new Headers.Builder().build());
    }

    /**
     * 同步GET 返回ResponseBody
     *
     * @param url     请求路径
     * @param params  请求参数
     * @param headers 请求头
     * @return ResponseBody 可获取byte[]、Stream、Reader等
     * @throws IOException 异常
     */
    public ResponseBody httpGetBody(String url, Map<String, String> params, Headers headers) throws IOException {
        System.out.println("发起GET请求，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("请求地址: " + url);
        System.out.println("请求参数: " + params);
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        if (params != null) {
            for (String key : params.keySet()) {
                urlBuilder.addQueryParameter(key, params.get(key));
            }
        }
        Request request = new Request.Builder().headers(headers).url(urlBuilder.build()).get().build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 重载异步GET
     *
     * @param url      请求路径
     * @param callback 回调函数
     */
    public void httpGetAsync(String url, Callback callback) {
        this.httpGetAsync(url, null, callback);
    }

    /**
     * 重载异步GET
     *
     * @param url      请求路径
     * @param params   请求参数
     * @param callback 回调函数
     */
    public void httpGetAsync(String url, Map<String, String> params, Callback callback) {
        this.httpGetAsync(url, params, new Headers.Builder().build(), callback);
    }

    /**
     * 异步GET
     *
     * @param url      请求路径
     * @param params   请求参数
     * @param headers  请求头
     * @param callback 回调函数
     */
    public void httpGetAsync(String url, Map<String, String> params, Headers headers, Callback callback) {
        System.out.println("发起异步GET请求，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("请求地址: " + url);
        System.out.println("请求参数: " + params);
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        if (params != null) {
            for (String key : params.keySet()) {
                urlBuilder.addQueryParameter(key, params.get(key));
            }
        }
        Request request = new Request.Builder().headers(headers).url(urlBuilder.build()).get().build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    /**
     * 重载同步POST
     *
     * @param url 请求路径
     * @return String 字符串
     * @throws IOException 异常
     */
    public String httpPost(String url) throws IOException {
        return this.httpPost(url, new HashMap<String, String>());
    }

    /**
     * 重载同步POST
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return String 字符串
     * @throws IOException 异常
     */
    public String httpPost(String url, Map<String, String> params) throws IOException {
        return this.httpPost(url, params, new Headers.Builder().build());
    }

    /**
     * 重载同步POST
     *
     * @param url     请求路径
     * @param params  请求参数
     * @param headers 请求头
     * @return String 字符串
     * @throws IOException 异常
     */
    public String httpPost(String url, Map<String, String> params, Headers headers) throws IOException {
        ResponseBody body = this.httpPostBody(url, params, headers);
        return body.string();
    }

    /**
     * 重载同步POST 返回ResponseBody
     *
     * @param url     请求路径
     * @param params  请求参数
     * @param headers 请求头
     * @return ResponseBody 可获取byte[]、Stream、Reader等
     * @throws IOException 异常
     */
    public ResponseBody httpPostBody(String url, Map<String, String> params, Headers headers) throws IOException {
        System.out.println("发起POST请求，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("请求地址: " + url);
        System.out.println("请求参数: " + params);
        FormBody.Builder formBuilder = new FormBody.Builder();
        if (params != null) {
            for (String key : params.keySet()) {
                formBuilder.add(key, params.get(key));
            }
        }
        return this.httpPostBody(url, formBuilder.build(), headers);
    }

    /**
     * 同步POST 返回ResponseBody
     *
     * @param url         请求路径
     * @param requestBody 请求体
     * @param headers     请求头
     * @return ResponseBody 可获取byte[]、Stream、Reader等
     * @throws IOException 异常
     */
    public ResponseBody httpPostBody(String url, RequestBody requestBody, Headers headers) throws IOException {
        Request request = new Request.Builder().headers(headers).url(url).post(requestBody).build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 重载异步POST
     *
     * @param url      请求路径
     * @param callback 回调函数
     */
    public void httpPostAsync(String url, Callback callback) {
        this.httpPostAsync(url, null, callback);
    }

    /**
     * 重载异步POST
     *
     * @param url      请求路径
     * @param params   请求参数
     * @param callback 回调函数
     */
    public void httpPostAsync(String url, Map<String, String> params, Callback callback) {
        this.httpPostAsync(url, params, new Headers.Builder().build(), callback);
    }

    /**
     * 异步POST
     *
     * @param url      请求路径
     * @param params   请求参数
     * @param headers  请求头
     * @param callback 回调函数
     */
    public void httpPostAsync(String url, Map<String, String> params, Headers headers, Callback callback) {
        System.out.println("发起异步POST请求，时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        System.out.println("请求地址: " + url);
        System.out.println("请求参数: " + params);
        FormBody.Builder formBuilder = new FormBody.Builder();
        if (params != null) {
            for (String key : params.keySet()) {
                formBuilder.add(key, params.get(key));
            }
        }
        Request request = new Request.Builder().headers(headers).url(url).post(formBuilder.build()).build();
        client.newCall(request).enqueue(callback);
    }

// ----------------------------------------------



}
