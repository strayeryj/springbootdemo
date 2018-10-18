package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.repository.IWaterMapper;
import com.example.demo.repository.dto.WaterCommon2Dto;
import com.example.demo.repository.dto.WaterCommonDto;
import com.example.demo.repository.dto.WaterDto;
import com.example.demo.service.IJsonParse;
import com.example.demo.utils.HttpKit;
import com.example.demo.utils.OkHttpClientKit;
import okhttp3.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 水情水调
 */
@Controller
@RequestMapping("/water")
public class WaterController {

    private static final String BASE_URL = "http://10.176.156.136:8081/interface/";
    private static final String WATER_URL_PRE = "api/water/";
    private static final String URL_SUF = "/1.0";
    private static final String reservoidCpcInHour = "reservoidCpcInHour";
    private static final String reservoidCpcInDay = "reservoidCpcInDay";
    private static final String reservoidCpcOutHour = "reservoidCpcOutHour";
    private static final String reservoidCpcOutDay = "reservoidCpcOutDay";
    private static final String reservoidCpcPowerGenHour = "reservoidCpcPowerGenHour";
    private static final String reservoidCpcPowerGenDay = "reservoidCpcPowerGenDay";

    private static final String reservoidCpcInMonth = "reservoidCpcInMonth";
    private static final String reservoidCpcInYear = "reservoidCpcInYear";
    private static final String reservoidCpcOutMonth = "reservoidCpcOutMonth";
    private static final String reservoidCpcOutYear = "reservoidCpcOutYear";
    private static final String reservoidCpcPowerGenMonth = "reservoidCpcPowerGenMonth";
    private static final String reservoidCpcPowerGenYear = "reservoidCpcPowerGenYear";


    private static final String START_TIME = "2016-09-01 00:00:00";
    private static final String END_TIME = "2018-09-01 00:00:00";

    @Autowired
    private IJsonParse iJsonParse;
    @Autowired
    private IWaterMapper iWaterMapper;

