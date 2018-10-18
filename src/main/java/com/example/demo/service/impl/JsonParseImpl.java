package com.example.demo.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.controller.WaterController;
import com.example.demo.repository.dto.WaterCommon2Dto;
import com.example.demo.repository.dto.WaterCommonDto;
import com.example.demo.repository.dto.WaterDto;
import com.example.demo.service.IJsonParse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class JsonParseImpl implements IJsonParse {

    @Override
    public List<WaterDto> parseJson(String result) {

        JSONObject jsonObjectTemp;
        JSONArray jsonResultArrayTemp;

        jsonObjectTemp = (JSONObject) JSONObject.parse(result);
        jsonResultArrayTemp = (JSONArray) jsonObjectTemp.get("data");
        if(jsonResultArrayTemp == null){
            return  new ArrayList<>();
        }

        // 对象不确定，不能用新for
        /*for(JSONObject obj: jsonResultArrayTemp){
            obj.getString("status");
        }*/

        List<WaterDto> wdList = new ArrayList<>() ;
//        wdList=jsonResultArrayTemp.toJavaList(WaterDto.class);
        for(int i = 0; i < jsonResultArrayTemp.size(); i++){
            String id = UUID.randomUUID().toString().replaceAll("-", "");
            String pointId = jsonResultArrayTemp.getJSONObject(i).getString("POINT_ID");
            String pointName = jsonResultArrayTemp.getJSONObject(i).getString("POINT_NAME");
            String time = jsonResultArrayTemp.getJSONObject(i).getString("DATA_TIME");
            String value = jsonResultArrayTemp.getJSONObject(i).getString("DATA_VALUE");
            WaterDto wd = new WaterDto(id, pointId, pointName, time, value);
            wdList.add(wd);
        }

        return wdList;
    }

    @Override
    public List<WaterCommonDto> parseComJson(String result, String method) {
        JSONObject jsonObjectTemp;
        JSONArray jsonResultArrayTemp;
        jsonObjectTemp = (JSONObject) JSONObject.parse(result);
        jsonResultArrayTemp = (JSONArray) jsonObjectTemp.get("data");

        List<WaterCommonDto> wdList = new ArrayList<>() ;
        for(int i = 0; i < jsonResultArrayTemp.size(); i++){
            String id = UUID.randomUUID().toString().replaceAll("-", "");
            String type = method;
            String pointId = jsonResultArrayTemp.getJSONObject(i).getString("POINT_ID");
            String pointName = jsonResultArrayTemp.getJSONObject(i).getString("POINT_NAME");
            String time = jsonResultArrayTemp.getJSONObject(i).getString("DATA_TIME");
            String value = jsonResultArrayTemp.getJSONObject(i).getString("DATA_VALUE");
            WaterCommonDto wcd = new WaterCommonDto(id,type, pointId, pointName, time, value);
            wdList.add(wcd);
        }
        return wdList;
    }

    @Override
    public List<WaterCommon2Dto> parseCom2Json(String result, String method) {
        JSONObject jsonObjectTemp;
        JSONArray jsonResultArrayTemp;
        jsonObjectTemp = (JSONObject) JSONObject.parse(result);
        jsonResultArrayTemp = (JSONArray) jsonObjectTemp.get("data");

        List<WaterCommon2Dto> wdList = new ArrayList<>() ;
        for(int i = 0; i < jsonResultArrayTemp.size(); i++){
            String id = UUID.randomUUID().toString().replaceAll("-", "");
            String type = method;
            String pointId = jsonResultArrayTemp.getJSONObject(i).getString("POINT_ID");
            String pointName = jsonResultArrayTemp.getJSONObject(i).getString("POINT_NAME");
            String x = jsonResultArrayTemp.getJSONObject(i).getString("X");
            String y1 = jsonResultArrayTemp.getJSONObject(i).getString("Y1");
            String y2 = jsonResultArrayTemp.getJSONObject(i).getString("Y2");
            WaterCommon2Dto wcd = new WaterCommon2Dto(id,type, pointId, pointName, x, y1, y2);
            wdList.add(wcd);
        }
        return wdList;
    }

}
