package com.bjtu.recovery.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bjtu.recovery.entity.FlightInfo;
import com.bjtu.recovery.entity.TestFlight;

import java.util.List;

public interface ITestFlightInfoService extends IService<FlightInfo> {
        List<FlightInfo> getinfo(String filename,String userId);

        List<TestFlight> gettime(String end, String start);

        }