    /**
     * 数据结构：{
     "POINT_ID": "739",
     "POINT_NAME": "铜街子蓄能值",
     "DATA_TIME": 1483200000000,
     "DATA_VALUE": 91082.29
     }

     * @return
     * @throws IOException
     */
    @RequestMapping("/fetchCommon")
    @ResponseBody
    public String fetchCommon() throws IOException {
//        String result = reservoidCpcHourCommon(reservoidCpcInHour);
//        reservoidCpcDayCommon(reservoidCpcInDay);
//        reservoidCpcMonthCommon(reservoidCpcInMonth);
//        reservoidCpcYearCommon(reservoidCpcInYear);
//
//        reservoidCpcHourCommon(reservoidCpcOutHour);
//        reservoidCpcDayCommon(reservoidCpcOutDay);
//        reservoidCpcMonthCommon(reservoidCpcOutMonth);
//        reservoidCpcYearCommon(reservoidCpcOutYear);
//
//        reservoidCpcHourCommon(reservoidCpcPowerGenHour);
//        reservoidCpcDayCommon(reservoidCpcPowerGenDay);
//        reservoidCpcMonthCommon(reservoidCpcPowerGenMonth);
//        reservoidCpcYearCommon(reservoidCpcPowerGenYear);
//
//        reservoidCpcHourCommon("reservoidCpcOnLoadHour");
//        reservoidCpcDayCommon("reservoidCpcOnLoadDay");
//        reservoidCpcMonthCommon("reservoidCpcOnLoadMonth");
//        reservoidCpcYearCommon("reservoidCpcOnLoadYear");
//
//        reservoidCpcHourCommon("reservoidCpcOvpHour");
//        reservoidCpcDayCommon("reservoidCpcOvpDay");
//        reservoidCpcMonthCommon("reservoidCpcOvpMonth");
//        reservoidCpcYearCommon("reservoidCpcOvpYear");
//
//        reservoidCpcHourCommon("waterCpcAdjHour");
//        reservoidCpcDayCommon("waterCpcAdjDay");
//        reservoidCpcMonthCommon("waterCpcAdjMonth");
//        reservoidCpcYearCommon("waterCpcAdjYear");
//
//        reservoidCpcHourCommon("reservoidFlowIn5Min");
//        reservoidCpcHourCommon("reservoidFlowInHour");
//        reservoidCpcDayCommon("reservoidFlowInDay");
//        reservoidCpcMonthCommon("reservoidFlowInMonth");
//        reservoidCpcYearCommon("reservoidFlowInYear");
//-----------------------------------------------------------------------
        //8
//        reservoidCpcHourCommon("reservoidFlowOut5Min");
//        reservoidCpcHourCommon("reservoidFlowOutHour");
//        reservoidCpcDayCommon("reservoidFlowOutDay");
//        reservoidCpcMonthCommon("reservoidFlowOutMonth");
//        reservoidCpcYearCommon("reservoidFlowOutYear");

//        reservoidCpcHourCommon("powerGenFlow5Min");
//        reservoidCpcHourCommon("powerGenFlowHour");
//        reservoidCpcDayCommon("powerGenFlowDay");
//        reservoidCpcMonthCommon("powerGenFlowMonth");
//        reservoidCpcYearCommon("powerGenFlowYear");

//        reservoidCpcHourCommon("floodDchFlow5Min");//Java heap space没有导入
//        reservoidCpcHourCommon("floodDchFlowHour");
//        reservoidCpcDayCommon("floodDchFlowDay");
//        reservoidCpcMonthCommon("floodDchFlowMonth");
//        reservoidCpcYearCommon("floodDchFlowYear");

//        reservoidCpcHourCommon("waterConsRateHour");//无值
//        reservoidCpcDayCommon("waterConsRateDay");
//        reservoidCpcMonthCommon("waterConsRateMonth");//无值
//        reservoidCpcYearCommon("waterConsRateYear");//无值

//        reservoidCpcHourCommon("stageBehindDam5Min");
//        reservoidCpcHourCommon("stageBehindDamHour");
//        reservoidCpcDayCommon("stageBehindDamDay");
//        reservoidCpcMonthCommon("stageBehindDamMonth");
//        reservoidCpcYearCommon("stageBehindDamYear");

//        reservoidCpcHourCommon("stageBeforeDam5Min");
//        reservoidCpcHourCommon("stageBeforeDamHour");
//        reservoidCpcDayCommon("stageBeforeDamDay");
//        reservoidCpcMonthCommon("stageBeforeDamMonth");
//        reservoidCpcYearCommon("stageBeforeDamYear");

        //无值，不管
//        reservoidCpcHourCommon("gatageHour");
//        reservoidCpcDayCommon("gatageDay");
//        reservoidCpcMonthCommon("gatageMonth");
//        reservoidCpcYearCommon("gatageYear");

//        reservoidCpcHourCommon("doorFloodDchFlow5Min");
//        reservoidCpcHourCommon("doorFloodDchFlowHour");
//        reservoidCpcDayCommon("doorFloodDchFlowDay");
//        reservoidCpcMonthCommon("doorFloodDchFlowMonth");
//        reservoidCpcYearCommon("doorFloodDchFlowYear");

        // 16
//        reservoidCpcHourCommon("hydyCheckFloodLvl5Min");
//        reservoidCpcHourCommon("hydyCheckFloodLvlHour");
//        reservoidCpcDayCommon("hydyCheckFloodLvlDay");
//        reservoidCpcMonthCommon("hydyCheckFloodLvlMonth");
//        reservoidCpcYearCommon("hydyCheckFloodLvlYear");
//
//        reservoidCpcHourCommon("hydyFlowHour");
//        reservoidCpcDayCommon("hydyFlowDay");
//        reservoidCpcMonthCommon("hydyFlowMonth");
//        reservoidCpcYearCommon("hydyFlowYear");
//
////        reservoidCpcHourCommon("rainFall5Min");
//        reservoidCpcHourCommon("rainFallHour");
//        reservoidCpcDayCommon("rainFallDay");
//        reservoidCpcMonthCommon("rainFallMonth");
//        reservoidCpcYearCommon("rainFallYear");
//
//        reservoidCpcHourCommon("waterCpcAbdPlanMntHour");
//        reservoidCpcDayCommon("waterCpcAbdPlanMntDay");
//        reservoidCpcMonthCommon("waterCpcAbdPlanMntMonth");
////        reservoidCpcYearCommon("waterCpcAbdPlanMntYear");//无值
//
//        reservoidCpcHourCommon("waterCpcAbdEopMalfunHour");
//        reservoidCpcDayCommon("waterCpcAbdEopMalfunDay");
//        reservoidCpcMonthCommon("waterCpcAbdEopMalfunMonth");
//        reservoidCpcYearCommon("waterCpcAbdEopMalfunYear");//无值

        // 21
//        reservoidCpcHourCommon("waterCpcAbdGridEffHour");//无值
//        reservoidCpcDayCommon("waterCpcAbdGridEffDay");
//        reservoidCpcMonthCommon("waterCpcAbdGridEffDay");
//        reservoidCpcYearCommon("waterCpcAbdGridEffYear");

//        reservoidCpcHourCommon("waterCpcAbdFloodDchHour");//无值
//        reservoidCpcDayCommon("waterCpcAbdFloodDchDay");
//        reservoidCpcMonthCommon("waterCpcAbdFloodDchMonth");
//        reservoidCpcYearCommon("waterCpcAbdFloodDchYear");

//        reservoidCpcHourCommon("energyStorageValueHour");
//        reservoidCpcDayCommon("energyStorageValueDay");
//        reservoidCpcMonthCommon("energyStorageValueMonth");
//        reservoidCpcYearCommon("energyStorageValueYear");


        return "23";
    }

