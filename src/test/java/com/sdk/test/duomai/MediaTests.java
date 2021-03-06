package com.sdk.test.duomai;

import com.alibaba.fastjson.JSONObject;
import com.sdk.common.util.AESUtil;
import com.sdk.common.util.DatetimeUtils;
import com.sdk.duomai.api.CpsOpenApi;
import com.sdk.duomai.factory.DuoMaiClientFactory;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
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

    @Test
    public void shareLink() throws Exception {
        String serviceName = "cps-mesh.cpslink.links.post";
        String goodsDetailServiceName = "cps-mesh.cpslink.media.products.detail";
        Map<String, Object> param = new HashMap<>();
        param.put("id", "1000000000100511267046");
        CpsOpenApi cpsOpenApi = DuoMaiClientFactory.duoMaiClient();
        String res = cpsOpenApi.doReq(goodsDetailServiceName, param);
        System.out.println("响应结果1：" + res);
        param.clear();

        // 取出上一步中的 item_url 传入
        String item_url = "";
        param.put("ads_id", "2214");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("euid", AESUtil.encryptData("用户标识", AESUtil.IV) + "M");
        param.put("ext", jsonObject);
        param.put("url", item_url);
        param.put("site_id", 423944);
        res = cpsOpenApi.doReq(serviceName, param);
        System.out.println("响应结果2：" + res);
    }

    @Test
    public void orderList() throws Exception {
        String serviceName = "cps-mesh.open.orders.query.get";
        Map<String, Object> param = new HashMap<>();
        param.put("page", 1);
        param.put("page_size", 50);
        param.put("stime", DatetimeUtils.getSeconds(LocalDateTime.now().minusMinutes(30)));
        param.put("etime", DatetimeUtils.getSeconds(LocalDateTime.now()));
        CpsOpenApi cpsOpenApi = DuoMaiClientFactory.duoMaiClient();
        String res = cpsOpenApi.doReq(serviceName, param);
        System.out.println("响应结果：" + res);
    }
}
