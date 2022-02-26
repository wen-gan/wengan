package com.bjtu.recovery.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjtu.recovery.entity.FlightData;
import com.bjtu.recovery.mapper.FlightDataMapper;
import com.bjtu.recovery.service.IFlightDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 */
@Service
public class FlightDataServiceImpl extends ServiceImpl<FlightDataMapper, FlightData> implements IFlightDataService {
    @Autowired
    private FlightDataMapper FlightDataMapper;

    @Override
    public List<FlightData> getinfo() {
        List<FlightData> info = FlightDataMapper.getinfo();
        return info;
    }
}
