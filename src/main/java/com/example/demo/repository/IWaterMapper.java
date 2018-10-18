package com.example.demo.repository;

import com.example.demo.repository.dto.WaterCommon2Dto;
import com.example.demo.repository.dto.WaterCommonDto;
import com.example.demo.repository.dto.WaterDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IWaterMapper {

    /**
     *  月入库水量
     * @param list
     * @return
     */
    Integer reservoidCpcHourCommon(List<WaterCommonDto> list);
    Integer reservoidCpcDayCommon(List<WaterCommonDto> list);
    Integer reservoidCpcMonthCommon(List<WaterCommonDto> list);
    Integer reservoidCpcYearCommon(List<WaterCommonDto> list);

    Integer reservoidCpcCommon2(List<WaterCommon2Dto> list);


}
