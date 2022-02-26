package com.bjtu.recovery.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bjtu.recovery.entity.ManualRecovery;
import com.bjtu.recovery.mapper.ManualRecoveryMapper;
import com.bjtu.recovery.service.IManualRecoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 文淦
 * @version 1.0
 * @since 2022-01-15
 */
@Service
public class ManualRecoveryServiceImpl extends ServiceImpl<ManualRecoveryMapper, ManualRecovery> implements IManualRecoveryService {

    @Autowired
    private ManualRecoveryMapper ManualRecoveryMapper;

    @Override
    public List<Map<String, Object>> getOriginalData() {
        return ManualRecoveryMapper.getOriginalData();
    }

    @Override
    public List<ManualRecovery> getAllFlight() {
        return ManualRecoveryMapper.getAllFlight();
    }

    @Override
    public List<Map<String, Object>> getRecoveryData() {
        return ManualRecoveryMapper.getRecoveryData();
    }

    @Override
    public int insertresultinfo(String aircraft,
                                String dep_airport, String arr_airport,
                                String dep_time, String arr_time) {
        int info = ManualRecoveryMapper.insertresultinfo(aircraft,dep_airport,arr_airport,dep_time,arr_time);
        return info;
    }

    @Override
    public List getResultByModel(String model) {
        List result = ManualRecoveryMapper.getResultByModel(model);
        return result;
    }

    @Override
    public int updateResultinfo(String aircraft,
                                String dep_airport, String arr_airport,
                                String dep_time, String arr_time) {
        int info = ManualRecoveryMapper.updateResultinfo(aircraft,dep_airport,arr_airport,dep_time,arr_time);
        return info;
    }
}
