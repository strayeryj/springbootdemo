package com.example.demo.repository.dto.generator;

import com.example.demo.repository.dto.generator.powerStation.XbTime;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface XbTimeMapper {
    int insert(List record);

    int insertSelective(XbTime record);
}