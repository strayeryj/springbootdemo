package com.example.demo.repository.dto.generator;

import com.example.demo.repository.dto.generator.powerStation.StopTime;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StopTimeMapper {
    int insert(List record);

    int insertSelective(StopTime record);
}