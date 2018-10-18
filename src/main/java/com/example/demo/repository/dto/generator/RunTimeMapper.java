package com.example.demo.repository.dto.generator;

import com.example.demo.repository.dto.generator.powerStation.RunTime;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RunTimeMapper {
    int insert(List record);

    int insertSelective(RunTime record);
}