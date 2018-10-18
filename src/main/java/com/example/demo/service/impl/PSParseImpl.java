package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.repository.dto.generator.powerStation.*;
import com.example.demo.repository.dto.powerStation.DayCommonDto;
import com.example.demo.repository.dto.powerStation.HourCommonDto;
import com.example.demo.repository.dto.powerStation.StationInfoDto;
import com.example.demo.service.IPSParse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PSParseImpl implements IPSParse {
    @Override
    public List parseHourCommon(String result, String method) {
        JSONObject jsonObjectTemp;
        JSONArray jsonResultArrayTemp;
        jsonObjectTemp = (JSONObject) JSONObject.parse(result);
        jsonResultArrayTemp = (JSONArray) jsonObjectTemp.get("data");
        if(jsonResultArrayTemp == null){
            return new ArrayList();
        }

        List<HourCommonDto> hcdList = new ArrayList<>() ;
        for(int i = 0; i < jsonResultArrayTemp.size(); i++){
            String code = jsonResultArrayTemp.getJSONObject(i).getString("point_code");
            String name = jsonResultArrayTemp.getJSONObject(i).getString("data_name");
            String time = jsonResultArrayTemp.getJSONObject(i).getString("data_time");
            String type = jsonResultArrayTemp.getJSONObject(i).getString("power_type");
            String value = jsonResultArrayTemp.getJSONObject(i).getString("value");
            HourCommonDto wcd = new HourCommonDto(method,code, name, time, type, value);
            hcdList.add(wcd);
        }
        return hcdList;
    }
    @Override
    public List parseDayCommon(String result, String method) {
        JSONObject jsonObjectTemp;
        JSONArray jsonResultArrayTemp;
        jsonObjectTemp = (JSONObject) JSONObject.parse(result);
        jsonResultArrayTemp = (JSONArray) jsonObjectTemp.get("data");
        if(jsonResultArrayTemp == null){
            return new ArrayList();
        }

        List<DayCommonDto> hcdList = new ArrayList<>() ;
        for(int i = 0; i < jsonResultArrayTemp.size(); i++){
            String code = jsonResultArrayTemp.getJSONObject(i).getString("point_code");
            String name = jsonResultArrayTemp.getJSONObject(i).getString("data_name");
            String time = jsonResultArrayTemp.getJSONObject(i).getString("data_time");
            String type = jsonResultArrayTemp.getJSONObject(i).getString("power_type");
            String vj = jsonResultArrayTemp.getJSONObject(i).getString("value_j");
            String vf = jsonResultArrayTemp.getJSONObject(i).getString("value_f");
            String vp = jsonResultArrayTemp.getJSONObject(i).getString("value_p");
            String vg = jsonResultArrayTemp.getJSONObject(i).getString("value_g");
            String value = jsonResultArrayTemp.getJSONObject(i).getString("value");
            String mValue = jsonResultArrayTemp.getJSONObject(i).getString("month_value");
            String yValue = jsonResultArrayTemp.getJSONObject(i).getString("year_value");
            DayCommonDto wcd = new DayCommonDto(method, code, name, time, type, vj, vf, vp, vg, value, mValue, yValue);
            hcdList.add(wcd);
        }
        return hcdList;
    }
    @Override
    public List parseStationInfo(String result, String method) {
        JSONObject jsonObjectTemp;
        JSONArray jsonResultArrayTemp;
        jsonObjectTemp = (JSONObject) JSONObject.parse(result);
        jsonResultArrayTemp = (JSONArray) jsonObjectTemp.get("data");

        List<StationInfoDto> hcdList = new ArrayList<>();
        hcdList = jsonResultArrayTemp.toJavaList(StationInfoDto.class);
        for(StationInfoDto sid: hcdList){
            sid.setMethod(method);
        }
//        for(int i = 0; i < jsonResultArrayTemp.size(); i++){
//            String code = jsonResultArrayTemp.getJSONObject(i).getString("station_code");
//            String name = jsonResultArrayTemp.getJSONObject(i).getString("station_name");
//            StationInfoDto wcd = new StationInfoDto(method,code, name);
//            hcdList.add(wcd);
//        }
        return hcdList;
    }

    @Override
    public List parsePlanLoad(String result, String method) {
        JSONObject jsonObjectTemp;
        JSONArray jsonResultArrayTemp;
        jsonObjectTemp = (JSONObject) JSONObject.parse(result);
        jsonResultArrayTemp = (JSONArray) jsonObjectTemp.get("data");
        if(jsonResultArrayTemp == null){
            return new ArrayList();
        }

        List<PlanLoadValue> list;
        list = jsonResultArrayTemp.toJavaList(PlanLoadValue.class);
        for(PlanLoadValue sid: list){
            sid.setMethod(method);
        }
        return list;
    }

    @Override
    public List parseGenOut(String result, String method) {
        JSONObject jsonObjectTemp;
        JSONArray jsonResultArrayTemp;
        jsonObjectTemp = (JSONObject) JSONObject.parse(result);
        jsonResultArrayTemp = (JSONArray) jsonObjectTemp.get("data");
        if(jsonResultArrayTemp == null){
            return new ArrayList();
        }

        List<GenOut> list;
        list = jsonResultArrayTemp.toJavaList(GenOut.class);
        for(GenOut sid: list){
            sid.setMethod(method);
        }
        return list;
    }
    @Override
    public List parseRunTime(String result, String method) {
        JSONObject jsonObjectTemp;
        JSONArray jsonResultArrayTemp;
        jsonObjectTemp = (JSONObject) JSONObject.parse(result);
        jsonResultArrayTemp = (JSONArray) jsonObjectTemp.get("data");
        if(jsonResultArrayTemp == null){
            return new ArrayList();
        }

        List<RunTime> list;
        list = jsonResultArrayTemp.toJavaList(RunTime.class);
        for(RunTime sid: list){
            sid.setMethod(method);
        }
        return list;
    }
    @Override
    public List parseStopTime(String result, String method) {
        JSONObject jsonObjectTemp;
        JSONArray jsonResultArrayTemp;
        jsonObjectTemp = (JSONObject) JSONObject.parse(result);
        jsonResultArrayTemp = (JSONArray) jsonObjectTemp.get("data");
        if(jsonResultArrayTemp == null){
            return new ArrayList();
        }

        List<StopTime> list;
        list = jsonResultArrayTemp.toJavaList(StopTime.class);
        for(StopTime sid: list){
            sid.setMethod(method);
        }
        return list;
    }
    @Override
    public List parseXbTime(String result, String method) {
        JSONObject jsonObjectTemp;
        JSONArray jsonResultArrayTemp;
        jsonObjectTemp = (JSONObject) JSONObject.parse(result);
        jsonResultArrayTemp = (JSONArray) jsonObjectTemp.get("data");
        if(jsonResultArrayTemp == null){
            return new ArrayList();
        }

        List<XbTime> list;
        list = jsonResultArrayTemp.toJavaList(XbTime.class);
        for(XbTime sid: list){
            sid.setMethod(method);
        }
        return list;
    }
}
