package com.bjtu.recovery.service.impl;

import com.bjtu.recovery.entity.AirlineBridgeRate;
import com.bjtu.recovery.mapper.AirlineBridgeRateMapper;
import com.bjtu.recovery.service.IAirlineBridgeRateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineBridgeRateServiceImpl extends ServiceImpl<AirlineBridgeRateMapper, AirlineBridgeRate> implements IAirlineBridgeRateService {

    @Autowired
    private AirlineBridgeRateMapper airlineBridgeRateMapper;

    @Override
    public List<AirlineBridgeRate> getBridgeRateInfo(String airportname, String userId){

        List<AirlineBridgeRate> info = airlineBridgeRateMapper.getBridgeRateInfo(airportname, userId);

        return info;

    }

    @Override
    public Integer insertinfo(String airportname,
                              String airlineCd,
                              String  airlinename,
                              String bridgerate,
                              String userId,
                              String updateTime){

        Integer info = airlineBridgeRateMapper.insertinfo(airportname, airlineCd, airlinename, bridgerate,userId,updateTime);

        return info;

    }

    @Override
    public Integer updateInfo(Integer id,
                              String bridgerate,
                              String  airlinename,
                              String airlineCd,
                              String userId,
                              String updateTime){

        Integer info = airlineBridgeRateMapper.updateInfo(id,  bridgerate,airlinename, airlineCd,userId,updateTime);

        return info;

    }

    @Override
    public Integer batchDelete(Integer id){

        Integer info = airlineBridgeRateMapper.batchDelete(id);

        return info;

    }
}
