package com.example.demo.service;

import java.util.List;

public interface IPSParse {
    List parseHourCommon(String result, String method);
    List parseDayCommon(String result, String method);
    List parseStationInfo(String result, String method);

    List parsePlanLoad(String result, String method);
    List parseGenOut(String result, String method);
    List parseRunTime(String result, String method);
    List parseStopTime(String result, String method);
    List parseXbTime(String result, String method);

}
