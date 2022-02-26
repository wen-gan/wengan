package com.bjtu.recovery.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjtu.recovery.entity.FlightInfo;
import com.bjtu.recovery.entity.TestFlight;
import com.bjtu.recovery.mapper.TestFlightInfoMapper;
import com.bjtu.recovery.service.ITestFlightInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//4.19
@Service
public class TestFlightInfoServiceImpl extends ServiceImpl<com.bjtu.recovery.mapper.TestFlightInfoMapper, FlightInfo> implements ITestFlightInfoService {

    @Autowired
    private TestFlightInfoMapper TestFlightInfoMapper;
    @Override
    public List<FlightInfo> getinfo(String filename,String userId) {
        List<FlightInfo> info = TestFlightInfoMapper.getinfo(filename,userId);
        return info;
    }

    public List<TestFlight> gettime(String end, String start){

        List<TestFlight> info = TestFlightInfoMapper.gettime(end, start);

        return info;

    }

}
