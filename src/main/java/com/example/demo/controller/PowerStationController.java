package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.repository.IPSMapper;
import com.example.demo.service.IPSParse;
import com.example.demo.utils.OkHttpClientKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * 对应文档的 3.2.1 - 3.2.12 参数没有stationCode的接口
 */
@Controller
@RequestMapping("/powerStation")
public class PowerStationController {

    private static final String BASE_URL = "http://10.176.156.136:8081/interface/";
    private static final String WATER_URL_PRE = "api/power/";
    private static final String URL_SUF = "/1.0";

    private static final String START_TIME_HOUR = "2018-09-01 00:00:00";
    private static final String END_TIME_HOUR = "2018-09-02 00:00:00";
    private static final String START_TIME_DAY = "2018-08-01 00:00:00";
    private static final String END_TIME_DAY = "2018-09-01 00:00:00";


    @Autowired
    private IPSParse ipsParse;
    @Autowired
    private IPSMapper ipsMapper;

    @RequestMapping("/fetchData")
    @ResponseBody
    public String fetchData() throws IOException {

//        hourCommon("companyGenPowerHour");
//        dayCommon("companyGenPowerDay");

//        hourCommon("companyLinePowerHour");
//        dayCommon("companyLinePowerDay");

//        hourCommon("companyPUPowerHour");
//        dayCommon("companyPUPowerDay");

//        hourCommon("plantGenPowerHour");
//        dayCommon("plantGenPowerDay");

//        hourCommon("plantLinePowerHour");
//        dayCommon("plantLinePowerDay");

        //6
//        hourCommon("plantPUPowerHour");
//        dayCommon("plantPUPowerDay");

//        hourCommon("stationGenPowerHour");
//        dayCommon("stationGenPowerDay");

//        hourCommon("");//没有接口
//        dayCommon("stationLinePowerDay");

//        hourCommon("stationPUPowerHour");
//        dayCommon("stationPUPowerDay");

        return "success";
    }

    public void hourCommon(String method) throws IOException {
        String result = fetchHour(method);
        List list = ipsParse.parseHourCommon(result, method);
        int num = ipsMapper.hourCommon(list);
        System.out.println(method + " 结果条数: " + num);
    }

    public void dayCommon(String method) throws IOException {
        String result = fetchDay(method);
        List list = ipsParse.parseDayCommon(result, method);
        int num = ipsMapper.dayCommon(list);
        System.out.println(method + " 结果条数: " + num);
    }


    public String fetchHour(String method) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL)
                .append(WATER_URL_PRE)
                .append(method)
                .append(URL_SUF);
        String url = sb.toString();
//        JSONObject jsonObjectRequest = new JSONObject();
//        jsonObjectRequest.put("startTime", START_TIME_HOUR);
//        jsonObjectRequest.put("endTime", END_TIME_HOUR);
//        String result = OkHttpClientKit.postJSON(url, jsonObjectRequest.toString());
        String result = OkHttpClientKit.postJSON(url, paramsOfHour());

        return  result;
    }
    public String fetchDay(String method) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL)
                .append(WATER_URL_PRE)
                .append(method)
                .append(URL_SUF);
        String url = sb.toString();

//        JSONObject jsonObjectRequest = new JSONObject();
//        jsonObjectRequest.put("startTime", START_TIME_DAY);
//        jsonObjectRequest.put("endTime", END_TIME_DAY);
//        String result = OkHttpClientKit.postJSON(url, jsonObjectRequest.toString());

        String result = OkHttpClientKit.postJSON(url, paramsOfDay());
        return  result;
    }
    public String  paramsOfHour(){
        JSONObject jsonObjectRequest = new JSONObject();
        jsonObjectRequest.put("startTime", START_TIME_HOUR);
        jsonObjectRequest.put("endTime", END_TIME_HOUR);
        return jsonObjectRequest.toString();
    }
    public String  paramsOfDay(){
        JSONObject jsonObjectRequest = new JSONObject();
        jsonObjectRequest.put("startTime", START_TIME_DAY);
        jsonObjectRequest.put("endTime", END_TIME_DAY);
        return jsonObjectRequest.toString();
    }

}
