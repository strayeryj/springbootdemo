package com.example.demo.repository;

import com.example.demo.repository.dto.DeviceGroupDto;
import com.example.demo.repository.dto.DeviceHistoryHealthDto;
import com.example.demo.repository.dto.DeviceInfoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  中瑞泰数据提取存储接口映射
 */
@Mapper
public interface IZRTMapper {

    /**
     * 获取各电站设备组数据存入数据库
     * @return 存入条数
     * @param list
     */
    Integer insertDeviceGroup(List<DeviceInfoDto> list);

    /**
     * 获取设备组的route所有数据
     * @return route列表
     */
    List<DeviceGroupDto> selectDeviceGroup();

    /**
     * 获取各电站设备数据存入数据库
     * @return 存入条数
     */
    Integer insertDeviceInfo(List<DeviceInfoDto> list);

    List selectDevice();

    Integer insertDeviceHealthHistory(List<DeviceHistoryHealthDto> list);
    List selectDeviceHealth();
}
