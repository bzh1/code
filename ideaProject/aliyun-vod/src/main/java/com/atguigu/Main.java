package com.atguigu;

import com.atguigu.util.AliyunVodAPIUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import sun.misc.BASE64Encoder;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Logger;
/**
 * 视频点播OpenAPI调用示例
 * 以GetVideoPlayAuth接口为例，其他接口请替换相应接口名称及私有参数
 */
public class Main {



    public static void main(String[] args) throws Exception {
        //生成私有参数，不同API需要修改
        Map<String, String> privateParams =generatePrivateParamters();
        //生成公共参数，不需要修改
        Map<String, String> publicParams =AliyunVodAPIUtils.generatePublicParamters();
        //生成OpenAPI地址，不需要修改
        String URL = AliyunVodAPIUtils.generateOpenAPIURL(publicParams, privateParams);
        //发送HTTP GET 请求
        AliyunVodAPIUtils.httpGet(URL);
    }

    /**
     * 生成视频点播OpenAPI私有参数
     * 不同API需要修改此方法中的参数
     * @return
     */
    public static Map<String, String> generatePrivateParamters() {
        // 接口私有参数列表, 不同API请替换相应参数
        Map<String, String> privateParams = new HashMap<>();
        // 视频ID
        privateParams.put("VideoId","5a917a366588480b89a89c3b3774077d");
        // API名称
        privateParams.put("Action", "GetVideoPlayAuth");
        return privateParams;
    }

}
