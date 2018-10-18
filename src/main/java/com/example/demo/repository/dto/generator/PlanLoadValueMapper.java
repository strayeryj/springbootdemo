package com.example.demo.repository.dto.generator;

import com.example.demo.repository.dto.generator.powerStation.PlanLoadValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlanLoadValueMapper {
    int insert(PlanLoadValue record);

    int insertBatch(List list);
    int insertSelective(PlanLoadValue record);
}