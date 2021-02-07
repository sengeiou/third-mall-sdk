package com.sdk.test.duomai;

import com.sdk.duomai.api.CpsOpenApi;
import com.sdk.duomai.factory.DuoMaiClientFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MediaTests {
    @Test
    public void goodsList() throws IOException {
        String serviceName = "cps-mesh.cpslink.media.products.get";
        Map<String, Object> param = new HashMap<>();
        //param.put("query", "");
        param.put("order_field", "100");
        param.put("order_type", "asc" /*"desc"*/);
        param.put("page", 1);
        param.put("page_size", 50);
        CpsOpenApi cpsOpenApi = DuoMaiClientFactory.duoMaiClient();
        String res = cpsOpenApi.doReq(serviceName, param);
        System.out.println("响应结果：" + res);
    }

    @Test
    public void goodsListByKeyword() throws IOException {
        String serviceName = "cps-mesh.cpslink.media.products.get";
        Map<String, Object> param = new HashMap<>();
        param.put("query", "手机");
        param.put("order_field", "100");
        param.put("order_type", "asc" /*"desc"*/);
        param.put("page", 1);
        param.put("page_size", 50);
        CpsOpenApi cpsOpenApi = DuoMaiClientFactory.duoMaiClient();
        String res = cpsOpenApi.doReq(serviceName, param);
        System.out.println("响应结果：" + res);
    }

    @Test
    public void goodsById() throws IOException {
        String serviceName = "cps-mesh.cpslink.media.products.get";
        Map<String, Object> param = new HashMap<>();
        param.put("id", "1000000000100511267046");
        CpsOpenApi cpsOpenApi = DuoMaiClientFactory.duoMaiClient();
        String res = cpsOpenApi.doReq(serviceName, param);
        System.out.println("响应结果：" + res);
    }
}