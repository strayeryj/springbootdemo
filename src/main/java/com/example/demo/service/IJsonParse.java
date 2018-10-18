package com.example.demo.service;

import com.example.demo.repository.dto.WaterCommon2Dto;
import com.example.demo.repository.dto.WaterCommonDto;
import com.example.demo.repository.dto.WaterDto;

import java.util.List;

public interface IJsonParse {

    List<WaterDto> parseJson(String result);
    List<WaterCommonDto> parseComJson(String result, String method);
    List<WaterCommon2Dto> parseCom2Json(String result, String method);
}
