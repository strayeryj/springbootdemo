package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IPSMapper {

    Integer hourCommon(List list);
    Integer dayCommon(List list);
    
    Integer stationInfo(List list);
    List selectStationInfo();



}
