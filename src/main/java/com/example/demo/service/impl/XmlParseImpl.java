package com.example.demo.service.impl;

import com.example.demo.repository.dto.DeviceGroupDto;
import com.example.demo.repository.dto.DeviceHistoryHealthDto;
import com.example.demo.repository.dto.DeviceInfoDto;
import com.example.demo.service.IXmlParse;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class XmlParseImpl implements IXmlParse {
    @Override
    public List<DeviceGroupDto> modelTreeParse(String result) {
        // xml节点
        String tree = "TreeNodes";
        String treeChild = "childnodes";
        String treeTarget = "Route";

        // 电站列表
        List<Element> powerStationElements;
        // 电站设备组列表
        List<Element> powerStationDeviceGroupElements;
        // 电站设备组route列表
        List<String> powerStationDeviceList = new ArrayList();
        // 电站设备组route数据转换列表
        List<DeviceGroupDto> dgList = new ArrayList<>();

        SAXReader sr = new SAXReader();
        try {
//            Document doc = sr.read(result);
            Document doc = sr.read(new ByteArrayInputStream(result.getBytes("UTF-8")));
            Element rootElement = doc.getRootElement();
            Element tnl = rootElement.element("ArrayOfTreeNodes");

            powerStationElements = tnl.element(tree).element(treeChild).elements();//枕头坝
            for(Element pse: powerStationElements){
                powerStationDeviceGroupElements = pse.element(treeChild).elements();
                for(Element psdge: powerStationDeviceGroupElements){
                    Element route = psdge.element(treeTarget);
                    String modelGroup = route.getText();
                    powerStationDeviceList.add(modelGroup);
                    dgList.add(new DeviceGroupDto(UUID.randomUUID().toString().replaceAll("-", ""), modelGroup));
                }
            }



//            // 数据测试用
//            for(DeviceGroupDto psd: dgList){
//                System.out.println(psd.toString());
//            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return dgList;
    }

    @Override
    public List<DeviceInfoDto> modelDetailsParse(String result, String pId) {

        List<DeviceInfoDto> DeviceInfoList = new ArrayList<>();

        SAXReader sr = new SAXReader();
        try {
            Document doc = sr.read(new ByteArrayInputStream(result.getBytes("UTF-8")));
            Element rootElement = doc.getRootElement();
            Element tnl = rootElement.element("ArrayOfModelDetails");
            List<Element> modelList = tnl.elements();
            for(Element modelObj: modelList){
                String modelName = modelObj.element("ModelName").getText();
                String hpi = modelObj.element("hpi").getText();
                String time = modelObj.element("Time").getText();
                String similarSet = modelObj.element("SimilarSet").getText();
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                String state = null;
                DeviceInfoDto did = new DeviceInfoDto(uuid,pId, hpi, time, modelName,state,similarSet);

                DeviceInfoList.add(did);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return DeviceInfoList;
    }

    @Override
    public List<DeviceHistoryHealthDto> modelDetailsDataSetParse(String result, String route) {
        List<DeviceHistoryHealthDto> DeviceInfoList = new ArrayList<>();

        SAXReader sr = new SAXReader();
        try {
            Document doc = sr.read(new ByteArrayInputStream(result.getBytes("UTF-8")));
            Element rootElement = doc.getRootElement();
            Element tnl = rootElement.element("Model").element("ModelDataList");
            if(tnl == null){
                return  null;
            }
            List<Element> modelList = tnl.elements();
            for(Element modelObj: modelList){
                String time = modelObj.element("Time").getText();
                String value = modelObj.element("Value").getText();
                DeviceHistoryHealthDto did = new DeviceHistoryHealthDto(route, time, value);

                DeviceInfoList.add(did);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return DeviceInfoList;
    }
}
