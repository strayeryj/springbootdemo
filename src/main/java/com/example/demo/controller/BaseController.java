package com.example.demo.controller;

import com.example.demo.repository.IZRTMapper;
import com.example.demo.repository.dto.DeviceGroupDto;
import com.example.demo.repository.dto.DeviceHistoryHealthDto;
import com.example.demo.repository.dto.DeviceInfoDto;
import com.example.demo.service.IXmlParse;
import com.example.demo.utils.HttpKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.Null;
import java.io.IOException;
import java.util.*;

/**
 *  中瑞泰的数据处理
 */
@Controller
@RequestMapping("/base")
public class BaseController {

    @Autowired
    private IZRTMapper zrtMapper;

    /** 中瑞泰数据获取项目基路径 */
    private final String BASE_URL = "http://10.176.105.163/iem/IEMWebService.asmx/";

    /** 获取数据的基本参数 */
    private final String USER_NAME = "admin";
    private final String USER_TYPE = "inside";

    /** 获取设备树方法 */
    private final String DATA_METHOD1 = "CreateModelTree";
    /** 获取模型信息方法 */
    private final String DATA_METHOD2 = "GetModelDetails";

    private static final String START_TIME = "2018-01-01 00:00:00";
    private static final String END_TIME = "2018-09-01 00:00:00";

    @Autowired
    private IXmlParse xmlParse;

    @RequestMapping("/welcome")
    public String welcome(){
        System.out.printf("in");
        return "welcome.html";
    }

    @RequestMapping("/getMessage")
    @ResponseBody
    public String getMessage(String id) throws IOException {
        String url = "http://localhost:8888/user/message";
        if("have".equals(id)){
            return "have";
        }
        HttpKit httpKit = new HttpKit();
        String result = httpKit.httpGet(url);

        return result;
    }
    @RequestMapping("/postGroup")
    @ResponseBody
    public String postGroup() throws IOException {
        String url = "http://localhost:8888/user/message";


        HttpKit httpKit = new HttpKit();
        String result = httpKit.httpPost(url);

        return result;
    }


    /**
     *  说明：get方法获取数据,会源项目无法解析中文参数，不能正确获取数据
     * @return
     * @throws IOException
     */
    @RequestMapping("/getTree")
    @ResponseBody
    public String getTree() throws IOException {
        String url = "http://10.176.105.163/iem/IEMWebService.asmx/CreateModelTree?UserName='admin'&UserType='inside'&TreeRoot='设备状态'";
        HttpKit httpKit = new HttpKit();
        String result = httpKit.httpGet(url);
        System.out.println("结果: " + result);

        return result;
    }

    @RequestMapping("/postTree")
    @ResponseBody
    public String postTree() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL).append(DATA_METHOD1);
        String url = sb.toString();
//        String url = "http://10.176.105.163/iem/IEMWebService.asmx/CreateModelTree";

        //入参封装
        Map params = new HashMap<>();
        params.put("UserName", USER_NAME);
        params.put("UserType", USER_TYPE);
        params.put("TreeRoot", "设备状态");

        //根据地址获取中瑞泰设备树
        HttpKit httpKit = new HttpKit();
        String result = httpKit.httpPost(url, params);

        result = result.replace("&lt;?xml version=\"1.0\" encoding=\"utf-8\"?&gt;","");
        String xmlResult = result.replaceAll("&lt;","<").replaceAll("&gt;",">");

        //解析文本，存入数据库，只用存一次就行
