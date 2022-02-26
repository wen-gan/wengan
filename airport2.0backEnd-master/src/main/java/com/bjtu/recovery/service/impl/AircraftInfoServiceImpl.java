package com.bjtu.recovery.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjtu.recovery.entity.AircraftInfo;
import com.bjtu.recovery.mapper.AircraftInfoMapper;
import com.bjtu.recovery.service.IAircraftInfoService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-01-14
 */
@Service
public class AircraftInfoServiceImpl extends ServiceImpl<AircraftInfoMapper, AircraftInfo> implements IAircraftInfoService {

    @Autowired
    private AircraftInfoMapper AircraftInfoMapper;


    @Override
    public List<AircraftInfo> getAll() {
        List<AircraftInfo> info = AircraftInfoMapper.getAll();
        return info;
    }

    @Override
    public List<JSONObject> getaircraft_infoByapt_name(String apt_name) {
        List<JSONObject> aircraftInfo = AircraftInfoMapper.getaircraft_infoByapt_name(apt_name);

        return aircraftInfo;
    }
}
