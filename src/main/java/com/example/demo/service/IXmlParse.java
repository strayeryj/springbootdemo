package com.example.demo.service;

import com.example.demo.repository.dto.DeviceGroupDto;
import com.example.demo.repository.dto.DeviceHistoryHealthDto;
import com.example.demo.repository.dto.DeviceInfoDto;

import java.util.List;

public interface IXmlParse {

    List<DeviceGroupDto> modelTreeParse(String result);
    List<DeviceInfoDto> modelDetailsParse(String result, String pId);
    List<DeviceHistoryHealthDto> modelDetailsDataSetParse(String result, String route);
}