//        List<DeviceGroupDto> list = xmlParse.modelTreeParse(xmlResult);
//        int num = zrtMapper.insertDeviceGroup(list);
//        System.out.println(num);

        return xmlResult;
    }

    @RequestMapping("/postModel")
    @ResponseBody
    @Transactional
    public String postModel() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL).append(DATA_METHOD2);
        String url = sb.toString();
        String result;
        String xmlResult = null;

        // 获取各电站设备组列表
        List<DeviceGroupDto> dgList = zrtMapper.selectDeviceGroup();
        for(DeviceGroupDto dgd: dgList){
            Map params = new HashMap<>();
            params.put("UserName", USER_NAME);
            params.put("UserType", USER_TYPE);
            params.put("modelRoute", dgd.getRoute());
            System.out.println(dgd.getRoute());

            HttpKit httpKit = new HttpKit();
            result = httpKit.httpPost(url, params);

            result = result.replace("&lt;?xml version=\"1.0\" encoding=\"utf-8\"?&gt;","");
            xmlResult = result.replaceAll("&lt;","<").replaceAll("&gt;",">");

            //解析文本，存入数据库，只用存一次就行
            List<DeviceInfoDto> parseList = xmlParse.modelDetailsParse(xmlResult, dgd.getId());
//            int num = 0;
//            num += zrtMapper.insertDeviceInfo(parseList);
//            System.out.println(num);
        }

        return xmlResult;
    }



    @RequestMapping("/device")
    @ResponseBody
    @Transactional
    public String getDeviceHealth() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(BASE_URL).append("GetModelDataSet");
        String url = sb.toString();
        String result;
        String xmlResult = null;
        int sum = 0;

        // 获取设备的route
        List<String> dList = zrtMapper.selectDevice();
        for(String route: dList){
            Map params = new HashMap<>();
            params.put("UserName", USER_NAME);
            params.put("UserType", USER_TYPE);
            params.put("Route", route);
            params.put("startTime", START_TIME);
            params.put("endTime", END_TIME);

            HttpKit httpKit = new HttpKit();
            result = httpKit.httpPost(url, params);

            result = result.replace("&lt;?xml version=\"1.0\" encoding=\"utf-8\"?&gt;","");
            xmlResult = result.replaceAll("&lt;","<").replaceAll("&gt;",">");

            // 解析字符串成dto对象
            List<DeviceHistoryHealthDto> parseList = xmlParse.modelDetailsDataSetParse(xmlResult, route);
            if(parseList == null){
                System.out.println(route + ": 没有值");
                continue;
            }

            // 存入数据库
//            int num = zrtMapper.insertDeviceHealthHistory(parseList);
//            sum += num;
//            System.out.println(route + ":" + num);
        }
        System.out.println("总条数:" + sum);

//        Map params = new HashMap<>();
//        String route = "AHM.枕头坝.3号机组.3#水轮机";
//        params.put("UserName", USER_NAME);
//        params.put("UserType", USER_TYPE);
//        params.put("Route", route);
//        params.put("StartTime", "2018-06-10 12:00:00");
//        params.put("EndTime", "2018-06-10 14:00:00");
//
//        HttpKit httpKit = new HttpKit();
//        result = httpKit.httpPost(url, params);
//
//        result = result.replace("&lt;?xml version=\"1.0\" encoding=\"utf-8\"?&gt;","");
//        xmlResult = result.replaceAll("&lt;","<").replaceAll("&gt;",">");
//
//        // 解析字符串成dto对象
//        List<DeviceHistoryHealthDto> parseList = xmlParse.modelDetailsDataSetParse(xmlResult, route);
//        if(parseList == null){
//            System.out.println(route + ": 没有值");
//        }
//        for(DeviceHistoryHealthDto dhhd: parseList){
//            System.out.println(dhhd.toString());
//        }
//        // 存入数据库
//        int num = 0;
//        num += zrtMapper.insertDeviceHealthHistory(parseList);
//        System.out.println(num);

        return "success";
    }

    // -------------------------------------------------------------------------------
    @RequestMapping("/fetchHealth")
    @ResponseBody
    public List fetchHealth(){
        List<DeviceHistoryHealthDto> dList = zrtMapper.selectDeviceHealth();
        for (DeviceHistoryHealthDto dhhd: dList){
            System.out.println(dhhd.toString());
        }

        return dList;
    }

    @RequestMapping("/selectDeviceGroup")
    @ResponseBody
    public List selectDeviceGroup(){
        // 获取设备的route
        List<DeviceGroupDto> dList = zrtMapper.selectDeviceGroup();
        return dList;
    }


    @RequestMapping("/selectDevice")
    @ResponseBody
    public List selectDevice(){
        // 获取设备的route
        List<String> dList = zrtMapper.selectDevice();
        for (Object dhhd: dList){
            System.out.println(dhhd.toString());
        }
        return dList;
    }

    @RequestMapping("/healthRandom")
    @ResponseBody
    public Double healthRandom(){

        int intRandom = (int)(Math.random()*1000);
        double random = (double)intRandom * 0.00001;
        System.out.println(intRandom);
        System.out.println(random);
        System.out.println( Math.random());

        return random;
    }



}
