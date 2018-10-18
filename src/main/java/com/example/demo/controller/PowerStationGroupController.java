package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.repository.IPSMapper;
import com.example.demo.repository.dto.powerStation.StationInfoDto;
import com.example.demo.service.IPSParse;
import com.example.demo.utils.OkHttpClientKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * 对应文档的 3.2.1 - 3.2.12 参数包含： stationCode 的接口
 */

@Controller
@RequestMapping("/powerStationGroup")
public class PowerStationGroupController {
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
        List<StationInfoDto> siList = getStationInfo();
        for(StationInfoDto sid: siList){
            String code = sid.getStationCode();
//            hourCommon("lineGenPowerHour", code);
//            dayCommon("lineGenPowerDay", code);

//            hourCommon("lineLinePowerHour", code);
//            dayCommon("lineLinePowerDay", code);

//            hourCommon("linePUPowerHour", code);
//            dayCommon("linePUPowerDay", code);

        }
        return "fetchData1";
    }

    @RequestMapping("/fetchStationInfo")
    @ResponseBody
    public String fetchStationInfo() throws IOException {
        StringBuilder sb = new StringBuilder();
        String method = "stationDim";
        sb.append(BASE_URL)
                .append(WATER_URL_PRE)
                .append(method)
                .append(URL_SUF);
        String url = sb.toString();
        JSONObject jsonObjectRequest = new JSONObject();
//        jsonObjectRequest.put("startTime", START_TIME_HOUR);
//        jsonObjectRequest.put("endTime", END_TIME_HOUR);
        String result = OkHttpClientKit.postJSON(url, jsonObjectRequest.toString());
        List list = ipsParse.parseStationInfo(result, method);
        //数据导入，只执行一次
//        int num = ipsMapper.stationInfo(list);
        return "fetchStationInfo: ";
    }

    public List getStationInfo(){
        List list = ipsMapper.selectStationInfo();
//        for(Object obj: list){
//            System.out.println(obj.toString());
//        }
        return list;

    }

    public void hourCommon(String method, String code) throws IOException {
        String result = fetchHour(method, code);
        List list = ipsParse.parseHourCommon(result, method);
        if(list.size() == 0){
            System.out.println(method + " 电站: " + code + "没有值");
            return;
        }
        int num = ipsMapper.hourCommon(list);
        System.out.println(method + " 结果条数: " + num);
    }

    public void dayCommon(String method, String code) throws IOException {
        String result = fetchDay(method, code);
        List list = ipsParse.parseDayCommon(result, method);
        if(list.size() == 0){
            System.out.println(method + " 电站: " + code + "没有值");
            return;
        }
        int num = ipsMapper.dayCommon(list);
        System.out.println(method + " 结果条数: " + num);
    }


    public String fetchHour(String method, String code) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL)
                .append(WATER_URL_PRE)
                .append(method)
                .append(URL_SUF);
        String url = sb.toString();
        String result = OkHttpClientKit.postJSON(url, paramsOfHour(code));

        return  result;
    }
    public String fetchDay(String method, String code) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL)
                .append(WATER_URL_PRE)
                .append(method)
                .append(URL_SUF);
        String url = sb.toString();
        String result = OkHttpClientKit.postJSON(url, paramsOfDay(code));
        return  result;
    }
    public String  paramsOfHour(String code){
        JSONObject jsonObjectRequest = new JSONObject();
        jsonObjectRequest.put("stationCode", code);
        jsonObjectRequest.put("startTime", START_TIME_HOUR);
        jsonObjectRequest.put("endTime", END_TIME_HOUR);
        return jsonObjectRequest.toString();
    }
    public String  paramsOfDay(String code){
        JSONObject jsonObjectRequest = new JSONObject();
        jsonObjectRequest.put("stationCode", code);
        jsonObjectRequest.put("startTime", START_TIME_DAY);
        jsonObjectRequest.put("endTime", END_TIME_DAY);
        return jsonObjectRequest.toString();
    }






}
