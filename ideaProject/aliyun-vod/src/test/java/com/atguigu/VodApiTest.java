package com.atguigu;

import com.atguigu.util.AliyunVodAPIUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class VodApiTest {

    @Test
    public void testGetVideoPlayAuth() throws Exception {

        // 接口私有参数列表, 不同API请替换相应参数
        Map<String, String> privateParams = new HashMap<>();
        // 视频ID
        privateParams.put("VideoId","5a917a366588480b89a89c3b3774077d");
        // API名称
        privateParams.put("Action", "GetVideoPlayAuth");

        Map<String, String> publicParams = AliyunVodAPIUtils.generatePublicParamters();
        //生成OpenAPI地址，不需要修改
        String URL = AliyunVodAPIUtils.generateOpenAPIURL(publicParams, privateParams);
        //发送HTTP GET 请求
        AliyunVodAPIUtils.httpGet(URL);
    }

    @Test
    public void testGetPlayInfo() throws Exception {

        // 接口私有参数列表, 不同API请替换相应参数
        Map<String, String> privateParams = new HashMap<>();
        // 视频ID
        privateParams.put("VideoId", "f467e0b386394b2a93c68af551103383");
        // API名称
        //privateParams.put("Action", "GetPlayInfo");
        privateParams.put("Action", "GetVideoPlayAuth");
        //如果是加密视频，并且需要获取视频基本信息，那么需要设置这个参数
        privateParams.put("ResultType", "Multiple");
        //生成视频点播公共参数
        Map<String, String> publicParams = AliyunVodAPIUtils.generatePublicParamters();
        //生成OpenAPI地址，不需要修改
        String URL = AliyunVodAPIUtils.generateOpenAPIURL(publicParams, privateParams);
        //发送HTTP GET 请求
        AliyunVodAPIUtils.httpGet(URL);
    }
}