    /**
     *  数据结构 {
     "POINT_ID": "100026",
     "POINT_NAME": "龚嘴水位库容曲线",
     "X": 516.6,
     "Y1": 3.65,
     "Y2": -99
     }

     * @return
     * @throws IOException
     */
    @RequestMapping("/fetchCommon2")
    @ResponseBody
    public String fetchCommon2() throws IOException {
//        reservoidCpcCommon2("floodLvlFLECvs");
//        reservoidCpcCommon2("overFlowCvs");
//        reservoidCpcCommon2("floodLvlStoreCpcCvs");
//        reservoidCpcCommon2("macNhqCvs");

        return "30";
    }


    public String reservoidCpcHourCommon(String method) throws IOException {
        String result =getWaterData(method);
        List<WaterCommonDto> wdList =  parseDataOfWaterUseCom(result, method);
        int num = iWaterMapper.reservoidCpcHourCommon(wdList);
        System.out.println(method + "结果条数: " + num);
        return result;
    }
    public String reservoidCpcDayCommon(String method) throws IOException {
        String result =getWaterData(method);
        List<WaterCommonDto> wdList =  parseDataOfWaterUseCom(result, method);
        int num = iWaterMapper.reservoidCpcDayCommon(wdList);
        System.out.println(method + "结果条数: " + num);
        return result;
    }
    public String reservoidCpcMonthCommon(String method) throws IOException {
        String result =getWaterData(method);
        List<WaterCommonDto> wdList =  parseDataOfWaterUseCom(result, method);
        int num = iWaterMapper.reservoidCpcMonthCommon(wdList);
        System.out.println(method + "结果条数: " + num);
        return result;
    }
    public String reservoidCpcYearCommon(String method) throws IOException {
        String result =getWaterData(method);
        List<WaterCommonDto> wdList =  parseDataOfWaterUseCom(result, method);
        int num = iWaterMapper.reservoidCpcYearCommon(wdList);
        System.out.println(method + "结果条数: " + num);
        return result;
    }

    public String reservoidCpcCommon2(String method) throws IOException {
        String result =getWaterData(method);
        List<WaterCommon2Dto> wdList =  parseDataOfWaterUseCom2(result, method);
        int num = iWaterMapper.reservoidCpcCommon2(wdList);
        System.out.println(method + " 结果2条数:  " + num);
        return result;
    }









    // -------------------------------------------
    // 数据获取，解析方法
    /**
     *  根据接口获取水情水调数据
     * @param method
     * @return
     * @throws IOException
     */
    private static String getWaterData(String method )throws IOException{
        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL)
                .append(WATER_URL_PRE)
                .append(method)
                .append(URL_SUF);
        String url = sb.toString();

        JSONObject jsonObjectRequest = new JSONObject();
        jsonObjectRequest.put("startTime", START_TIME);
        jsonObjectRequest.put("endTime", END_TIME);

        String result = OkHttpClientKit.postJSON(url, jsonObjectRequest.toString());
        return  result;
    }

    /**
     *  解析数据
     * @param result
     * @return
     */
    List<WaterDto> parseDataOfWater(String result){
        List<WaterDto> wdList = iJsonParse.parseJson(result);
        return wdList;
    }
    List<WaterCommonDto> parseDataOfWaterUseCom(String result, String method){
        List<WaterCommonDto> wdList = iJsonParse.parseComJson(result, method);
        return wdList;
    }
    List<WaterCommon2Dto> parseDataOfWaterUseCom2(String result, String method){
        List<WaterCommon2Dto> wdList = iJsonParse.parseCom2Json(result, method);
        return wdList;
    }
}
