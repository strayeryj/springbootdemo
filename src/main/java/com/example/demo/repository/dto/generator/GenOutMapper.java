package com.example.demo.repository.dto.generator;

import com.example.demo.repository.dto.generator.powerStation.GenOut;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GenOutMapper {
    int insert(List record);

    int insertSelective(GenOut record);
}