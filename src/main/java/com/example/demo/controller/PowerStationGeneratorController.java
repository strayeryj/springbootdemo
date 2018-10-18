package com.example.demo.controller;


import com.example.demo.repository.dto.generator.*;
import com.example.demo.repository.dto.powerStation.StationInfoDto;
import com.example.demo.service.IPSParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;


/**
 * 对应文档的 3.2.19 -3.2.35
 */
@Controller
@RequestMapping("/powStaGen")
public class PowerStationGeneratorController {

    @Autowired
    private PowerStationController powerStationController;
    @Autowired
    private PowerStationGroupController powerStationGroupController;
    @Autowired
    private IPSParse ipsParse;
    @Autowired
    private PlanLoadValueMapper planLoadValueMapper;
    @Autowired
    private GenOutMapper genOutMapper;
    @Autowired
    private RunTimeMapper runTimeMapper;
    @Autowired
    private StopTimeMapper stopTimeMapper;
    @Autowired
    private XbTimeMapper xbTimeMapper;

    @RequestMapping("/controlData")
    @ResponseBody
    public String controlData() throws IOException {
//        planLoad("planLoadValue15Min");

//        genOut("companyGenOutDay");
//        genOut("plantGenOutDay");
//        genOut("stationGenOutDay");
//
//        runTime("companyRunTimeDay");
//        runTime("plantRunTimeDay");
//        runTime("stationRunTimeDay");
//
//        stopTime("companyStopTimeDay");
//        stopTime("plantStopTimeDay");
//        stopTime("stationStopTimeDay");

//        xbTime("companyXbTimeDay");
//        xbTime("plantXbTimeDay");
//        xbTime("stationXbTimeDay");

        List<StationInfoDto> siList = powerStationGroupController.getStationInfo();
        for(StationInfoDto sid: siList){
            String code = sid.getStationCode();
//            genOutGroup("lineGenOutDay", code);
//            runTimeGroup("lineRunTimeDay", code);
//            stopTimeGroup("stationStopTimeDay", code);
//            xbTimeGroup("lineXbTimeDay", code);

        }

        return  "success";
    }

    private void planLoad(String method) throws IOException {
        String result = powerStationController.fetchHour(method);
        List list = ipsParse.parsePlanLoad(result, method);
        int num = planLoadValueMapper.insertBatch(list);
        System.out.println(method + " 结果条数: " + num);
    }

    private void genOut(String method) throws IOException {
        String result = powerStationController.fetchDay(method);
        List list = ipsParse.parseGenOut(result, method);
        if(list.size() == 0){
            System.out.println(method + " :没有值");
            return;
        }
        int num = genOutMapper.insert(list);
        System.out.println(method + " 结果条数: " + num);
    }
    private void genOutGroup(String method, String code) throws IOException {
        String result = powerStationGroupController.fetchDay(method, code);
        List list = ipsParse.parseGenOut(result, method);
        if(list.size() == 0){
            System.out.println(method + " 电站: " + code + "没有值");
            return;
        }
        int num = genOutMapper.insert(list);
        System.out.println(method + " 结果条数: " + num);
    }

    private void runTime(String method) throws IOException {
        String result = powerStationController.fetchDay(method);
        List list = ipsParse.parseRunTime(result, method);
        if(list.size() == 0){
            System.out.println(method + " :没有值");
            return;
        }
        int num = runTimeMapper.insert(list);
        System.out.println(method + " 结果条数: " + num);
    }
    private void stopTime(String method) throws IOException {
        String result = powerStationController.fetchDay(method);
        List list = ipsParse.parseStopTime(result, method);
        if(list.size() == 0){
            System.out.println(method + " :没有值");
            return;
        }
        int num = stopTimeMapper.insert(list);
        System.out.println(method + " 结果条数: " + num);
    }
    private void runTimeGroup(String method, String code) throws IOException {
        String result = powerStationGroupController.fetchDay(method, code);
        List list = ipsParse.parseRunTime(result, method);
        if(list.size() == 0){
            System.out.println(method + " 电站: " + code + "没有值");
            return;
        }
        int num = runTimeMapper.insert(list);
        System.out.println(method + " 结果条数: " + num);
    }
    private void stopTimeGroup(String method, String code) throws IOException {
        String result = powerStationGroupController.fetchDay(method, code);
        List list = ipsParse.parseStopTime(result, method);
        if(list.size() == 0){
            System.out.println(method + " 电站: " + code + "没有值");
            return;
        }
        int num = stopTimeMapper.insert(list);
        System.out.println(method + " 结果条数: " + num);
    }


    private void xbTime(String method) throws IOException {
        String result = powerStationController.fetchDay(method);
        List list = ipsParse.parseXbTime(result, method);
        if(list.size() == 0){
            System.out.println(method + " :没有值");
            return;
        }
        int num = xbTimeMapper.insert(list);
        System.out.println(method + " 结果条数: " + num);
    }
    private void xbTimeGroup(String method, String code) throws IOException {
        String result = powerStationGroupController.fetchDay(method, code);
        List list = ipsParse.parseXbTime(result, method);
        if(list.size() == 0){
            System.out.println(method + " 电站: " + code + "没有值");
            return;
        }
        int num = xbTimeMapper.insert(list);
        System.out.println(method + " 结果条数: " + num);
    }




}
